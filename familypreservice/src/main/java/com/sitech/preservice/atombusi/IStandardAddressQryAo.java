package com.sitech.preservice.atombusi;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IStandardAddressQryAo {

    OutDTO<Map> addrQuery(Map<String,Object> inMap);

}
