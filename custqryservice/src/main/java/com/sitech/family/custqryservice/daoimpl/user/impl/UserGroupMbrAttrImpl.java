package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroupMbrAttr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbrAttr;
import com.sitech.family.custqryservice.mapper.UserGroupMbrAttrMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
public class UserGroupMbrAttrImpl implements IUserGroupMbrAttr {

    @Autowired
    private UserGroupMbrAttrMapper userGroupMbrAttrMapper;

    /**
     * 查询群成员属性实例
     *
     * @param memberId
     * @param attrId
     * @param effDate
     * @param attrNo
     * @return UserGroupMbrAttr
     */
    @Override
    public UserGroupMbrAttr query(BigDecimal memberId, String attrId, Date effDate, String attrNo) {
        UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();

        try {
            userGroupMbrAttr = userGroupMbrAttrMapper.query(memberId, attrId, effDate, attrNo);
        } catch (Exception e) {
            throw new BusiException("查询群成员属性实例失败:" + e.getMessage());
        }

        return userGroupMbrAttr;
    }

}
