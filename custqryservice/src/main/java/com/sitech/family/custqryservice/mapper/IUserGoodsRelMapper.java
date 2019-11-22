package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description
 * @date 2018/12/28 10:25
 */
@Repository
public interface IUserGoodsRelMapper {

    /**
     * 查询用户商品实例关系
     * @param goodsinsId,relgoodsinsId,loginAccept
     * @return UserGoodsRel
     */
    UserGoodsRel query(@Param("goodsinsId") BigDecimal goodsinsId,@Param("relgoodsinsId") BigDecimal relgoodsinsId,@Param("loginAccept") Long loginAccept);

}
