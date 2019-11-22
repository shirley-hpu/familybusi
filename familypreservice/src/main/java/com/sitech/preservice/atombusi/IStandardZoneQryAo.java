package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IStandardZoneQryAo {

    OutDTO<Map> zoneQuery(Map<String,Object> inMap);
}
