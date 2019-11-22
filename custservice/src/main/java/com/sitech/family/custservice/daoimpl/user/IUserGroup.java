package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGroup;
import com.sitech.family.dto.ReturnDto;

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
     * 创建群实例
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto create(UserGroup userGroup) ;

    /**
     * 更新群实例
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto modify(UserGroup userGroup);

    /**
     * 删除群实例
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto drop(UserGroup userGroup);

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

    /**
     * 查询历史群实例
     * @param map
     * @return List<UserGroup>
     */
    List<UserGroup> qryUserGroupHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userGroup
     * @return
     */
    ReturnDto updateFinishState(UserGroup userGroup);
}
