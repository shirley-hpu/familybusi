package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 群实例
 * @date 2018/12/21 10:45
 */
@Repository
public interface IUserGroupMapper {

    /**
     * 新增群实例
     * @param userGroup
     * @return null
     */
    void create(UserGroup userGroup) ;

    /**
     * 新增历史表群实例
     * @param userGroup
     * @return null
     */
    void insert(UserGroup userGroup);

    /**
     * 更新群实例
     * @param userGroup
     * @return null
     */
    void modify(UserGroup userGroup);

    /**
     * 删除群实例
     * @param groupId
     * @return null
     */
    void drop(BigDecimal groupId);

    /**
     * 查询群实例
     * @param groupId
     * @return UserGroup
     */
    UserGroup query(BigDecimal groupId);

    /**
     * 查询历史表群实例
     * @param map
     * @return List<UserGroup>
     */
    List<UserGroup> qryUserGroupList(@Param("params") Map map);

    /**
     * 查询历史表群实例
     * @param map
     * @return List<UserGroup>
     */
    List<UserGroup> qryUserGroupHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userGroup
     * @return
     */
    void updateFinishState(UserGroup userGroup);
}
