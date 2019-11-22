package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsRel;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description 用户商品实例关系
 * @date 2018/12/28 09:54
 */
public interface IUserGoodsRel {

    /**
     * 查询用户商品实例关系
     *
     * @param goodsinsId,relgoodsinsId,loginAccept
     * @return UserGoodsRel
     */
    UserGoodsRel query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, Long loginAccept);

}
