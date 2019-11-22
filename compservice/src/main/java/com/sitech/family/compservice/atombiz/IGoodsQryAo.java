package com.sitech.family.compservice.atombiz;

import java.util.Map;

/**
 * @Description 产商品查询公共接口
 * @Author shirley
 * @Date 2018/9/13 10:18
 * @Version 1.0
 **/
public interface IGoodsQryAo {

    /**
     * 原子服务产商品公共查询方法
     * @param map
     * @return map
     */
    Map query(Map<String, Object> map);

}

