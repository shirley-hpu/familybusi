package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserState;
import com.sitech.family.custservice.dto.mapperdto.UserState;
import com.sitech.family.custservice.mapper.IUserStateMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 15:04
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserStateImpl implements IUserState {

    @Autowired
    private IUserStateMapper mapper;

    /**
     * 创建用户状态变化信息
     *
     * @param userState
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserState userState) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userState);

            mapper.insert(userState);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "创建用户状态变化信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建用户状态变化信息成功");
        return returnDto;
    }

    /**
     * 更新用户状态变化信息
     *
     * @param userState
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserState userState) {
        ReturnDto returnDto = new ReturnDto();

        try {

            UserState userState1 = mapper.query(userState.getStateChangeNo());

            if (StringUtil.isEmptyOrNull(userState1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户状态变化信息失败");
                return returnDto;
            }

            userState1.setUpdateAccept(userState.getUpdateAccept());
            userState1.setUpdateType(userState.getUpdateType());
            userState1.setUpdateTime(userState.getUpdateTime());
            userState1.setUpdateDate(userState.getUpdateDate());
            userState1.setUpdateLogin(userState.getUpdateLogin());
            userState1.setUpdateCode(userState.getUpdateCode());

            mapper.insert(userState1);

            mapper.modify(userState);

            userState.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userState);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户状态变化信息失败");
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户状态变化信息成功");
        return returnDto;
    }

    /**
     * 删除用户状态变化信息
     *
     * @param userState
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserState userState) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long stateChangeNo = userState.getStateChangeNo();
            UserState userState1 = mapper.query(stateChangeNo);

            if (StringUtil.isEmptyOrNull(userState1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户状态变化信息失败");
                return returnDto;
            }

            userState1.setUpdateAccept(userState.getUpdateAccept());
            userState1.setUpdateType(userState.getUpdateType());
            userState1.setUpdateTime(userState.getUpdateTime());
            userState1.setUpdateDate(userState.getUpdateDate());
            userState1.setUpdateLogin(userState.getUpdateLogin());
            userState1.setUpdateCode(userState.getUpdateCode());

            mapper.insert(userState1);

            mapper.drop(stateChangeNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户状态变化信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户状态变化信息成功");
        return returnDto;
    }

    /**
     * 查询用户状态变化信息
     *
     * @param stateChangeNo
     * @return UserState
     */
    @Override
    public UserState query(Long stateChangeNo) {
        UserState userState = new UserState();

        try {
            userState = mapper.query(stateChangeNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态变化信息失败"+e.getMessage());
        }

        return userState;
    }

    /**
     * 查询用户状态变化信息
     *
     * @param map
     * @return List<UserState>
     */
    @Override
    public List<UserState> qryUserStateList(Map map) {
        List<UserState> list = new ArrayList<>();

        try {
            list = mapper.qryUserStateList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态变化信息失败"+e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户状态变化信息
     *
     * @param map
     * @return List<UserState>
     */
    @Override
    public List<UserState> qryUserStateHisList(Map map) {
        List<UserState> list = new ArrayList<>();

        try {
            list = mapper.qryUserStateHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态变化信息失败"+e.getMessage());
        }

        return list;
    }
}
