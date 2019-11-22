package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.usergroup.UserGroupInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:27
 */
public interface IUserGroupInfoQryDao {

    /**
     * 查询家庭用户群用户
     *
     * @param groupId
     * @return userGroup
     */
    UserGroupInfo query(BigDecimal groupId);

    /**
     * @param map
     * @return
     */
    List<UserGroupInfo> qryUserGroupInfoList(Map map);

}
