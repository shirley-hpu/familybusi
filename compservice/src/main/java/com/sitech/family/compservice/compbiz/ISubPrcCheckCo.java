package com.sitech.family.compservice.compbiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  主资费校验
 * @date 2019/3/13 9:43
 */
public interface ISubPrcCheckCo {

    OutDTO<SubPrcCheckOutDto> subPrcCheckCo(SubPrcCheckInDto subPrcCheckInDto, OprInfo oprInfo);

}
