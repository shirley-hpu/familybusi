package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserFavAttrInfo;
import com.sitech.family.dao.usergoods.IUserFavAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavAttrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠参数实例
 */
@Component
public class FamilyUserFavAttrInfo implements IFamilyUserFavAttrInfo {

    @Autowired
    private IUserFavAttrInfoDao userFavAttrInfoDao;

    @Override
    public ReturnDto drop(UserFavAttrInfo userFavAttrInfo) {
        return userFavAttrInfoDao.drop(userFavAttrInfo.getFavinsId(),
                userFavAttrInfo.getAttrId(), userFavAttrInfo.getEffDate());
    }

    @Override
    public ReturnDto create(UserFavAttrInfo userFavAttrInfo) {
        return userFavAttrInfoDao.create(userFavAttrInfo);
    }

    @Override
    public List<UserFavAttrInfo> query(BigDecimal favinsId, String attrId, Date effDate) {
        return userFavAttrInfoDao.query(favinsId, attrId, effDate);
    }

    @Override
    public ReturnDto modify(UserFavAttrInfo userFavAttrInfo) {
        return userFavAttrInfoDao.modify(userFavAttrInfo);
    }
}
