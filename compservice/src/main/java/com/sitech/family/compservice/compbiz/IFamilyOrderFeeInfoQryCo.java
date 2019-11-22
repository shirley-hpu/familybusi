package com.sitech.family.compservice.compbiz;

import java.util.Map;

public interface IFamilyOrderFeeInfoQryCo {

    /**
     * 附加资费已订购信息
     * @param map
     * @return outDTO
     */
    Map qryFamilyOrderFeeInfo(Map<String,Object> map);
}
