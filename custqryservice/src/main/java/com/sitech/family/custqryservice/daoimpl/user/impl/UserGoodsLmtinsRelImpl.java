package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsLmtinsRel;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmtins;
import com.sitech.family.custqryservice.mapper.UserGoodsLmtinsMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 商品订购实例与受限实例关系 实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
public class UserGoodsLmtinsRelImpl implements IUserGoodsLmtinsRel {

    @Autowired
    private UserGoodsLmtinsMapper userGoodsLmtinsMapper;

    /**
     * 查询帐务付费明细信息
     *
     * @param limitinsId
     * @param goodsinsId
     * @return UserGoodsLmtins
     */
    @Override
    public UserGoodsLmtins query(BigDecimal limitinsId, BigDecimal goodsinsId) {
        UserGoodsLmtins userGoodsLmtins = new UserGoodsLmtins();

        try {
            userGoodsLmtins = userGoodsLmtinsMapper.query(limitinsId, goodsinsId);
        } catch (Exception e) {
            throw new BusiException("查询商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }

        return userGoodsLmtins;
    }
}
