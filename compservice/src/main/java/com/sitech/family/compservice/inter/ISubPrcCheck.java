package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  主资费校验服务
 * @date 2019/3/13 9:37
 */
public interface ISubPrcCheck {
    public OutDTO<SubPrcCheckOutDto> subPrcCheck(InDTO<RequestMessage<SubPrcCheckInDto>> requestMessage);
}
