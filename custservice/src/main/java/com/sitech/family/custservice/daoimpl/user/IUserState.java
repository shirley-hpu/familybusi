package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserState;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 14:56
 */
public interface IUserState {

    /**
     * 创建用户状态变化信息
     * @param userState
     * @return UserState
     */
    ReturnDto create(UserState userState) ;

    /**
     * 更新用户状态变化信息
     * @param userState
     * @return UserState
     */
    ReturnDto modify(UserState userState);

    /**
     * 删除用户状态变化信息
     * @param userState
     * @return UserState
     */
    ReturnDto drop(UserState userState);

    /**
     * 查询用户状态变化信息
     * @param stateChangeNo
     * @return UserState
     */
    UserState query(Long stateChangeNo);

    /**
     * 查询用户状态变化信息
     * @param map
     * @return List<UserState>
     */
    List<UserState> qryUserStateList(Map map);

    /**
     * 查询用户状态变化信息
     * @param map
     * @return List<UserState>
     */
    List<UserState> qryUserStateHisList(Map map);
}
