package com.sitech.family.custqryservice.compbusi.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.atombusi.IFamilyGoodsPrcDictInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserInfo;
import com.sitech.family.custqryservice.compbusi.IFamilyMainRoleGroupQryCo;
import com.sitech.family.custqryservice.dto.mapperdto.PdGoodsPrcDict;
import com.sitech.family.custqryservice.dto.outdto.FamilyGroupInfo;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主号家庭信息查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:03
 */
@Component
public class FamilyMainRoleGroupQryCo implements IFamilyMainRoleGroupQryCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyMainRoleGroupQryCo.class);

    // 家庭用户信息
    @Resource
    private IFamilyUserInfo familyUserInfo;
    // 家庭用户详细信息
    @Resource(name="familyUserDetailInfo")
    private IFamilyUserInfo familyUserDetailInfo;
    // 群用户信息
    @Resource
    private IFamilyUserGroupInfo familyUserGroupInfo;
    // 商品订购信息
    @Resource
    private IFamilyUserGoodsInfo familyUserGoodsInfo;
    // 商品资费信息
    @Resource
    private IFamilyGoodsPrcDictInfo familyGoodsPrcDictInfo;

    /**
     * @param map
     * @return List<UserGroupInfo>
     * @throws
     * @date 2019/7/30 下午3:04
     */
    @Override
    public List<FamilyGroupInfo> query(Map<String, Object> map) {

        List<FamilyGroupInfo> familyGroupList= new ArrayList<FamilyGroupInfo>();

        try {
            // 1.根据手机号码查询主号所在的家庭用户信息
            List<UserInfo> userInfoList = familyUserInfo.qryUserInfoList(map);
            // 循环主号所在的家庭，根据IdNo查询其它信息
            for(UserInfo userInfo:userInfoList){
                Long idNo = userInfo.getIdNo();
                // 2.根据idno查询群用户信息
                Map<String,Object> userGroupQryParam = new HashMap<String,Object>();
                userGroupQryParam.put("idNo",idNo);
                List<UserGroupInfo> userGroupInfoList = familyUserGroupInfo.qryUserGroupInfoList(userGroupQryParam);
                // 不判断 list 是否为空，因为群用户信息肯定有,而且肯定是一个，这里直接取第0个
                UserGroupInfo userGroupInfo = userGroupInfoList.get(0);
                // 3. 根据idno查询家庭商品订购信息 -- 调用过程中返回值似乎有问题
                UserGoodsInfo userGoodsInfo = familyUserGoodsInfo.qryFamilyUserBasicInfo(userGroupQryParam);
                // 4. 从家庭商品订购信息中拿到goodsId和prcId,去pd_goodsprc_dict字典表中查询资费信息
                userGroupQryParam.put("prcId",userGoodsInfo.getPrcId());
                userGroupQryParam.put("goodsId",userGoodsInfo.getGoodsId());
                PdGoodsPrcDict pdGoodsPrcDict = familyGoodsPrcDictInfo.qryGoodsPrcDictInfo(userGroupQryParam);
                // 5.userDetail中查询家庭用户状态runcode
                UserInfo userDetail = familyUserDetailInfo.query(idNo);
                // 拼装出参数据
                FamilyGroupInfo familyGroupInfo = new FamilyGroupInfo();
                if(userInfo!=null){
                    familyGroupInfo.setIdNo(String.valueOf(userInfo.getIdNo()));
                    familyGroupInfo.setPhoneNo(userInfo.getPhoneNo());
                    familyGroupInfo.setContractNo(String.valueOf(userInfo.getContractNo()));
                    familyGroupInfo.setCustId(String.valueOf(userInfo.getCustId()));
                    familyGroupInfo.setOpenTime(userInfo.getOpenTime());
                }
                if(userDetail!=null) {
                    familyGroupInfo.setRunCode(userDetail.getRunCode());
                }
                if(userGroupInfo!=null) {
                    familyGroupInfo.setGroupId(userGroupInfo.getGroupId());
                    familyGroupInfo.setGroupCode(userGroupInfo.getGroupCode());
                    familyGroupInfo.setGroupType(userGroupInfo.getGroupType());
                    familyGroupInfo.setGroupName(userGroupInfo.getGroupName());
                    familyGroupInfo.setGroupDesc(userGroupInfo.getGroupDesc());
                }
                if(pdGoodsPrcDict!=null) {
                    familyGroupInfo.setGoodsName(pdGoodsPrcDict.getPrcName());
                    familyGroupInfo.setGoodsType(pdGoodsPrcDict.getPrcType());
                    familyGroupInfo.setGoodsDesc(pdGoodsPrcDict.getGoodsPrcDesc());
                    familyGroupInfo.setGoodsId(pdGoodsPrcDict.getGoodsId());
                    familyGroupInfo.setGoodsPrcId(pdGoodsPrcDict.getPrcId());
                }
                familyGroupList.add(familyGroupInfo);
            }

            return familyGroupList;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }
}