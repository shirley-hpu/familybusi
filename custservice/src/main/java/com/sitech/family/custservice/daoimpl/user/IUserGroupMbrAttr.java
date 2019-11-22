package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGroupMbrAttr;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 群成员属性实例
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserGroupMbrAttr {


    /**
     * 创建群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    ReturnDto create(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * 删除群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    ReturnDto drop(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * 更新群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    ReturnDto modify(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * 查询群成员属性实例
     *
     * @param memberId,attrId,effDate,attrNo
     * @return UserGroupMbrAttr
     */
    UserGroupMbrAttr query(BigDecimal memberId, String attrId, Date effDate, String attrNo);

    /**
     * 查询群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    List<UserGroupMbrAttr> qryUserGroupMbrAttrList(Map map);

    /**
     * 查询历史群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    List<UserGroupMbrAttr> qryUserGroupMbrAttrHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userGroupMbrAttr
     * @return
     */
    ReturnDto updateFinishState(UserGroupMbrAttr userGroupMbrAttr);
}
