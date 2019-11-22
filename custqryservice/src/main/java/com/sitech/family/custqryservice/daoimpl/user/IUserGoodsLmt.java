package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmt;

import java.math.BigDecimal;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/19
 */
public interface IUserGoodsLmt {


    /**
     * 查询用户商品受限信息
     *
     * @param limitinsId
     * @return UserGoodsLmt
     */
    UserGoodsLmt query(BigDecimal limitinsId);
}
