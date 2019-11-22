package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.User;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户信息
 * @date 2018/12/19 17:33
 */
public interface IUser {

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
     * 手机号码查询已订购附加信息
     * @param map
     * @return list
     */
    List qryOrderFeeByPhoneNo(Map map);
}
