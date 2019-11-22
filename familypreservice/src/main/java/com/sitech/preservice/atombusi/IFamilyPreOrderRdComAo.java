package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyPreOrderRdComAo {

    OutDTO commit(Map<String,Object> inMap);

    OutDTO query(Map<String,Object> inMap);
}
