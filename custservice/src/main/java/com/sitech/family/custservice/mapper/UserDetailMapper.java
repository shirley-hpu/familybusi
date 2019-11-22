package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserDetailMapper {

    /**
     * 创建用户详细信息
     *
     * @param userDetail
     * @return
     */
    void create(UserDetail userDetail);

    /**
     * 创建历史表用户详细信息
     *
     * @param userDetail
     * @return
     */
    void insert(UserDetail userDetail);

    /**
     * 删除用户详细信息
     *
     * @param userDetail
     * @return
     */
    void drop(UserDetail userDetail);

    /**
     * 更新用户详细信息
     *
     * @param userDetail
     * @return
     */
    void modify(UserDetail userDetail);

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return UserDetail
     */
    UserDetail query(Long idNo);

    /**
     * 查询用户详细信息
     * @param map
     * @return List<UserDetail>
     */
    List<UserDetail> qryUserDetailList(@Param("params") Map map);

    /**
     * 查询历史用户详细信息
     * @param map
     * @return List<UserDetail>
     */
    List<UserDetail> qryUserDetailHisList(@Param("inparams") Map map);
}
