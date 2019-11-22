package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/19
 */
public interface IUserGoodsLmt {

    /**
     * 创建用户商品受限信息
     *
     * @param userGoodsLmt
     * @return
     */
    ReturnDto create(UserGoodsLmt userGoodsLmt);

    /**
     * 删除用户商品受限信息
     *
     * @param userGoodsLmt
     * @return ReturnDto
     */
    ReturnDto drop(UserGoodsLmt userGoodsLmt);

    /**
     * 更新用户商品受限信息
     *
     * @param userGoodsLmt
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsLmt userGoodsLmt);

    /**
     * 查询用户商品受限信息
     *
     * @param limitinsId
     * @return UserGoodsLmt
     */
    UserGoodsLmt query(BigDecimal limitinsId);

    /**
     * 查询用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    List<UserGoodsLmt> qryUserGoodsLmtList(Map map);

    /**
     * 查询历史用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    List<UserGoodsLmt> qryUserGoodsLmtHisList(Map map);
}
