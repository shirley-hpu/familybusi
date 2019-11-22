package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IStandardCoverQryAo {

    OutDTO<Map> coverQuery(Map<String,Object> inMap);
}
