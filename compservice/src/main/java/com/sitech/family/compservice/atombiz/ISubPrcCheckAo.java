package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  主资费校验
 * @date 2019/3/13 10:10
 */
public interface ISubPrcCheckAo {
    OutDTO<SubPrcCheckOutDto> subPrcCheckAo(SubPrcCheckInDto subPrcCheckInDto, OprInfo oprInfo);
}
