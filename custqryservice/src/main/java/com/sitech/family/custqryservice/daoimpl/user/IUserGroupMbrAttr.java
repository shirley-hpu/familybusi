package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbrAttr;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 群成员属性实例
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserGroupMbrAttr {

    /**
     * 查询群成员属性实例
     *
     * @param memberId,attrId,effDate,attrNo
     * @return UserGroupMbrAttr
     */
    UserGroupMbrAttr query(BigDecimal memberId, String attrId, Date effDate, String attrNo);
}
