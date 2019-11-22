package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;

import java.util.Map;

public interface IFamilyPreOrderRdComSvc {

    //预受理提交服务
    public OutDTO commit(InDTO<RequestMessage<Map>> inDTO);

    //预受理查询服务
    public OutDTO query(InDTO<RequestMessage<Map>> inDTO);

}
