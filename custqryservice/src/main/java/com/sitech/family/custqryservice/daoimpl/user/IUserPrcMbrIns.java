package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserPrcMbrIns;

import java.math.BigDecimal;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserPrcMbrIns {

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param memberId,prodPrcInsId
     * @return UserPrcMbrIns
     */
    UserPrcMbrIns query(BigDecimal memberId, BigDecimal prodPrcInsId);
}
