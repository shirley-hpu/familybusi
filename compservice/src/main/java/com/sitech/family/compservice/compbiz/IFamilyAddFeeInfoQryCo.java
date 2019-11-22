package com.sitech.family.compservice.compbiz;

import java.util.Map;

public interface IFamilyAddFeeInfoQryCo {

    /**
     * 附加资费全量信息
     * @param map
     * @return outDTO
     */
    Map qryFamilyAddFeeInfo(Map<String,Object> map);
}
