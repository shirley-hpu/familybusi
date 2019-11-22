package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyMemPrcChg;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IFamilyMbrPrcChgCoSvc {

    /**
     * 成员资费变更
     * @param inDTO
     * @return
     */
    public OutDTO updateMemberPrc(InDTO<RequestMessage<FamilyMemPrcChg>> inDTO);
}
