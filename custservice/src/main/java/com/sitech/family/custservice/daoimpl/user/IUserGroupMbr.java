package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.dto.ReturnDto;

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
     * 创建群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    ReturnDto create(UserGroupMbr userGroupMbr);

    /**
     * 删除群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    ReturnDto drop(UserGroupMbr userGroupMbr);

    /**
     * 更新群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    ReturnDto modify(UserGroupMbr userGroupMbr);

    /**
     * 查询群成员实例信息
     *
     * @param memberId
     * @return UserGroupMbr
     */
    UserGroupMbr query(BigDecimal memberId);

    /**
     * 查询群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    List<UserGroupMbr> qryUserGroupMbrList(Map map);

    /**
     * 查询历史群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    List<UserGroupMbr> qryUserGroupMbrHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userGroupMbr
     * @return
     */
    ReturnDto updateFinishState(UserGroupMbr userGroupMbr);

    /**
     * 查询短流程订单
     * @param map
     * @return
     */
    List<UserGroupMbr> qryShortProcessList(Map map);
}
