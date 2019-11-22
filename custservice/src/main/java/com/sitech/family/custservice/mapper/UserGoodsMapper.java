package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import com.sitech.family.dto.ReturnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 用户商品订购实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserGoodsMapper {

    /**
     * @param limitinsId
     * @return
     */
    void drop(BigDecimal limitinsId);

    /**
     * @param userGoods
     * @return
     */
    void create(UserGoods userGoods);

    /**
     * @param userGoods
     * @return
     */
    void insert(UserGoods userGoods);

    /**
     * @param goodsinsId
     * @return
     */
    UserGoods query(BigDecimal goodsinsId);

    /**
     * @param userGoods
     * @return
     */
    void modify(UserGoods userGoods);

    /**
     * 查询用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    List<UserGoods> qryUserGoodsList(@Param("params") Map map);

    /**
     * 查询历史用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    List<UserGoods> qryUserGoodsHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userGoods
     * @return
     */
    void updateFinishState(UserGoods userGoods);
}
