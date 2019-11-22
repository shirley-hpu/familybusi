package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.ServiceNo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wusm
 * @description 用户路由信息
 * @date 2018/12/20 16:54
 */

@Repository
public interface IServiceNoMapper {

    /**
     * 查询用户路由信息
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    ServiceNo query(@Param("idNo") Long idNo,@Param("serviceNo")  String serviceNo,@Param("serviceType")  String serviceType);

}
