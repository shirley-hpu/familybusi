package com.sitech.family.custqryservice.compbusi;

import com.sitech.family.custqryservice.dto.outdto.MbrPrcMidInfo;
import com.sitech.family.dto.ReturnDto;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @description 成员订购实例中间表
 * @date 2019/4/17 15:08
 */
public interface IFamilyMbrPrcMidCo {

    /**
     * @param map
     * @return ReturnDto
     */
    public List<MbrPrcMidInfo> query(Map<String, Object> map);
}
