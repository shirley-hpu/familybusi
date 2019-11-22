package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:24
 */
public interface IUserGoodsAttrInfoQryDao {

    /**
     * 查询家庭订购属性信息
     *
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
