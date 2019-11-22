package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IGoodsSale;
import com.sitech.family.custservice.dto.mapperdto.GoodsSale;
import com.sitech.family.custservice.mapper.GoodsSaleMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品销售记录信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class GoodsSaleImpl implements IGoodsSale {

    @Autowired
    private GoodsSaleMapper goodsSaleMapper;

    /**
     * 创建商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(GoodsSale goodsSale) {
        ReturnDto returnDto = new ReturnDto();

        try {
            goodsSaleMapper.create(goodsSale);
        } catch (Exception e) {
            throw new BusiException("创建商品销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(GoodsSale goodsSale) {
        ReturnDto returnDto = new ReturnDto();

        try {
            goodsSaleMapper.drop(goodsSale.getLoginAccept());
        } catch (Exception e) {
            throw new BusiException("删除商品销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新商品销售记录
     *
     * @param goodsSale
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(GoodsSale goodsSale) {
        ReturnDto returnDto = new ReturnDto();

        try {
            goodsSaleMapper.modify(goodsSale);
        } catch (Exception e) {
            throw new BusiException("更新商品销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

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
