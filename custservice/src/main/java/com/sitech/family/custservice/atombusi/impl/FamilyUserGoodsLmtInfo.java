package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGoodsLmtInfo;
import com.sitech.family.dao.usergoods.IUserGoodsLmtInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 逻辑原子实体业务实现层
 * 家庭用户受限信息实体
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Component
public class FamilyUserGoodsLmtInfo implements IFamilyUserGoodsLmtInfo {

    /**
     * 家庭用户受限信息 逻辑模型层接口
     */
    @Autowired
    private IUserGoodsLmtInfoDao userGoodsLmtInfoDao;

    @Override
    public ReturnDto create(UserGoodsLmtInfo  userGoodsLmtInfoDto) {
        return userGoodsLmtInfoDao.create(userGoodsLmtInfoDto);
    }

    @Override
    public ReturnDto modify(UserGoodsLmtInfo  userGoodsLmtInfoDto) {
        return userGoodsLmtInfoDao.modify(userGoodsLmtInfoDto);
    }

    @Override
    public ReturnDto drop(UserGoodsLmtInfo userGoodsLmtInfoDto) {
        return userGoodsLmtInfoDao.drop(userGoodsLmtInfoDto);
    }

    @Override
    public UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId) {
        return userGoodsLmtInfoDao.query(limitinsId,goodsinsId);
    }

    @Override
    public List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map) {
        return userGoodsLmtInfoDao.qryUserGoodsLmtInfoList(map);
    }
}
