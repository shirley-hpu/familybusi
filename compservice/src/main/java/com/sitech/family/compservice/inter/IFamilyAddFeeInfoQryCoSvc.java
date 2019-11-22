package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyAddFeeInfo;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IFamilyAddFeeInfoQryCoSvc {

    /**
     * 附加资费全量信息
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyAddFeeInfo(InDTO<RequestMessage<FamilyAddFeeInfo>> inDTO);
}
