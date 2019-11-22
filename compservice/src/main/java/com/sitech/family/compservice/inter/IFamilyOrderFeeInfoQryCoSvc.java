package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyOrderFeeInfo;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IFamilyOrderFeeInfoQryCoSvc {

    /**
     * 附加资费已订购信息
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyOrderFeeInfo(InDTO<RequestMessage<FamilyOrderFeeInfo>> inDTO);
}
