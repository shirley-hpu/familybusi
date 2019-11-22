package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户信息
 * @date 2018/12/19 17:48
 */
@Repository
public interface IUserMapper {

    /**
     * 新增用户信息
     * @param user
     * @return null
     */
    void create(User user) ;

    /**
     * 新增历史表用户信息
     * @param user
     * @return null
     */
    void insert(User user);

    /**
     * 更新用户信息
     * @param user
     * @return null
     */
    void modify(User user);

    /**
     * 删除用户信息
     * @param idNo
     * @return null
     */
    void drop(Long idNo);

    /**
     * 查询用户信息
     * @param idNo
     * @return User
     */
    User query(Long idNo);

    /**
     * 查询用户信息
     * @param map
     * @return List<User>
     */
    List<User> qryUserList(@Param("params") Map map);

    /**
     * 查询历史用户信息
     * @param map
     * @return List<User>
     */
    List<User> qryUserHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param user
     * @return
     */
    void updateFinishState(User user);
}
