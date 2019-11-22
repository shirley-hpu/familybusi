package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.LockFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class UserGroupMbrInfoDaoImpl implements IUserGroupMbrInfoDao {

    @Autowired
    private IUserGroupMbr userGroupMbrImpl;

    @Override
    public ReturnDto create(UserGroupMbrInfo userGroupMbrInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroupMbr userGroupMbr = new UserGroupMbr();

            userGroupMbr.setMemberId(userGroupMbrInfo.getMemberId());
            userGroupMbr.setMemberDesc(userGroupMbrInfo.getMemberDesc());
            userGroupMbr.setMemberName(userGroupMbrInfo.getMemberName());
            userGroupMbr.setGroupId(userGroupMbrInfo.getGroupId());
            userGroupMbr.setMbrRole(userGroupMbrInfo.getMbrRole());
            userGroupMbr.setMbrType(userGroupMbrInfo.getMbrType());
            userGroupMbr.setElementId(userGroupMbrInfo.getElementId());
            userGroupMbr.setObjectType(userGroupMbrInfo.getObjectType());
            userGroupMbr.setObjectId(userGroupMbrInfo.getObjectId());
            userGroupMbr.setEffDate(userGroupMbrInfo.getEffDate());
            userGroupMbr.setExpDate(userGroupMbrInfo.getExpDate());
            userGroupMbr.setLoginAccept(userGroupMbrInfo.getLoginAccept());
            userGroupMbr.setLoginNo(userGroupMbrInfo.getLoginNo());
            userGroupMbr.setOpCode(userGroupMbrInfo.getOpCode());
            userGroupMbr.setOpTime(userGroupMbrInfo.getOpTime());
            userGroupMbr.setState(userGroupMbrInfo.getState());
            userGroupMbr.setStateDate(userGroupMbrInfo.getOpTime());
            userGroupMbr.setLockFlag(LockFlagEnum.VAL_0.getValue());
            userGroupMbr.setPhoneNo(userGroupMbrInfo.getPhoneNo());
            userGroupMbr.setUpdateAccept(new Random().nextLong());
            userGroupMbr.setUpdateCode("1");
            userGroupMbr.setUpdateDate(1);
            userGroupMbr.setUpdateLogin("1");
            userGroupMbr.setUpdateTime(userGroupMbrInfo.getOpTime());
            userGroupMbr.setUpdateType(UpdateTypeEnum.VAL_A.getValue());
            if ("A".equals(userGroupMbrInfo.getState())) {
                userGroupMbr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroupMbr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }
            userGroupMbr.setShortNum("1");

            userGroupMbrImpl.create(userGroupMbr);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(UserGroupMbrInfo userGroupMbrInfo) {

        if (StringUtil.isEmptyOrNull(userGroupMbrInfo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserGroupMbr userGroupMbr = new UserGroupMbr();

            userGroupMbr.setMemberId(userGroupMbrInfo.getMemberId());
            userGroupMbr.setMemberDesc(userGroupMbrInfo.getMemberDesc());
            userGroupMbr.setMemberName(userGroupMbrInfo.getMemberName());
            userGroupMbr.setGroupId(userGroupMbrInfo.getGroupId());
            userGroupMbr.setMbrRole(userGroupMbrInfo.getMbrRole());
            userGroupMbr.setMbrType(userGroupMbrInfo.getMbrType());
            userGroupMbr.setElementId(userGroupMbrInfo.getElementId());
            userGroupMbr.setObjectType(userGroupMbrInfo.getObjectType());
            userGroupMbr.setObjectId(userGroupMbrInfo.getObjectId());
            userGroupMbr.setEffDate(userGroupMbrInfo.getEffDate());
            userGroupMbr.setExpDate(userGroupMbrInfo.getExpDate());
            userGroupMbr.setLoginAccept(userGroupMbrInfo.getLoginAccept());
            userGroupMbr.setLoginNo(userGroupMbrInfo.getLoginNo());
            userGroupMbr.setOpCode(userGroupMbrInfo.getOpCode());
            userGroupMbr.setOpTime(userGroupMbrInfo.getOpTime());
            userGroupMbr.setState(userGroupMbrInfo.getState());
            userGroupMbr.setStateDate(userGroupMbrInfo.getOpTime());
            userGroupMbr.setPhoneNo(userGroupMbrInfo.getPhoneNo());
            userGroupMbr.setLockFlag(LockFlagEnum.VAL_0.getValue());
            userGroupMbr.setUpdateAccept(new Random().nextLong());
            userGroupMbr.setUpdateCode("1");
            userGroupMbr.setUpdateDate(1);
            userGroupMbr.setUpdateLogin("1");
            userGroupMbr.setUpdateTime(userGroupMbrInfo.getOpTime());
            userGroupMbr.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            if ("A".equals(userGroupMbrInfo.getState())) {
                userGroupMbr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroupMbr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }


            userGroupMbr.setShortNum("1001");

            userGroupMbrImpl.modify(userGroupMbr);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(UserGroupMbrInfo userGroupMbrInfoDto) {
        if (StringUtil.isEmptyOrNull(userGroupMbrInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            UserGroupMbr userGroupMbr = new UserGroupMbr();
            userGroupMbr.setMemberId(userGroupMbrInfoDto.getMemberId());
            userGroupMbr.setUpdateAccept(new Random().nextLong());
            userGroupMbr.setUpdateCode("1");
            userGroupMbr.setUpdateDate(1);
            userGroupMbr.setUpdateLogin("1");
            userGroupMbr.setUpdateTime(userGroupMbrInfoDto.getOpTime());
            userGroupMbr.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            userGroupMbrImpl.drop(userGroupMbr);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public UserGroupMbrInfo query(BigDecimal memberId) {
        if (StringUtil.isEmptyOrNull(memberId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroupMbr userGroupMbr = userGroupMbrImpl.query(memberId);

            if (StringUtil.isEmptyOrNull(userGroupMbr)) {
                return new UserGroupMbrInfo();
            }

            UserGroupMbrInfo userGroupMbrInfo = new UserGroupMbrInfo();
            userGroupMbrInfo.setEffDate(userGroupMbr.getEffDate());
            userGroupMbrInfo.setExpDate(userGroupMbr.getExpDate());
            userGroupMbrInfo.setGroupId(userGroupMbr.getGroupId());
            userGroupMbrInfo.setLoginAccept(userGroupMbr.getLoginAccept());
            userGroupMbrInfo.setLoginNo(userGroupMbr.getLoginNo());
            userGroupMbrInfo.setMemberDesc(userGroupMbr.getMemberDesc());
            userGroupMbrInfo.setMemberId(userGroupMbr.getMemberId());
            userGroupMbrInfo.setMbrRole(userGroupMbr.getMbrRole());
            userGroupMbr.setMbrType(userGroupMbrInfo.getMbrType());
            userGroupMbr.setElementId(userGroupMbrInfo.getElementId());
            userGroupMbrInfo.setMemberName(userGroupMbr.getMemberName());
            userGroupMbrInfo.setObjectId(userGroupMbr.getObjectId());
            userGroupMbrInfo.setObjectType(userGroupMbr.getObjectType());
            userGroupMbrInfo.setOpCode(userGroupMbr.getOpCode());
            userGroupMbrInfo.setOpTime(userGroupMbr.getOpTime());
            userGroupMbrInfo.setPhoneNo(userGroupMbr.getPhoneNo());
            userGroupMbrInfo.setRelMemberId(new BigDecimal("1"));
            userGroupMbrInfo.setOpNote("1");
            userGroupMbrInfo.setOutAccept("1");
            userGroupMbrInfo.setSystemNote("1");
            return userGroupMbrInfo;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
        }
    }

    @Override
    public List<UserGroupMbrInfo> qryUserGroupMbrInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserGroupMbrInfo> userGroupMbrInfoList = new ArrayList<UserGroupMbrInfo>();

        try {
            List<UserGroupMbr> userGroupMbrList = userGroupMbrImpl.qryUserGroupMbrList(map);

            if (userGroupMbrList.isEmpty()) {
                return new ArrayList<UserGroupMbrInfo>();
            }

            for (UserGroupMbr userGroupMbr : userGroupMbrList) {
                UserGroupMbrInfo userGroupMbrInfo = new UserGroupMbrInfo();
                userGroupMbrInfo.setMemberId(userGroupMbr.getMemberId());
                userGroupMbrInfo.setRelMemberId(BigDecimal.valueOf(1));
                userGroupMbrInfo.setGroupId(userGroupMbr.getGroupId());
                userGroupMbrInfo.setMbrRole(userGroupMbr.getMbrRole());
                userGroupMbr.setMbrType(userGroupMbrInfo.getMbrType());
                userGroupMbr.setElementId(userGroupMbrInfo.getElementId());
                userGroupMbrInfo.setObjectType(userGroupMbr.getObjectType());
                userGroupMbrInfo.setObjectId(userGroupMbr.getObjectId());
                userGroupMbrInfo.setMemberDesc(userGroupMbr.getMemberDesc());
                userGroupMbrInfo.setMemberName(userGroupMbr.getMemberName());
                userGroupMbrInfo.setEffDate(userGroupMbr.getEffDate());
                userGroupMbrInfo.setExpDate(userGroupMbr.getExpDate());
                userGroupMbrInfo.setOpTime(userGroupMbr.getOpTime());
                userGroupMbrInfo.setOpCode(userGroupMbr.getOpCode());
                userGroupMbrInfo.setLoginNo(userGroupMbr.getLoginNo());
                userGroupMbrInfo.setLoginAccept(userGroupMbr.getLoginAccept());
                userGroupMbrInfo.setOutAccept("1");
                userGroupMbrInfo.setOpNote("1");
                userGroupMbrInfo.setSystemNote("1");
                userGroupMbrInfo.setPhoneNo(userGroupMbr.getPhoneNo());
                userGroupMbrInfo.setState(userGroupMbr.getState());
                userGroupMbrInfo.setStateDate(userGroupMbr.getStateDate());

                userGroupMbrInfoList.add(userGroupMbrInfo);
            }
        } catch (Exception e) {
            return new ArrayList<UserGroupMbrInfo>();
        }

        return userGroupMbrInfoList;
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroupMbr userGroupMbr = new UserGroupMbr();
            userGroupMbr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            userGroupMbr.setState(StateEnum.VAL_A.getValue());
            userGroupMbr.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGroupMbr.setObjectId(idNo);
            userGroupMbr.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGroupMbr.setLoginNo(updateOprInfo.getLoginNo());
            userGroupMbr.setOpCode(updateOprInfo.getOpCode());
            userGroupMbr.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = userGroupMbrImpl.updateFinishState(userGroupMbr);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 查询短流程订单
     *
     * @param map
     * @return
     */
    @Override
    public List<UserGroupMbrInfo> qryShortProcessList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserGroupMbrInfo> userGroupMbrInfoList = new ArrayList<UserGroupMbrInfo>();

        try {
            List<UserGroupMbr> userGroupMbrList = userGroupMbrImpl.qryShortProcessList(map);

            if (userGroupMbrList.isEmpty()) {
                return new ArrayList<UserGroupMbrInfo>();
            }

            for (UserGroupMbr userGroupMbr : userGroupMbrList) {
                UserGroupMbrInfo userGroupMbrInfo = new UserGroupMbrInfo();
                userGroupMbrInfo.setMemberId(userGroupMbr.getMemberId());
                userGroupMbrInfo.setRelMemberId(BigDecimal.valueOf(1));
                userGroupMbrInfo.setGroupId(userGroupMbr.getGroupId());
                userGroupMbrInfo.setMbrRole(userGroupMbr.getMbrRole());
                userGroupMbr.setMbrType(userGroupMbrInfo.getMbrType());
                userGroupMbr.setElementId(userGroupMbrInfo.getElementId());
                userGroupMbrInfo.setObjectType(userGroupMbr.getObjectType());
                userGroupMbrInfo.setObjectId(userGroupMbr.getObjectId());
                userGroupMbrInfo.setMemberDesc(userGroupMbr.getMemberDesc());
                userGroupMbrInfo.setMemberName(userGroupMbr.getMemberName());
                userGroupMbrInfo.setEffDate(userGroupMbr.getEffDate());
                userGroupMbrInfo.setExpDate(userGroupMbr.getExpDate());
                userGroupMbrInfo.setOpTime(userGroupMbr.getOpTime());
                userGroupMbrInfo.setOpCode(userGroupMbr.getOpCode());
                userGroupMbrInfo.setLoginNo(userGroupMbr.getLoginNo());
                userGroupMbrInfo.setLoginAccept(userGroupMbr.getLoginAccept());
                userGroupMbrInfo.setOutAccept("1");
                userGroupMbrInfo.setSystemNote("1");
                userGroupMbrInfo.setOpNote("1");
                userGroupMbrInfo.setPhoneNo(userGroupMbr.getPhoneNo());
                userGroupMbrInfo.setState(userGroupMbr.getState());
                userGroupMbrInfo.setStateDate(userGroupMbr.getStateDate());

                userGroupMbrInfoList.add(userGroupMbrInfo);
            }
        } catch (Exception e) {
            return new ArrayList<UserGroupMbrInfo>();
        }

        return userGroupMbrInfoList;
    }
}
