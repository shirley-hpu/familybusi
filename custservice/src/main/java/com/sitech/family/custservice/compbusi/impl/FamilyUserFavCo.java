package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.common.constants.*;
import com.sitech.family.common.pubdto.FamilyUserApplyInfo;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.IFamilyUserFavAttrInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserFavInfo;
import com.sitech.family.custservice.base.util.BaseLoginAccept;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.base.util.SequenceConst;
import com.sitech.family.custservice.compbusi.IFamilyUserFavCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavAttrInfo;
import com.sitech.family.dto.usergoods.UserFavInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记录用户优惠订购实例及优惠参数实例
 */
@Component
public class FamilyUserFavCo implements IFamilyUserFavCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyUserFavCo.class);

    @Autowired
    private IFamilyUserFavInfo familyUserFavInfoImpl;

    @Autowired
    private IFamilyUserFavAttrInfo familyUserFavAttrInfoImpl;

    @Autowired
    private BaseLoginAccept baseLoginAccept;


    @Transactional(rollbackFor = BusiException.class)
    @Override
    public ReturnDto create(Map<String, Object> map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数对象不存在或为空!");
        }

        try {
            // 1、获取参数节点
            String state = (String) map.get("STATE");
            OprInfo oprInfo = (OprInfo) map.get("OPR_INFO");
            FamilyUserApplyInfo userApplyInfo = (FamilyUserApplyInfo) map.get("USER_INFO");

            //获取用户优惠订购实例节点
            List<FamilyUserApplyInfo.FamilyUserFavInfo> familyUserFavInfoList = userApplyInfo.getFamilyUserFavInfo();

            //***** 获取序列值入参map *****//
            Map<String, String> accept = new HashMap<>();

            //循环取USERFAVINFOLIST
            for (FamilyUserApplyInfo.FamilyUserFavInfo familyUserFavInfo : familyUserFavInfoList) {
                UserFavInfo userFavInfo = new UserFavInfo();
                userFavInfo.setFavId(familyUserFavInfo.getFavId());
                userFavInfo.setFavType(familyUserFavInfo.getFavType());
                userFavInfo.setFavtempId(familyUserFavInfo.getFavtempId());
                userFavInfo.setEffDate(DateUtil.toDate(familyUserFavInfo.getEffDate(), DateConst.DATE_MODEL_8));
                userFavInfo.setExpDate(DateUtil.toDate(familyUserFavInfo.getExpDate(), DateConst.DATE_MODEL_8));

                userFavInfo.setSvcObjType(SvcObjTypeEnum.VAL_1.getValue()); //服务对象类型
                userFavInfo.setSvcObjValue(SvcObjTypeEnum.VAL_1.getValue()); //服务对象值
                userFavInfo.setFavObjType(FavObjTypeEnum.VAL_1.getValue()); //优惠对象类型
                userFavInfo.setFavObjValue(FavObjTypeEnum.VAL_1.getValue()); //优惠对象值 当优惠对象类型为1，2时,默认为0
                userFavInfo.setOpsourceType(OpsourTypeEnum.VAL_1.getValue()); //优惠来源类型
                userFavInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                userFavInfo.setLoginNo(oprInfo.getLoginNo());
                userFavInfo.setOpCode(oprInfo.getOpCode());
                userFavInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                userFavInfo.setMbrType(MbrTypeEnum.VAL_1001.getValue()); //成员类型
                userFavInfo.setMbrRole(MbrRoleEnum.VAL_60002.getValue()); //成员角色
                userFavInfo.setAttrId("优惠参数"); //优惠参数
                userFavInfo.setOpsourceValue(""); //优惠来源值
                userFavInfo.setServOrderId("1"); //订单行号
                userFavInfo.setFavinsId(BigDecimal.ONE); //优惠实例标识 序列获取
                //***** 获取序列值 *****//
                //优惠实例标识
                //accept.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_GOODSINS_ID);
                //String favinsId = baseLoginAccept.getPubLoginAccept(accept);
                //logger.debug("favinsId ==> " + favinsId);

                ReturnDto returnDto = familyUserFavInfoImpl.create(userFavInfo);

                if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                    return returnDto;
                }

                //循环取USERFAVATTRINFOLIST节点
                List<FamilyUserApplyInfo.FamilyUserFavAttrInfo> familyUserFavAttrInfoList = familyUserFavInfo.getFamilyUserFavAttrInfoList();

                for (FamilyUserApplyInfo.FamilyUserFavAttrInfo familyUserFavAttrInfo : familyUserFavAttrInfoList) {
                    UserFavAttrInfo userFavAttrInfo = new UserFavAttrInfo();
                    userFavAttrInfo.setAttrId(familyUserFavAttrInfo.getAttrId());
                    userFavAttrInfo.setAttrValue(familyUserFavAttrInfo.getAttrValue());
                    userFavAttrInfo.setEffDate(DateUtil.toDate(familyUserFavInfo.getEffDate(), DateConst.DATE_MODEL_8));
                    userFavAttrInfo.setExpDate(DateUtil.toDate(familyUserFavInfo.getExpDate(), DateConst.DATE_MODEL_8));
                    userFavAttrInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                    userFavAttrInfo.setLoginNo(oprInfo.getLoginNo());
                    userFavAttrInfo.setOpCode(oprInfo.getOpCode());
                    userFavAttrInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                    userFavAttrInfo.setServOrderId("1"); //订单行号
                    userFavAttrInfo.setFavinsId(BigDecimal.ONE); //优惠实例标识

                    ReturnDto result = familyUserFavAttrInfoImpl.create(userFavAttrInfo);

                    if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(result.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(result.getMessage());
                        return returnDto;
                    }
                }
            }
        } catch (Exception e) {
            ReturnDto result = new ReturnDto();
            result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        //返回方法信息
        ReturnDto result = new ReturnDto();
        result.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return result;
    }
}
