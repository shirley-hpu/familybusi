package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsRel;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户商品实例关系
 * @date 2018/12/28 09:54
 */
public interface IUserGoodsRel {

    /**
     * 创建用户商品实例关系
     * @param userGoodsRel
     * @return ReturnDto
     */
    ReturnDto create(UserGoodsRel userGoodsRel) ;

    /**
     * 更新用户商品实例关系
     * @param userGoodsRel
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsRel userGoodsRel);

    /**
     * 删除用户商品实例关系
     * @param userGoodsRel
     * @return ReturnDto
     */
    ReturnDto drop(UserGoodsRel userGoodsRel);

    /**
     * 查询用户商品实例关系
     *
     * @param goodsinsId,relgoodsinsId,loginAccept
     * @return UserGoodsRel
     */
    UserGoodsRel query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, Long loginAccept);

    /**
     * 查询用户商品实例关系
     * @param map
     * @return List<UserGoodsRel>
     */
    List<UserGoodsRel> qryUserGoodsRelList(Map map);

    /**
     * 查询用户商品实例历史关系
     * @param map
     * @return List<UserGoodsRel>
     */
    List<UserGoodsRel> qryUserGoodsRelHisList(Map map);
}
