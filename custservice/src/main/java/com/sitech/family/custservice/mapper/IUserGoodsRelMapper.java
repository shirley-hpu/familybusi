package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/28 10:25
 */
@Repository
public interface IUserGoodsRelMapper {

    /**
     * 创建用户商品实例关系
     * @param userGoodsRel
     * @return null
     */
    void create(UserGoodsRel userGoodsRel) ;

    /**
     * 新增历史表用户商品实例关系
     * @param userGoodsRel
     * @return
     */
    void insert(UserGoodsRel userGoodsRel);

    /**
     * 更新用户商品实例关系
     * @param userGoodsRel
     * @return
     */
    void modify(UserGoodsRel userGoodsRel);

    /**
     * 删除用户商品实例关系
     * @param userGoodsRel
     * @return
     */
    void drop(UserGoodsRel userGoodsRel);

    /**
     * 查询用户商品实例关系
     * @param goodsinsId,relgoodsinsId,loginAccept
     * @return UserGoodsRel
     */
    UserGoodsRel query(@Param("goodsinsId") BigDecimal goodsinsId,@Param("relgoodsinsId") BigDecimal relgoodsinsId,@Param("loginAccept") Long loginAccept);

    /**
     * 查询用户商品实例关系
     * @param map
     * @return List<UserGoodsRel>
     */
    List<UserGoodsRel> qryUserGoodsRelList(@Param("params") Map map);

    /**
     * 查询用户商品实例关系
     * @param map
     * @return List<UserGoodsRel>
     */
    List<UserGoodsRel> qryUserGoodsRelHisList(@Param("inparams") Map map);
}
