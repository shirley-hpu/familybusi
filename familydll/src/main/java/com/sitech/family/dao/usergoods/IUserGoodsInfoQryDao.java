package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.usergoods.UserGoodsInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:26
 */
public interface IUserGoodsInfoQryDao {

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

    /**
     * @param map
     * @return list
     */
    List<UserGoodsInfo> qryUserGoodsList(Map map);

}
