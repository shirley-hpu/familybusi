package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 用户商品订购实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
public interface IUserGoods {

    /**
     * 查询用户商品订购实例信息
     *
     * @param goodsinsId
     * @return UserGoods
     */
    UserGoods query(BigDecimal goodsinsId);

    UserGoods qryFamilyUserBasicInfo(Map map);

    /**
     * 通过map传值查询用户商品订购实例信息
     * @param map
     * @return list
     */
    List<UserGoods> qryUserGoodsList(Map map);
}
