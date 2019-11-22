package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserAdd;

/**
 * @author wusm
 * @description 用户扩展属性信息
 * @date 2018/12/20 11:05
 */
public interface IUserAdd {

    /**
     * 查询用户扩展属性信息
     * @param idNo,fieldCode
     * @return UserAdd
     */
    UserAdd query(Long idNo,String fieldCode);

}
