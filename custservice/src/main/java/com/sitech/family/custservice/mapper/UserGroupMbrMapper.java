package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.dto.ReturnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserGroupMbrMapper {

    /**
     * @param memberId
     * @return
     */
    void drop(BigDecimal memberId);

    /**
     * @param userGroupMbr
     * @return
     */
    void create(UserGroupMbr userGroupMbr);

    /**
     * @param userGroupMbr
     * @return
     */
    void insert(UserGroupMbr userGroupMbr);

    /**
     * @param memberId
     * @return
     */
    UserGroupMbr query(BigDecimal memberId);

    /**
     * @param userGroupMbr
     * @return
     */
    void modify(UserGroupMbr userGroupMbr);

    /**
     * 查询群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    List<UserGroupMbr> qryUserGroupMbrList(@Param("params") Map map);

    /**
     * 查询历史群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    List<UserGroupMbr> qryUserGroupMbrHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userGroupMbr
     * @return
     */
    void updateFinishState(UserGroupMbr userGroupMbr);

    /**
     * 查询短流程订单
     * @param map
     * @return
     */
    List<UserGroupMbr> qryShortProcessList(@Param("params") Map map);
}
