package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserState;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 14:56
 */
public interface IUserState {

    /**
     * 查询用户状态变化信息
     * @param stateChangeNo
     * @return UserState
     */
    UserState query(Long stateChangeNo);

}
