package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IGoodsSale;
import com.sitech.family.custqryservice.dto.mapperdto.GoodsSale;
import com.sitech.family.custqryservice.mapper.GoodsSaleMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品销售记录信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class GoodsSaleImpl implements IGoodsSale {

    @Autowired
    private GoodsSaleMapper goodsSaleMapper;

    /**
     * 查询商品销售记录
     *
     * @param loginAccept
     * @return GoodsSale
     */
    @Override
    public GoodsSale query(Long loginAccept) {
        GoodsSale goodsSale = new GoodsSale();

        try {
            goodsSale = goodsSaleMapper.query(loginAccept);
        } catch (Exception e) {
            throw new BusiException("查询商品销售记录失败:" + e.getMessage());
        }

        return goodsSale;
    }
}
