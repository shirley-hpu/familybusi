package com.sitech.family.familyservice.compbusi;

import com.sitech.family.dto.ReturnDto;

import java.util.Map;

/**
 * @author wusm
 * @description 在途订购实例
 * @date 2019/4/17 15:08
 */
public interface IFamilyMbrPrcMidCo {

    /**
     *  在途订购实例组合实体新增
     * @param map
     * @return ReturnDto
     */
    ReturnDto create(Map<String, Object> map);
}
