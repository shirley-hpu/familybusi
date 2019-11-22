package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyServiceNoInfo;
import com.sitech.family.dao.user.IServiceNoInfoQryDao;
import com.sitech.family.dto.user.UserServiceNoInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:29
 */
@Component
public class FamilyServiceNoInfo implements IFamilyServiceNoInfo {

    @Autowired
    private IServiceNoInfoQryDao iServiceNoInfoQryDao;

    @Override
    public UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType) {
        return iServiceNoInfoQryDao.query(serviceNo, idNo, serviceType);
    }

    @Override
    public List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map) {
        return iServiceNoInfoQryDao.qryUserServiceNoInfoList(map);
    }
}
