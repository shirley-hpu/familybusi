package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.usergroup.UserGroupMbrInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IUserGroupMbrInfoQryDao {


    /**
     * 查询
     *
     * @param memberId
     * @return
     */
    UserGroupMbrInfo query(BigDecimal memberId);

    /**
     * @param map
     * @return
     */
    List<UserGroupMbrInfo> qryUserGroupMbrInfoList(Map map);

}
