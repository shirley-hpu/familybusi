package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.LockFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUserGroup;
import com.sitech.family.custservice.dto.mapperdto.UserGroup;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 16:01
 */
@Component
public class UserGroupInfoDaoImpl implements IUserGroupInfoDao {

    private static Logger logger = LoggerFactory.getLogger(UserGroupInfoDaoImpl.class);

    @Autowired
    private IUserGroup iUserGroup;

    /**
     * 新增家庭群用户信息
     *
     * @param userGroupInfo
     */
    @Override
    public ReturnDto create(UserGroupInfo userGroupInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroup userGroup = new UserGroup();
            userGroup.setState(userGroupInfo.getState());
            userGroup.setLockFlag(LockFlagEnum.VAL_0.getValue());
            if (StateEnum.VAL_A.getValue().equals(userGroupInfo.getState())) {
                userGroup.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroup.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }
            userGroup.setExpDate(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            userGroup.setStateDate(userGroupInfo.getStateDate());
            userGroup.setOpCode(userGroupInfo.getOpCode());
            userGroup.setLoginNo(userGroupInfo.getLoginNo());
            userGroup.setGroupType(userGroupInfo.getGroupType());
            userGroup.setGroupName(userGroupInfo.getGroupName());
            userGroup.setGroupId(userGroupInfo.getGroupId());
            userGroup.setGroupDesc(userGroupInfo.getGroupDesc());
            userGroup.setGroupCode(userGroupInfo.getGroupCode());
            userGroup.setEffDate(userGroupInfo.getOpTime());
            userGroup.setIdNo(userGroupInfo.getIdNo());
            userGroup.setLoginAccept(userGroupInfo.getLoginAccept());
            userGroup.setOpTime(userGroupInfo.getOpTime());

            userGroup.setUpdateType(UpdateTypeEnum.VAL_A.getValue());
            userGroup.setUpdateAccept(new Random().nextLong());
            userGroup.setUpdateCode("0");
            userGroup.setUpdateDate(0);
            userGroup.setUpdateLogin("0");
            userGroup.setUpdateTime(userGroupInfo.getOpTime());

            ReturnDto returnDto1 = iUserGroup.create(userGroup);
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto1.getCode())) {
                returnDto1.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto1.setMessage(returnDto1.getMessage());
                return returnDto1;
            }

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
            //throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 修改家庭群用户信息
     *
     * @param userGroupInfo
     * @return userGroup
     */
    @Override
    public ReturnDto modify(UserGroupInfo userGroupInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroup userGroup = new UserGroup();
            userGroup.setState(userGroupInfo.getState());
            userGroup.setOpCode(userGroupInfo.getOpCode());
            userGroup.setLoginNo(userGroupInfo.getLoginNo());
            userGroup.setLockFlag(LockFlagEnum.VAL_0.getValue());
            userGroup.setGroupType(userGroupInfo.getGroupType());
            userGroup.setGroupName(userGroupInfo.getGroupName());
            userGroup.setGroupId(userGroupInfo.getGroupId());
            userGroup.setGroupDesc(userGroupInfo.getGroupDesc());
            userGroup.setGroupCode(userGroupInfo.getGroupCode());
            if ("A".equals(userGroupInfo.getState())) {
                userGroup.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroup.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }
            userGroup.setEffDate(userGroupInfo.getOpTime());
            userGroup.setExpDate(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            userGroup.setIdNo(userGroupInfo.getIdNo());
            userGroup.setLoginAccept(userGroupInfo.getLoginAccept());
            userGroup.setOpTime(userGroupInfo.getOpTime());
            userGroup.setStateDate(userGroupInfo.getStateDate());

            userGroup.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            userGroup.setUpdateAccept(new Random().nextLong());
            userGroup.setUpdateCode("1");
            userGroup.setUpdateDate(1);
            userGroup.setUpdateLogin("1");
            userGroup.setUpdateTime(userGroupInfo.getOpTime());

            iUserGroup.modify(userGroup);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 删除家庭群用户信息
     *
     * @param userGroupInfo
     */
    @Override
    public ReturnDto drop(UserGroupInfo userGroupInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroup userGroup = new UserGroup();
            userGroup.setGroupId(userGroupInfo.getGroupId());
            userGroup.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            userGroup.setUpdateAccept(new Random().nextLong());
            userGroup.setUpdateCode("1");
            userGroup.setUpdateDate(1);
            userGroup.setUpdateLogin("1");
            userGroup.setUpdateTime(userGroupInfo.getOpTime());

            returnDto = iUserGroup.drop(userGroup);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 查询家庭用户群用户
     *
     * @param groupId
     * @return userGroup
     */
    @Override
    public UserGroupInfo query(BigDecimal groupId) {
        if (StringUtil.isEmptyOrNull(groupId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroup userGroup = iUserGroup.query(groupId);

            if (StringUtil.isEmptyOrNull(userGroup)) {
                return new UserGroupInfo();
            }

            UserGroupInfo userGroupInfo = new UserGroupInfo();
            userGroupInfo.setGroupId(userGroup.getGroupId());
            userGroupInfo.setIdNo(userGroup.getIdNo());
            userGroupInfo.setGroupCode(userGroup.getGroupCode());
            userGroupInfo.setGroupType(userGroup.getGroupType());
            userGroupInfo.setGroupName(userGroup.getGroupName());
            userGroupInfo.setGroupDesc(userGroup.getGroupDesc());
            userGroupInfo.setOpTime(userGroup.getOpTime());
            userGroupInfo.setOpCode(userGroup.getOpCode());
            userGroupInfo.setLoginNo(userGroup.getLoginNo());
            userGroupInfo.setLoginAccept(userGroup.getLoginAccept());
            userGroupInfo.setState(userGroup.getState());
            userGroupInfo.setStateDate(userGroup.getStateDate());
            userGroupInfo.setUseAddress("1");
            userGroupInfo.setOutAccept("1");
            userGroupInfo.setOpNote("1");
            userGroupInfo.setSystemNote("1");

            return userGroupInfo;
        } catch (Exception e) {
            return new UserGroupInfo();
        }
    }

    @Override
    public List<UserGroupInfo> qryUserGroupInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserGroupInfo> userGroupInfoList = new ArrayList<UserGroupInfo>();
        try {
            List<UserGroup> userGroupList = iUserGroup.qryUserGroupList(map);

            if (userGroupList.isEmpty()) {
                return new ArrayList<UserGroupInfo>();
            }

            for (UserGroup userGroup : userGroupList) {
                UserGroupInfo userGroupInfo = new UserGroupInfo();

                userGroupInfo.setState(userGroup.getState());
                userGroupInfo.setStateDate(userGroup.getStateDate());
                userGroupInfo.setGroupDesc(userGroup.getGroupDesc());
                userGroupInfo.setGroupName(userGroup.getGroupName());
                userGroupInfo.setGroupType(userGroup.getGroupType());
                userGroupInfo.setGroupCode(userGroup.getGroupCode());
                userGroupInfo.setIdNo(userGroup.getIdNo());
                userGroupInfo.setUseAddress("1");
                userGroupInfo.setGroupId(userGroup.getGroupId());
                userGroupInfo.setSystemNote("1");
                userGroupInfo.setOpNote("1");
                userGroupInfo.setOpTime(userGroup.getOpTime());
                userGroupInfo.setOpCode(userGroup.getOpCode());
                userGroupInfo.setLoginNo(userGroup.getLoginNo());
                userGroupInfo.setLoginAccept(userGroup.getLoginAccept());
                userGroupInfo.setOutAccept("1");

                userGroupInfoList.add(userGroupInfo);
            }

            return userGroupInfoList;
        } catch (Exception e) {
            return new ArrayList<UserGroupInfo>();
        }
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroup userGroup = new UserGroup();
            userGroup.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            userGroup.setState(StateEnum.VAL_A.getValue());
            userGroup.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGroup.setIdNo(idNo);
            userGroup.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGroup.setLoginNo(updateOprInfo.getLoginNo());
            userGroup.setOpCode(updateOprInfo.getOpCode());
            userGroup.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserGroup.updateFinishState(userGroup);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
