package com.sitech.family.compservice.compbiz;

import java.util.Map;

/**
 * @author wusm
 * @description 关系校验组合服务
 * @date 2018/9/27 17:05
 */
public interface IFamilyGoodsChkCo {

    /**
     * 组合服务关系校验
     *
     * @param map
     * @return outDTO
     */
    Map check(Map<String,Object> map);
}
