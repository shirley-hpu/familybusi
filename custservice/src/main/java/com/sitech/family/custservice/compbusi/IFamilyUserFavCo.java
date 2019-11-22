package com.sitech.family.custservice.compbusi;

import com.sitech.family.dto.ReturnDto;

import java.util.Map;

/**
 * 记录用户优惠订购实例及优惠参数实例
 */
public interface IFamilyUserFavCo {


    ReturnDto create(Map<String, Object> map);
}
