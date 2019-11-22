package com.sitech.family.compservice.atombiz;

import java.util.Map;

public interface IFamilyAddFeeInfoQryAo {

    /**
     * 附加资费全量信息
     * @param map
     * @return outDTO
     */
    Map qryFamilyAddFeeInfo(Map<String,Object> map);
}
