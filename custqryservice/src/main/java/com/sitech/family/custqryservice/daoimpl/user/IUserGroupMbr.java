package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbr;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
public interface IUserGroupMbr {

    /**
     * 查询群成员实例信息
     *
     * @param memberId
     * @return UserGroupMbr
     */
    UserGroupMbr query(BigDecimal memberId);
    List<UserGroupMbr> queryFamilyGroupMbr(Map map);
}
