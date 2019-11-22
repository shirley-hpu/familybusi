package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IServiceNo;
import com.sitech.family.custqryservice.dto.mapperdto.ServiceNo;
import com.sitech.family.custqryservice.mapper.IServiceNoMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 用户路由信息
 * @date 2018/12/20 16:52
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ServiceNoImpl implements IServiceNo {

    @Autowired
    private IServiceNoMapper mapper;

    /**
     * 查询用户路由信息
     *
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    @Override
    public ServiceNo query(Long idNo, String serviceNo, String serviceType) {
        ServiceNo serviceNo1 = new ServiceNo();

        try {
            serviceNo1 = mapper.query(idNo,serviceNo,serviceType);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户路由信息失败"+e.getMessage());
        }

        return serviceNo1;
    }

}
