package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
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
     * @param goodsinsId
     * @return
     */
    UserGoods query(BigDecimal goodsinsId);

    UserGoods qryFamilyUserBasicInfo(@Param("param") Map map);

    /**
     * 查询用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    List<UserGoods> qryUserGoodsList(@Param("params") Map map);
}
