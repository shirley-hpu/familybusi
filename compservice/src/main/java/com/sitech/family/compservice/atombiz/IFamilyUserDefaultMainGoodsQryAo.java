package com.sitech.family.compservice.atombiz;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/23 13:41
 */
public interface IFamilyUserDefaultMainGoodsQryAo {
    /**
     * 查询默认主商品
     * @param param
     * @return
     */
    public Map query(Map<String,Object> param);
}
