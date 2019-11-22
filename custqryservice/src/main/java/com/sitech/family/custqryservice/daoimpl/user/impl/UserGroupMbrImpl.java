package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.custqryservice.mapper.UserGroupMbrMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
public class UserGroupMbrImpl implements IUserGroupMbr {

    @Autowired
    private UserGroupMbrMapper userGroupMbrMapper;

    /**
     * 查询群成员实例信息
     *
     * @param memberId
     * @return UserGroupMbr
     */
    @Override
    public UserGroupMbr query(BigDecimal memberId) {
        UserGroupMbr userGroupMbr = new UserGroupMbr();

        try {
            userGroupMbr = userGroupMbrMapper.query(memberId);
        } catch (Exception e) {
            throw new BusiException("查询群成员实例信息失败:" + e.getMessage());
        }

        return userGroupMbr;
    }

    @Override
    public List<UserGroupMbr> queryFamilyGroupMbr(Map map) {
        List<UserGroupMbr> list = new ArrayList<UserGroupMbr>();
        try {
            list = userGroupMbrMapper.queryFamilyGroupMbr(map);
        }catch (Exception e){
            throw new BusiException("查询群成员实例信息失败:" + e.getMessage());
        }
        return list;
    }
}
