package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoods;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
import com.sitech.family.custqryservice.mapper.UserGoodsMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 用户商品订购实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
public class UserGoodsImpl implements IUserGoods {

    @Autowired
    private UserGoodsMapper userGoodsMapper;

    /**
     * 查询用户商品订购实例信息
     *
     * @param goodsinsId
     * @return ReturnDto
     */
    @Override
    public UserGoods query(BigDecimal goodsinsId) {
        UserGoods userGoods = new UserGoods();

        try {
            userGoods = userGoodsMapper.query(goodsinsId);
        } catch (Exception e) {
            throw new BusiException("查询用户商品订购实例信息失败:" + e.getMessage());
        }

        return userGoods;
    }

    @Override
    public UserGoods qryFamilyUserBasicInfo(Map map) {
        try {
            UserGoods userGoods = userGoodsMapper.qryFamilyUserBasicInfo(map);
            return userGoods;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }

    /**
     * 通过map传值查询用户商品订购实例信息
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserGoods> qryUserGoodsList(Map map) {

        try {
            List<UserGoods> list = userGoodsMapper.qryUserGoodsList(map);
            return list;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }


    }
}
