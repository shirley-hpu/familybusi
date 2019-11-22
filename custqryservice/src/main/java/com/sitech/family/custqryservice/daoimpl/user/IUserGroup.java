package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import com.sitech.family.dto.usergroup.UserGroupInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 群实例
 * @date 2018/12/21 10:39
 */
public interface IUserGroup {

    /**
     * 查询群实例
     * @param groupId
     * @return UserGroup
     */
    UserGroup query(BigDecimal groupId);

    /**
     * 查询群实例
     * @param map
     * @return List<UserGroup>
     */
    List<UserGroup> qryUserGroupList(Map map);

}
