package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.ServiceNo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户路由信息
 * @date 2018/12/20 16:54
 */

@Repository
public interface IServiceNoMapper {

    /**
     * 新增用户路由信息
     * @param serviceNo
     * @return null
     */
    void create(ServiceNo serviceNo) ;

    /**
     * 新增历史表用户路由信息
     * @param serviceNo
     * @return null
     */
    void insert(ServiceNo serviceNo);

    /**
     * 更新用户路由信息
     * @param serviceNo
     * @return null
     */
    void modify(ServiceNo serviceNo);

    /**
     * 删除用户路由信息
     * @param serviceNo
     * @return null
     */
    void drop(ServiceNo serviceNo);

    /**
     * 查询用户路由信息
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    ServiceNo query(@Param("idNo") Long idNo,@Param("serviceNo")  String serviceNo,@Param("serviceType")  String serviceType);

    /**
     * 查询历史表用户路由信息
     * @param map
     * @return List<ServiceNo>
     */
    List<ServiceNo> qryServiceNoList(@Param("params") Map map);

    /**
     * 查询历史表用户路由信息
     * @param map
     * @return List<ServiceNo>
     */
    List<ServiceNo> qryServiceNoHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param serviceNo
     * @return
     */
    void updateFinishState(ServiceNo serviceNo);
}
