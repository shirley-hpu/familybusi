package com.sitech.family.compservice.compbiz;

import java.util.Map;

/**
 * 组合服务查询
 * @author wusm
 * @date 2018/9/27 17:59
 */
public interface IFamilyGoodsQryCo {

    /**
     * 组合服务公共查询方法
     * @param map
     * @return map
     */
    Map query(Map<String,Object> map);

}
