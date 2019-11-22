package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGroup;
import com.sitech.family.custservice.dto.mapperdto.UserGroup;
import com.sitech.family.custservice.mapper.IUserGroupMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/21 10:43
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGroupImpl implements IUserGroup {

    @Autowired
    private IUserGroupMapper mapper;

    /**
     * 创建群实例
     *
     * @param userGroup
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserGroup userGroup) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userGroup);

            mapper.insert(userGroup);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新群实例
     *
     * @param userGroup
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserGroup userGroup) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal groupId = userGroup.getGroupId();
            UserGroup userGroup1 = mapper.query(groupId);

            if (StringUtil.isEmptyOrNull(userGroup1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新群实例失败");
                return returnDto;
            }

            userGroup1.setUpdateAccept(userGroup.getUpdateAccept());
            userGroup1.setUpdateType(userGroup.getUpdateType());
            userGroup1.setUpdateTime(userGroup.getUpdateTime());
            userGroup1.setUpdateDate(userGroup.getUpdateDate());
            userGroup1.setUpdateLogin(userGroup.getUpdateLogin());
            userGroup1.setUpdateCode(userGroup.getUpdateCode());

            mapper.insert(userGroup1);

            mapper.modify(userGroup);

            userGroup.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userGroup);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改群实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改群实例成功");
        return returnDto;
    }

    /**
     * 删除群实例
     *
     * @param userGroup
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserGroup userGroup) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal groupId = userGroup.getGroupId();
            UserGroup userGroup1 = mapper.query(groupId);

            if (StringUtil.isEmptyOrNull(userGroup1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除群实例失败");
                return returnDto;
            }

            userGroup1.setUpdateAccept(userGroup.getUpdateAccept());
            userGroup1.setUpdateType(userGroup.getUpdateType());
            userGroup1.setUpdateTime(userGroup.getUpdateTime());
            userGroup1.setUpdateDate(userGroup.getUpdateDate());
            userGroup1.setUpdateLogin(userGroup.getUpdateLogin());
            userGroup1.setUpdateCode(userGroup.getUpdateCode());

            mapper.insert(userGroup1);

            mapper.drop(groupId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除群实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除群实例成功");
        return returnDto;
    }

    /**
     * 查询群实例
     *
     * @param groupId
     * @return UserGroup
     */
    @Override
    public UserGroup query(BigDecimal groupId) {
        UserGroup userGroup = new UserGroup();

        try {
            userGroup = mapper.query(groupId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询群实例失败" + e.getMessage());
        }

        return userGroup;
    }

    /**
     * 查询群实例
     *
     * @param map
     * @return List<UserGroup>
     */
    @Override
    public List<UserGroup> qryUserGroupList(Map map) {
        List<UserGroup> list = new ArrayList<>();

        try {
            list = mapper.qryUserGroupList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询群实例失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询群实例
     *
     * @param map
     * @return List<UserGroup>
     */
    @Override
    public List<UserGroup> qryUserGroupHisList(Map map) {
        List<UserGroup> list = new ArrayList<>();

        try {
            list = mapper.qryUserGroupHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询群实例失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userGroup
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserGroup userGroup) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userGroup.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserGroup> userGroupList = mapper.qryUserGroupList(map);

            if (userGroupList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(userGroup);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
