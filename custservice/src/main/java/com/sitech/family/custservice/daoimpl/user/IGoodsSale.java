package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.*;
import com.sitech.family.dto.ReturnDto;

/**
 * 商品销售记录信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IGoodsSale {

    /**
     * 创建商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    ReturnDto create(GoodsSale goodsSale);

    /**
     * 删除商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    ReturnDto drop(GoodsSale goodsSale);

    /**
     * 更新商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    ReturnDto modify(GoodsSale goodsSale);

    /**
     * 查询商品销售记录
     *
     * @param loginAccept
     * @return GoodsSale
     */
    GoodsSale query(Long loginAccept);

}
