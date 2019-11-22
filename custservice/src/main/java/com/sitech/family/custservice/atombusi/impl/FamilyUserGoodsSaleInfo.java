package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGoodsSaleInfo;
import com.sitech.family.dao.usergoods.IUserGoodsSaleInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭商品销售轨迹信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserGoodsSaleInfo implements IFamilyUserGoodsSaleInfo {

    /**
     * 商品销售记录信息
     */
    @Autowired
    private IUserGoodsSaleInfoDao userGoodsSaleInfoDao;

    @Override
    public ReturnDto create(UserGoodsSaleInfo userGoodsSaleInfoDto) {
        return userGoodsSaleInfoDao.create(userGoodsSaleInfoDto);
    }

    @Override
    public ReturnDto modify(UserGoodsSaleInfo userGoodsSaleInfoDto) {
        return userGoodsSaleInfoDao.modify(userGoodsSaleInfoDto);
    }

    @Override
    public ReturnDto drop(UserGoodsSaleInfo userGoodsSaleInfoDto) {
        return userGoodsSaleInfoDao.drop(userGoodsSaleInfoDto);
    }

    @Override
    public UserGoodsSaleInfo query(Long loginAccept, String resourceNo, Long sellSerialNo, Date opTime) {
        return userGoodsSaleInfoDao.query(loginAccept, resourceNo, sellSerialNo, opTime);
    }

    @Override
    public List<UserGoodsSaleInfo> qryUserGoodsSaleInfoList(Map map) {
        return userGoodsSaleInfoDao.qryUserGoodsSaleInfoList(map);
    }
}
