package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭商品订购信息
 * @date 2018/12/17 14:07
 */
public interface IFamilyUserGoodsInfo {

    /**
     * 查询家庭商品订购信息
     *
     * @return userGoodsInfo
     */
    UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept);

    /**
     * @param map
     * @return
     */
    List<UserGoodsInfo> qryUserGoodsInfoList(Map map);

    UserGoodsInfo qryFamilyUserBasicInfo(Map map);

    /**
     * @param map
     * @return list
     */
    List<UserGoodsInfo> qryUserGoodsList(Map map);
}
