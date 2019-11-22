package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 商品定价属性实例
 * @date 2018/12/6 17:19
 */
@Repository
public interface IUserGoodsAttrMapper {

    UserGoodsAttr query(@Param("goodsinsId") BigDecimal goodsinsId,@Param("attrId") String attrId,@Param("attrNo") String attrNo,@Param("effDate") Date effDate);

    List<UserGoodsAttr> qryUserGoodsAttrList(@Param("params") Map map);
}
