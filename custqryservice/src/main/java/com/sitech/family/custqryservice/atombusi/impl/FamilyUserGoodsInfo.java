package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
import com.sitech.family.custqryservice.mapper.IUserGroupMapper;
import com.sitech.family.custqryservice.mapper.UserGoodsMapper;
import com.sitech.family.dao.usergoods.IUserGoodsInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 家庭商品订购信息
 * @date 2018/12/17 14:11
 */
@Component
public class FamilyUserGoodsInfo implements IFamilyUserGoodsInfo {

    @Autowired
    private IUserGoodsInfoQryDao iUserGoodsInfoQryDao;


    @Override
    public UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept) {
        return iUserGoodsInfoQryDao.query(goodsinsId, relgoodsinsId, svcinsId, prodprcinsId, loginAccept);
    }

    @Override
    public List<UserGoodsInfo> qryUserGoodsInfoList(Map map) {
        return iUserGoodsInfoQryDao.qryUserGoodsInfoList(map);
    }

    @Override
    public UserGoodsInfo qryFamilyUserBasicInfo(Map map) {
        List<UserGoodsInfo> userGoodsInfos = iUserGoodsInfoQryDao.qryUserGoodsInfoList(map);
        return userGoodsInfos.get(0);
    }

    /**
     * @param map
     * @return list
     */
    @Override
    public List<UserGoodsInfo> qryUserGoodsList(Map map) {
        return iUserGoodsInfoQryDao.qryUserGoodsList(map);
    }
}
