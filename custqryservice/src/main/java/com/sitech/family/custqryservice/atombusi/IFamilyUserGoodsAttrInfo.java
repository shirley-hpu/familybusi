package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭订购属性信息
 * @date 2018/12/17 14:39
 */
public interface IFamilyUserGoodsAttrInfo {

    /**
     * 查询家庭订购属性信息
     * @return userGoodsAttrInfo
     */
    UserGoodsAttrInfo query(BigDecimal svcinsId, String attrId, String attrNo, Date effDate);

    /**
     *
     * @param map
     * @return
     */
    List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map);
}
