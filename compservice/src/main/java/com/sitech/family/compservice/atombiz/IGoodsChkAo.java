package com.sitech.family.compservice.atombiz;

import java.util.Map;

/**
 * @author wusm
 * @description 原子服务查询校验等公共接口
 * @date 2019/4/2 17:43
 */
public interface IGoodsChkAo {

    /**
     * 产商品接口校验服务公共方法
     * @param map
     * @return map
     */
    Map check(Map<String, Object> map);
}
