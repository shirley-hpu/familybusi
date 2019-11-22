package com.sitech.family.compservice.atombiz;

import java.util.Map;

public interface IFamilyOrderFeeInfoQryAo {

    /**
     * 附加资费已订购信息
     * @param map
     * @return outDTO
     */
    Map qryFamilyOrderFeeInfo(Map<String,Object> map);
}
