package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import com.sitech.family.dto.ReturnDto;

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
     * 创建用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    ReturnDto create(UserGoods userGoods);

    /**
     * 删除用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    ReturnDto drop(UserGoods userGoods);

    /**
     * 更新用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    ReturnDto modify(UserGoods userGoods);

    /**
     * 查询用户商品订购实例信息
     *
     * @param goodsinsId
     * @return ReturnDto
     */
    UserGoods query(BigDecimal goodsinsId);

    /**
     * 查询用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    List<UserGoods> qryUserGoodsList(Map map);

    /**
     * 查询历史用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    List<UserGoods> qryUserGoodsHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userGoods
     * @return
     */
    ReturnDto updateFinishState(UserGoods userGoods);
}
