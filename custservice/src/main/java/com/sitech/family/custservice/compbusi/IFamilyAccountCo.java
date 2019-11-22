package com.sitech.family.custservice.compbusi;

import com.sitech.family.dto.ReturnDto;

import java.util.Map;

/**
 * @author wusm
 * @description 家庭账户组合实体
 * @date 2019/3/26 10:45
 */
public interface IFamilyAccountCo {

    /**
     * 家庭账户组合实体新增
     *
     * @param map
     * @return ReturnDto
     */
    ReturnDto create(Map<String, Object> map);

    /**
     * 更新竣工标志
     *
     * @param map
     * @return ReturnDto
     */
    ReturnDto updateFinishState(Map<String, Object> map);

    /**
     * 家庭账户组合实体删除
     *
     * @param map
     * @return ReturnDto
     */
    ReturnDto drop(Map<String, Object> map);
}
