package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsLmt;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.custqryservice.mapper.UserGoodsLmtMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
public class UserGoodsLmtImpl implements IUserGoodsLmt {

    @Autowired
    private UserGoodsLmtMapper userGoodsLmtMapper;

    /**
     * 查询用户商品受限信息
     *
     * @param limitinsId
     * @return UserGoodsLmt
     */
    @Override
    public UserGoodsLmt query(BigDecimal limitinsId) {
        UserGoodsLmt userGoodsLmt = new UserGoodsLmt();

        try {
            userGoodsLmt = userGoodsLmtMapper.query(limitinsId);
        } catch (Exception e) {
            throw new BusiException("查询用户商品受限信息失败:" + e.getMessage());
        }

        return userGoodsLmt;
    }


}
