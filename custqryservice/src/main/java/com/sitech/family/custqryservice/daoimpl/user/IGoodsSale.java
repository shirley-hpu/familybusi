package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.GoodsSale;

/**
 * 商品销售记录信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IGoodsSale {

    /**
     * 查询商品销售记录
     *
     * @param loginAccept
     * @return GoodsSale
     */
    GoodsSale query(Long loginAccept);

}
