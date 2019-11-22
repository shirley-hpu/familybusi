package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 商品定价属性实例
 * @date 2018/12/10 10:08
 */
public interface IUserGoodsAttr {

    /**
     * 查询商品定价属性实例信息
     * @param goodsinsId,attrId,attrNo,effDate
     * @return UserGoodsAttr
     */
    UserGoodsAttr query(BigDecimal goodsinsId, String attrId, String attrNo, Date effDate);

    List<UserGoodsAttr> qryUserGoodsAttrList(Map map);
}
