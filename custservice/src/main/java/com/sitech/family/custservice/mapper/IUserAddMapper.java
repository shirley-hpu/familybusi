package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserAdd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 扩展属性信息
 * @date 2018/12/20 11:14
 */
@Repository
public interface IUserAddMapper {

    /**
     * 新增扩展属性信息
     * @param userAdd
     * @return null
     */
    void create(UserAdd userAdd) ;

    /**
     * 新增历史表扩展属性信息
     * @param userAdd
     * @return null
     */
    void insert(UserAdd userAdd);

    /**
     * 更新扩展属性信息
     * @param userAdd
     * @return null
     */
    void modify(UserAdd userAdd);

    /**
     * 删除扩展属性信息
     * @param idNo
     * @return null
     */
    void drop(@Param("idNo") Long idNo, @Param("fieldCode")String fieldCode);

    /**
     * 查询扩展属性信息
     * @param idNo
     * @return UserAdd
     */
    UserAdd query(@Param("idNo") Long idNo, @Param("fieldCode")String fieldCode);

    /**
     * 查询历史表扩展属性信息
     * @param map
     * @return List<UserAdd>
     */
    List<UserAdd> qryUserAddList(@Param("params") Map map);

    /**
     * 查询历史表扩展属性信息
     * @param map
     * @return List<UserAdd>
     */
    List<UserAdd> qryUserAddHisList(@Param("inparams") Map map);
}
