package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.OpenUserInDto;
import com.sitech.family.compservice.dto.outdto.OpenUserCountNumOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
public interface IOpenUserCountNumCoSvc {
    public OutDTO<OpenUserCountNumOutDto> chkOpenUserCountNum(InDTO<RequestMessage<OpenUserInDto>> requestMessage);
}
