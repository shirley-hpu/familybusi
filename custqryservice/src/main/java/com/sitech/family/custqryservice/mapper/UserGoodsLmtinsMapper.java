package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmtins;

import java.math.BigDecimal;

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
    UserGoodsLmtins query(@Param("limitinsId") BigDecimal limitinsId,@Param("goodsinsId") BigDecimal goodsinsId);

}