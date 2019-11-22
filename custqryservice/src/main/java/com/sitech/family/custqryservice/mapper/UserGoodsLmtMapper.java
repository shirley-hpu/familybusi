package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmt;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/19
 */
@Repository
public interface UserGoodsLmtMapper {

    /**
     * @param limitinsId
     * @return
     */
    UserGoodsLmt query(BigDecimal limitinsId);

}
