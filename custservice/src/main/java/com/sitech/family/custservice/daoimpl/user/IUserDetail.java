package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserDetail {

    /**
     * 创建用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    ReturnDto create(UserDetail userDetail);

    /**
     * 删除用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    ReturnDto drop(UserDetail userDetail);

    /**
     * 更新用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    ReturnDto modify(UserDetail userDetail);

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return
     */
    UserDetail query(Long idNo);

    /**
     * 查询用户详细信息
     * @param map
     * @return List<UserDetail>
     */
    List<UserDetail> qryUserDetailList(Map map);

    /**
     * 查询历史用户详细信息
     * @param map
     * @return List<UserDetail>
     */
    List<UserDetail> qryUserDetailHisList(Map map);
}
