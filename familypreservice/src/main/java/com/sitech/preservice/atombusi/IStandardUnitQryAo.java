package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IStandardUnitQryAo {
    OutDTO<Map> unitQuery(Map<String,Object> inMap);
}
