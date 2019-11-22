package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmtins;

import java.math.BigDecimal;

/**
 * 商品订购实例与受限实例关系
 *
 * @author shirley
 * @date created in 2018/12/10
 */
public interface IUserGoodsLmtinsRel {

    /**
     * 查询商品订购实例与受限实例关系
     *
     * @param limitinsId,goodsinsId
     * @return UserGoodsLmtins
     */
    UserGoodsLmtins query(BigDecimal limitinsId, BigDecimal goodsinsId);

}
