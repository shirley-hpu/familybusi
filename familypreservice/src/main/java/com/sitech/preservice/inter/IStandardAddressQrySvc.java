package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.dto.indto.StandardRoomInDto;
import com.sitech.preservice.dto.indto.StandardZoneInDto;

import java.util.Map;

public interface IStandardAddressQrySvc {

    OutDTO<Map> addrQuery(InDTO<RequestMessage<Map>> inDTO);

    OutDTO<Map> zoneQuery(InDTO<RequestMessage<StandardZoneInDto>> inDTO);

    OutDTO<Map> unitQuery(InDTO<RequestMessage<Map>> inDTO);

    OutDTO<Map> roomQuery(InDTO<RequestMessage<StandardRoomInDto>> inDTO);

}
