package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.ServiceNo;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户路由信息
 * @date 2018/12/20 16:44
 */
public interface IServiceNo {

    /**
     * 创建用户路由信息
     * @param serviceNo
     * @return ReturnDto
     */
    ReturnDto create(ServiceNo serviceNo) ;

    /**
     * 更新用户路由信息
     * @param serviceNo
     * @return ReturnDto
     */
    ReturnDto modify(ServiceNo serviceNo);

    /**
     * 删除用户路由信息
     * @param serviceNo
     * @return ReturnDto
     */
    ReturnDto drop(ServiceNo serviceNo);

    /**
     * 查询用户路由信息
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    ServiceNo query(Long idNo, String serviceNo, String serviceType);

    /**
     * 查询用户路由信息
     * @param map
     * @return ServiceNo
     */
    List<ServiceNo> qryServiceNoList(Map map);

    /**
     * 查询用户路由历史信息
     * @param map
     * @return List<ServiceNo>
     */
    List<ServiceNo> qryServiceNoHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param serviceNo
     * @return
     */
    ReturnDto updateFinishState(ServiceNo serviceNo);
}
