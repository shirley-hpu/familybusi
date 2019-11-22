package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyGoodsInfoQryAo {

    OutDTO<Map> qryFamilyGoodsInfoByPrc(Map<String, Object> inMap);
}
