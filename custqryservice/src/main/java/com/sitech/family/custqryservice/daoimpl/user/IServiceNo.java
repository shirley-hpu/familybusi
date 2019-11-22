package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.ServiceNo;

/**
 * @author wusm
 * @description 用户路由信息
 * @date 2018/12/20 16:44
 */
public interface IServiceNo {

    /**
     * 查询用户路由信息
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    ServiceNo query(Long idNo, String serviceNo, String serviceType);

}
