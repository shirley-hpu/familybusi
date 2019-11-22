package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyOpenCfmInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * Created by xuwei on 2019/3/20.
 */
public interface IFamilyOpenCfmCoSvc {
    public OutDTO<Object> cfmFamilyOpen(InDTO<RequestMessage<FamilyOpenCfmInDto>> RequestMessage);
}
