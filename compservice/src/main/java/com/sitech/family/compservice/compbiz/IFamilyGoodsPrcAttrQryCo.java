package com.sitech.family.compservice.compbiz;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @author wusm
 * @description 商品定价属性查询
 * @date 2018/9/29 09:00
 */
public interface IFamilyGoodsPrcAttrQryCo {

    /**
     * 商品定价属性查询
     * @param map
     * @return outDTO
     */
    OutDTO query(Map<String,Object> map);
}
