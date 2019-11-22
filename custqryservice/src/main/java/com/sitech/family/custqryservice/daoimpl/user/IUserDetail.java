package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserDetail;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserDetail {

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return UserDetail
     */
    UserDetail query(Long idNo);

}
