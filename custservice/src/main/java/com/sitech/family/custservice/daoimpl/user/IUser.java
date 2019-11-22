package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户信息
 * @date 2018/12/19 17:33
 */
public interface IUser {

    /**
     * 创建用户信息
     * @param user
     * @return ReturnDto
     */
    ReturnDto create(User user) ;

    /**
     * 更新用户信息
     * @param user
     * @return ReturnDto
     */
    ReturnDto modify(User user);

    /**
     * 删除用户信息
     * @param user
     * @return ReturnDto
     */
    ReturnDto drop(User user);

    /**
     * 查询用户信息
     * @param idNo
     * @return User
     */
    User query(Long idNo);

    /**
     * 查询用户信息
     * @param map
     * @return List<User>
     */
    List<User> qryUserList(Map map);

    /**
     * 查询历史用户信息
     * @param map
     * @return List<User>
     */
    List<User> qryUserHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param user
     * @return
     */
    ReturnDto updateFinishState(User user);
}
