package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;

import java.util.Map;

public interface IStandardRegionQrySvc {

    public OutDTO queryStandardRegion(InDTO<RequestMessage<Map>> inDTO);

}
