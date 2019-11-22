package com.sitech.family.custservice.compbusi;

import com.sitech.family.dto.ReturnDto;

import java.util.Map;

/**
 * 组合服务:用户资料落地
 *
 * @author shirley
 * @date created in 2019/2/26
 */
public interface IFamilyUserCo {

    ReturnDto create(Map<String, Object> map);

    /**
     * 查询是否竣工
     * @param map
     * @return String
     */
    Map getUserFinishFlag(Map<String, Object> map);

    /**
     * 更新竣工标志
     * @param map
     * @return ReturnDto
     */
    ReturnDto updateFinishState(Map<String, Object> map);
}
