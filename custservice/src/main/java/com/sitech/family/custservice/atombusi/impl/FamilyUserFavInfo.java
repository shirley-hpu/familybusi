package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserFavInfo;
import com.sitech.family.dao.usergoods.IUserFavInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠订购实例信息
 */
@Component
public class FamilyUserFavInfo implements IFamilyUserFavInfo {

    @Autowired
    private IUserFavInfoDao userFavInfoDao;

    @Override
    public ReturnDto drop(UserFavInfo userFavInfoDto) {
        return userFavInfoDao.drop(userFavInfoDto.getFavinsId());
    }

    @Override
    public ReturnDto create(UserFavInfo userFavInfoDto) {
        return userFavInfoDao.create(userFavInfoDto);
    }

    @Override
    public List<UserFavInfo> query(BigDecimal favinsId) {
        return userFavInfoDao.query(favinsId);
    }

    @Override
    public ReturnDto modify(UserFavInfo userFavInfoDto) {
        return userFavInfoDao.modify(userFavInfoDto);
    }
}
