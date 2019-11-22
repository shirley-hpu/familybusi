package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyOrderFeeQryAoSvc {

    /**
     * 根据手机号码查询已订购附加资费信息
     *
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyOrderFee(InDTO<RequestMessage<Map>> inDTO);
}
