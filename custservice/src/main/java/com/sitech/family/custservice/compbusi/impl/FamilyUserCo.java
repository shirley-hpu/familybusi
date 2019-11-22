package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.RunCodeEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.*;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.compbusi.IFamilyUserCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.common.pubdto.FamilyUserApplyInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.family.dto.user.UserServiceNoInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 组合服务:用户资料落地
 *
 * @author shirley
 * @date created in 2019/2/26
 */
@Component
public class FamilyUserCo implements IFamilyUserCo {

    //家庭用户
    private final IFamilyUserInfo familyUserInfoImpl;

    //家庭用户接入信息
    private final IFamilyServiceNoInfo familyServiceNoInfoImpl;

    //家庭群用户信息
    private final IFamilyUserGroupInfo familyUserGroupInfoImpl;

    @Autowired
    public FamilyUserCo(IFamilyUserInfo familyUserInfoImpl, IFamilyServiceNoInfo familyServiceNoInfoImpl, IFamilyUserGroupInfo familyUserGroupInfoImpl) {
        this.familyUserInfoImpl = familyUserInfoImpl;
        this.familyServiceNoInfoImpl = familyServiceNoInfoImpl;
        this.familyUserGroupInfoImpl = familyUserGroupInfoImpl;
    }


    @Transactional(rollbackFor = BusiException.class)
    @Override
    public ReturnDto create(Map<String, Object> map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数对象不存在或为空!");
        }

        ReturnDto result;

        try {
            // 1、获取参数节点
            String state = (String) map.get("STATE");
            OprInfo oprInfo = (OprInfo) map.get("OPR_INFO");
            FamilyUserApplyInfo userApplyInfo = (FamilyUserApplyInfo) map.get("USER_INFO");
            FamilyUserApplyInfo.FamilyUserGroupInfo familyUserGroupInfo = userApplyInfo.getFamilyUserGroupInfo();

            // 2、拼接逻辑实体参数
            // 2.1、用户信息
            UserInfo userInfo = new UserInfo();
            userInfo.setIdNo(Long.valueOf(userApplyInfo.getIdNo()));
            userInfo.setContractNo(Long.valueOf(userApplyInfo.getContractNo()));
            userInfo.setPhoneNo(userApplyInfo.getPhoneNo());
            userInfo.setCustId(Long.valueOf(userApplyInfo.getCustId()));
            userInfo.setEmpId(userApplyInfo.getEmpId());
            userInfo.setEmpGroup(userApplyInfo.getEmpGroup());
            userInfo.setOpNote(oprInfo.getOpNote());
            userInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userInfo.setOpCode(oprInfo.getOpCode());
            userInfo.setLoginNo(oprInfo.getLoginNo());
            userInfo.setLoginAccept(Long.valueOf(oprInfo.getLoginAccept()));
            userInfo.setGroupId(oprInfo.getGroupId());
            userInfo.setSystemNote(oprInfo.getSystemNote());
            userInfo.setOupAccept(oprInfo.getOutAccept());
            userInfo.setUserPasswd("123456");//客户服务密码 默认值
            userInfo.setRunCode(RunCodeEnum.A.getValue());//用户状态 枚举值
            userInfo.setRunTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));//用户状态变化时间 取订单时间
            userInfo.setOldRun(RunCodeEnum.A.getValue());//旧用户状态  调用私有服务获取

            //根据状态标识是否生效，决定档案状态是否生效
            if (StateEnum.VAL_A.getValue().equals(state)) {
                userInfo.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());//档案状态 枚举值
            } else {
                userInfo.setFinishFlag(FinishFlagEnum.VAL_N.getValue());//档案状态 枚举值
            }

            userInfo.setFinishTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));//归档时间 取订单时间
            userInfo.setOpenTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));//创建时间 第一次创建 取订单时间
            userInfo.setCreateLogin(oprInfo.getLoginNo());//创建人 订单入参
            userInfo.setCreateGroup(null);//创建人归属 订单入参
            ReturnDto returnDto = familyUserInfoImpl.create(userInfo);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                result = new ReturnDto();
                result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                result.setMessage(returnDto.getMessage());
                return result;
            }

            // 2.2、家庭用户接入信息
            UserServiceNoInfo userServiceNoInfo = new UserServiceNoInfo();
            userServiceNoInfo.setIdNo(Long.parseLong(userApplyInfo.getIdNo()));
            userServiceNoInfo.setServiceNo(userApplyInfo.getPhoneNo());
            //userServiceNoInfo.setServiceType(); //SERVICE_TYPE固定为01（代表开户号码自身）
            userServiceNoInfo.setOpNote(oprInfo.getOpNote());
            userServiceNoInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userServiceNoInfo.setOpCode(oprInfo.getOpCode());
            userServiceNoInfo.setLoginNo(oprInfo.getLoginNo());
            userServiceNoInfo.setLoginAccept(Long.valueOf(oprInfo.getLoginAccept()));
            userServiceNoInfo.setSystemNote(oprInfo.getSystemNote());
            userServiceNoInfo.setOupAccept(oprInfo.getOutAccept());
            ReturnDto returnDto2 = familyServiceNoInfoImpl.create(userServiceNoInfo);
            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto2.getCode())) {
                result = new ReturnDto();
                result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                result.setMessage(returnDto.getMessage());
                return result;
            }

            // 2.3、群用户信息
            UserGroupInfo userGroupInfo = new UserGroupInfo();
            userGroupInfo.setGroupId(BigDecimal.valueOf(Long.parseLong(familyUserGroupInfo.getGroupId().trim())));
            userGroupInfo.setGroupCode(familyUserGroupInfo.getGroupCode());
            userGroupInfo.setGroupDesc(familyUserGroupInfo.getGroupDesc());
            userGroupInfo.setGroupName(familyUserGroupInfo.getGroupName());
            userGroupInfo.setGroupType(familyUserGroupInfo.getGroupType());
            userGroupInfo.setIdNo(Long.valueOf(userApplyInfo.getIdNo()));
            userGroupInfo.setOpNote(oprInfo.getOpNote());
            userGroupInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGroupInfo.setOpCode(oprInfo.getOpCode());
            userGroupInfo.setLoginNo(oprInfo.getLoginNo());
            userGroupInfo.setLoginAccept(Long.valueOf(oprInfo.getLoginAccept()));
            userGroupInfo.setSystemNote(oprInfo.getSystemNote());
            userGroupInfo.setOutAccept(oprInfo.getOutAccept());
            userGroupInfo.setUseAddress(familyUserGroupInfo.getUserAddress());
            // 用户状态
            userGroupInfo.setState(state);
            userGroupInfo.setStateDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            ReturnDto returnDto1 = familyUserGroupInfoImpl.create(userGroupInfo);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto1.getCode())) {
                result = new ReturnDto();
                result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                result.setMessage(returnDto1.getMessage());
                return result;
            }

        } catch (Exception e) {
            result = new ReturnDto();
            result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        // 返回方法信息
        result = new ReturnDto();
        result.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return result;
    }

    /**
     * 查询是否竣工
     *
     * @param map
     * @return UserInfo
     */
    @Override
    public Map getUserFinishFlag(Map<String, Object> map) {
        Map<String, String> retMap = new HashMap<String, String>();

        try {
            Long idNo = Long.valueOf(String.valueOf(map.get("idNo"))).longValue();

            UserInfo userInfo = familyUserInfoImpl.query(idNo);

            if (StringUtil.isEmptyOrNull(userInfo.getFinishFlag())) {
                retMap.put("RETURN_CODE", "-9999");
                retMap.put("RETURN_MSG", "查无数据,请检查入参稍候重试");
                return retMap;
            }

            if ("Y".equals(userInfo.getFinishFlag())) {
                retMap.put("RETURN_CODE", "-9999");
                retMap.put("RETURN_MSG", "该订单已竣工,请不要重复操作");
                return retMap;
            }
        } catch (Exception e) {
            retMap.put("RETURN_CODE", "-9999");
            retMap.put("RETURN_MSG", e.getMessage());
            return retMap;
        }

        return retMap;
    }

    /**
     * 更新竣工标志
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public ReturnDto updateFinishState(Map<String, Object> map) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UpdateOprInfo updateOprInfo = (UpdateOprInfo) map.get("oprInfo");
            Long idNo = Long.valueOf(String.valueOf(map.get("idNo"))).longValue();

            returnDto = familyUserInfoImpl.updateFinishState(updateOprInfo,idNo);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            returnDto = familyServiceNoInfoImpl.updateFinishState(updateOprInfo,idNo);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            returnDto = familyUserGroupInfoImpl.updateFinishState(updateOprInfo,idNo);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            return returnDto;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新竣工标志失败" + e.getMessage());
        }
    }
}
