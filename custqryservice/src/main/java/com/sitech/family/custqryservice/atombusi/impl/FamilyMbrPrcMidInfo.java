package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyMbrPrcMidInfo;
import com.sitech.family.dao.usergroup.IUserMbrPrcMidInfoQryDao;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @date 2019/4/17 21:49
 */
@Component
public class FamilyMbrPrcMidInfo implements IFamilyMbrPrcMidInfo {

    private final IUserMbrPrcMidInfoQryDao iUserMbrPrcMidInfoDao;

    @Autowired
    public FamilyMbrPrcMidInfo(IUserMbrPrcMidInfoQryDao iUserMbrPrcMidInfoDao) {
        this.iUserMbrPrcMidInfoDao = iUserMbrPrcMidInfoDao;
    }


    /**
     * 查询成员订购实例
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map) {
        return iUserMbrPrcMidInfoDao.qryUserMbrPrcMidInfoList(map);
    }
}
