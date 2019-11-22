package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroup;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import com.sitech.family.custqryservice.mapper.IUserGroupMapper;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/21 10:43
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGroupImpl implements IUserGroup {

    @Autowired
    private IUserGroupMapper mapper;

    /**
     * 查询群实例
     *
     * @param groupId
     * @return UserGroup
     */
    @Override
    public UserGroup query(BigDecimal groupId) {
        UserGroup userGroup = new UserGroup();

        try {
            userGroup = mapper.query(groupId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询群实例失败" + e.getMessage());
        }

        return userGroup;
    }

    /**
     * 查询群实例
     *
     * @param map
     * @return List<UserGroup>
     */
    @Override
    public List<UserGroup> qryUserGroupList(Map map) {
        List<UserGroup> list;

        try {
            list = mapper.qryUserGroupList(map);
            return list;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }

}
