package com.sitech.family.custqryservice.compbusi;

import java.util.List;
import java.util.Map;

public interface IFamilyOrderAddGoodsCo {

    /**
     * 家庭已订购附加商品信息查询
     * @param map
     * @return list
     */
    public Map qryFamilyOrderAdditionGoods(Map<String, String> map);
}
