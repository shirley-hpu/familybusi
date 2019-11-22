package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 商品订购实例与受限实例关系
 */
@Repository
public interface UserGoodsLmtinsMapper {

    /**
     * @param limitinsId
     * @param goodsinsId
     * @return
     */
    void drop(@Param("limitinsId") BigDecimal limitinsId,@Param("goodsinsId") BigDecimal goodsinsId);

    /**
     * @param userGoodsLmtins
     * @return
     */
    void create(UserGoodsLmtins userGoodsLmtins);

    /**
     * @param userGoodsLmtins
     * @return
     */
    void insert(UserGoodsLmtins userGoodsLmtins);

    /**
     * @param limitinsId
     * @param goodsinsId
     * @return
     */
    UserGoodsLmtins query(@Param("limitinsId") BigDecimal limitinsId,@Param("goodsinsId") BigDecimal goodsinsId);

    /**
     * @param userGoodsLmtins
     * @return
     */
    void modify(UserGoodsLmtins userGoodsLmtins);

    /**
     * 查询帐务付费明细信息
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    List<UserGoodsLmtins> qryContractRltList(@Param("params") Map map);

    /**
     * 查询帐务付费明细历史信息
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    List<UserGoodsLmtins> qryContractRltHisList(@Param("inparams") Map map);
}