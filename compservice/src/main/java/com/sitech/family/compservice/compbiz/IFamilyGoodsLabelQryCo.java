package com.sitech.family.compservice.compbiz;

import java.util.Map;

/**
 * @author wusm
 * @description 商品标签查询
 * @date 2019/4/2 17:39
 */
public interface IFamilyGoodsLabelQryCo {

    /**
     * 商品标签查询
     * @param map
     * @return outDTO
     */
    Map query(Map<String,Object> map);
}
