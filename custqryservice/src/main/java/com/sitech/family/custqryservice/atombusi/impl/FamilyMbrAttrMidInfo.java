package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyMbrAttrMidInfo;
import com.sitech.family.dao.usergroup.IUserMbrAttrMidInfoQryDao;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @date 2019/4/17 21:49
 */
@Component
public class FamilyMbrAttrMidInfo implements IFamilyMbrAttrMidInfo {

    private final IUserMbrAttrMidInfoQryDao iUserMbrAttrMidInfoDao;

    @Autowired
    public FamilyMbrAttrMidInfo(IUserMbrAttrMidInfoQryDao iUserMbrAttrMidInfoDao) {
        this.iUserMbrAttrMidInfoDao = iUserMbrAttrMidInfoDao;
    }


    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map) {
        return iUserMbrAttrMidInfoDao.qryUserMbrAttrMidInfoList(map);
    }
}
