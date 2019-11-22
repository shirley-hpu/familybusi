package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.dto.ReturnDto;

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
     * 创建商品定价属性实例信息
     * @param userGoodsAttr
     * @return ReturnDto
     */
    ReturnDto create(UserGoodsAttr userGoodsAttr) ;

    /**
     * 更新商品定价属性实例信息
     * @param userGoodsAttr
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsAttr userGoodsAttr);

    /**
     * 删除商品定价属性实例信息
     * @param userGoodsAttr
     * @return ReturnDto
     */
    ReturnDto drop(UserGoodsAttr userGoodsAttr);

    /**
     * 查询商品定价属性实例信息
     * @param goodsinsId,attrId,attrNo,effDate
     * @return List<UserGoodsAttr>
     */
    UserGoodsAttr query(BigDecimal goodsinsId, String attrId, String attrNo, Date effDate);

    /**
     * 查询商品定价属性实例信息
     * @param map
     * @return List<UserGoodsAttr>
     */
    List<UserGoodsAttr> qryUserGoodsAttrList(Map map);

    /**
     * 查询历史商品定价属性实例信息
     * @param map
     * @return List<UserGoodsAttr>
     */
    List<UserGoodsAttr> qryUserGoodsAttrHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userGoodsAttr
     * @return
     */
    ReturnDto updateFinishState(UserGoodsAttr userGoodsAttr);
}
