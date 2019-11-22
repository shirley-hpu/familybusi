package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyUserPreGoodsQryAo {
    OutDTO<Map> qryFamilyUserPreGoods(Map<String, Object> inMap);
}
