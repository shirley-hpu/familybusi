package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.dto.ReturnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    void drop(BigDecimal limitinsId);

    /**
     * @param userGoodsLmt
     * @return
     */
    void create(UserGoodsLmt userGoodsLmt);

    /**
     * @param userGoodsLmt
     * @return
     */
    void insert(UserGoodsLmt userGoodsLmt);

    /**
     * @param limitinsId
     * @return
     */
    UserGoodsLmt query(BigDecimal limitinsId);

    /**
     * @param userGoodsLmt
     * @return
     */
    void modify(UserGoodsLmt userGoodsLmt);

    /**
     * 查询用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    List<UserGoodsLmt> qryUserGoodsLmtList(@Param("params") Map map);

    /**
     * 查询历史用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    List<UserGoodsLmt> qryUserGoodsLmtHisList(@Param("inparams") Map map);
}
