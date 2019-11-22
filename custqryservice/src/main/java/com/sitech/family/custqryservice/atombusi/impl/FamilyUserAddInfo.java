package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserAddInfo;
import com.sitech.family.dao.user.IUserAddInfoQryDao;
import com.sitech.family.dto.user.UserAddInfo;
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
 * @date 2018/12/14 17:59
 */
@Component
public class FamilyUserAddInfo implements IFamilyUserAddInfo {

    @Autowired
    private IUserAddInfoQryDao iUserAddInfoQryDao;

    @Override
    public UserAddInfo query(Long idNo, String fieldCode) {
        return iUserAddInfoQryDao.query(idNo, fieldCode);
    }

    @Override
    public List<UserAddInfo> qryUserAddInfoList(Map map) {
        return iUserAddInfoQryDao.qryUserAddInfoList(map);
    }
}
