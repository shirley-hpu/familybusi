package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserAdd;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户扩展属性信息
 * @date 2018/12/20 11:05
 */
public interface IUserAdd {

    /**
     * 创建用户扩展属性信息
     * @param userAdd
     * @return ReturnDto
     */
    ReturnDto create(UserAdd userAdd) ;

    /**
     * 更新用户扩展属性信息
     * @param userAdd
     * @return ReturnDto
     */
    ReturnDto modify(UserAdd userAdd);

    /**
     * 删除用户扩展属性信息
     * @param userAdd
     * @return ReturnDto
     */
    ReturnDto drop(UserAdd userAdd);

    /**
     * 查询用户扩展属性信息
     * @param idNo,fieldCode
     * @return UserAdd
     */
    UserAdd query(Long idNo,String fieldCode);

    /**
     * 查询用户扩展属性信息
     * @param map
     * @return List<UserAdd>
     */
    List<UserAdd> qryUserAddList(Map map);

    /**
     * 查询用户扩展属性历史信息
     * @param map
     * @return List<UserAdd>
     */
    List<UserAdd> qryUserAddHisList(Map map);

}
