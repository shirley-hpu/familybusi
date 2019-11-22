package com.sitech.family.custqryservice.compbusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyGoodsPrcDictInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserInfo;
import com.sitech.family.custqryservice.compbusi.IFamilyUserBasicInfoCo;
import com.sitech.family.custqryservice.dto.mapperdto.PdGoodsPrcDict;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;


@Component
public class FamilyUserBasicInfoCo implements IFamilyUserBasicInfoCo {
    @Resource
    private IFamilyGoodsPrcDictInfo iFamilyGoodsPrcDictInfo;
    @Resource
    private IFamilyUserGroupInfo iFamilyUserGroupInfo;
    @Resource(name="familyUserInfo")
    private IFamilyUserInfo iFamilyUserInfo;
    @Resource
    private IFamilyUserGoodsInfo iFamilyUserGoodsInfo;

    private static final Logger logger = LoggerFactory.getLogger(FamilyUserBasicInfoCo.class);
    @Override
    public Map<String, Object> qryFamilyUserBasicInfo(Map<String, Object> map) {
        try {
            long idNo = Long.parseLong((String)map.get("ID_NO"));

            Map inMap = new HashMap();
            inMap.put("idNo",idNo);

            UserInfo userInfo = iFamilyUserInfo.qryFamilyUserBasicInfo(inMap);
            UserGroupInfo userGroupInfo = iFamilyUserGroupInfo.qryUserGroupInfo(inMap);
            UserGoodsInfo userGoodsInfo = iFamilyUserGoodsInfo.qryFamilyUserBasicInfo(inMap);

            if(userGoodsInfo != null){
                inMap.clear();
                inMap.put("prcId",userGoodsInfo.getPrcId());
                logger.debug("XXXXXXXXXXXXXXX"+userGoodsInfo.getPrcId()+"XXXXXXXXXXXXXXXXXX");
            }

            PdGoodsPrcDict userGoodsPrcInfo = iFamilyGoodsPrcDictInfo.qryGoodsPrcDictInfo(inMap);

            Map<String,Object> dataMap = new HashMap<>();
            logger.debug("*************"+dataMap);
            if(userInfo != null || userGoodsPrcInfo != null || userGroupInfo != null){
                dataMap.put("ID_NO",userInfo.getIdNo());
                dataMap.put("PHONE_NO",userInfo.getPhoneNo());
                dataMap.put("CUST_Id",userInfo.getCustId());
                dataMap.put("CONTRACT_NO",userInfo.getContractNo());
                dataMap.put("OPEN_TIME",userInfo.getOpenTime());

                dataMap.put("GROUP_ID",userGroupInfo.getGroupId());
                dataMap.put("GROUP_CODE",userGroupInfo.getGroupCode());
                dataMap.put("GROUP_TYPE",userGroupInfo.getGroupType());
                dataMap.put("GROUP_NAME",userGroupInfo.getGroupName());
                dataMap.put("GROUP_DESC",userGroupInfo.getGroupDesc());

                dataMap.put("EFF_DATE",userGoodsPrcInfo.getEffDate());
                dataMap.put("EXP_DATE",userGoodsPrcInfo.getExpDate());
                dataMap.put("GOODS_ID",userGoodsPrcInfo.getGoodsId());
                dataMap.put("GOODS_INS_ID","");
                dataMap.put("PRC_ID",userGoodsPrcInfo.getPrcId());
                dataMap.put("GOODS_NAME",userGoodsPrcInfo.getPrcName());
                dataMap.put("GOODS_DESC",userGoodsPrcInfo.getGoodsPrcDesc());
            }

            Map<String,Object> outMap = new HashMap<>();
            outMap.put("FamilyUserBasicInfo",dataMap);
            logger.debug("*************"+outMap);
            return outMap;
        }catch (Exception e){
            throw new BusiException(getErrorCode("1000","15000"),"co查询失败"+e.getMessage());
        }

    }
}
