package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGroupMbrAttr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 群成员属性实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserGroupMbrAttrMapper {

    /**
     * @param userGroupMbrAttr
     * @return
     */
    void drop(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * @param userGroupMbrAttr
     * @return
     */
    void create(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * @param userGroupMbrAttr
     * @return
     */
    void insert(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * @param memberId,attrId,effDate,attrNo
     * @return UserGroupMbrAttr
     */
    UserGroupMbrAttr query(@Param("memberId") BigDecimal memberId,@Param("attrId") String attrId,@Param("effDate") Date effDate,@Param("attrNo") String attrNo);

    /**
     * @param userGroupMbrAttr
     * @return
     */
    void modify(UserGroupMbrAttr userGroupMbrAttr);

    /**
     * 查询群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    List<UserGroupMbrAttr> qryUserGroupMbrAttrList(@Param("params") Map map);

    /**
     * 查询历史群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    List<UserGroupMbrAttr> qryUserGroupMbrAttrHisList(@Param("inparams") Map map);


    /**
     * 根据idNo更新状态
     * @param userGroupMbrAttr
     * @return
     */
    void updateFinishState(UserGroupMbrAttr userGroupMbrAttr);

}
