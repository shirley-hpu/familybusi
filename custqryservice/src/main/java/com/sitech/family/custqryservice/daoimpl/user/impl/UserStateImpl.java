package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserState;
import com.sitech.family.custqryservice.dto.mapperdto.UserState;
import com.sitech.family.custqryservice.mapper.IUserStateMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

}
