package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyUserBasicInfoAoSvc {

    OutDTO<Object> qryFamilyUserBasicInfo(InDTO<RequestMessage<Map>> inDTO);

}
