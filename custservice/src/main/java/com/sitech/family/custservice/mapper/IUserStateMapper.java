package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserState;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 15:08
 */
@Repository
public interface IUserStateMapper {

    /**
     * 新增用户状态变化信息
     * @param userState
     * @return
     */
    void create(UserState userState) ;

    /**
     * 新增历史表用户状态变化信息
     * @param userState
     * @return
     */
    void insert(UserState userState);

    /**
     * 更新用户状态变化信息
     * @param userState
     * @return
     */
    void modify(UserState userState);

    /**
     * 删除用户状态变化信息
     * @param stateChangeNo
     * @return null
     */
    void drop(Long stateChangeNo);

    /**
     * 查询用户状态变化信息
     * @param stateChangeNo
     * @return User
     */
    UserState query(Long stateChangeNo);

    /**
     * 查询用户状态变化信息
     * @param map
     * @return List<UserState>
     */
    List<UserState> qryUserStateList(@Param("params") Map map);

    /**
     * 查询历史表用户状态变化信息
     * @param map
     * @return List<UserState>
     */
    List<UserState> qryUserStateHisList(@Param("inparams") Map map);
}
