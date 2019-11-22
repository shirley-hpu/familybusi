package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.ISubPrcCheckAo;
import com.sitech.family.compservice.compbiz.ISubPrcCheckCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author guanqp
 * @Description  主资费服务co层
 * @date 2019/3/13 10:06
 */
@Component
public class SubPrcCheckCoSvc implements ISubPrcCheckCo {

    @Resource(name="SubPrcCheckAoSvc")
    private ISubPrcCheckAo iSubPrcCheckAo;

    @Override
    public OutDTO<SubPrcCheckOutDto> subPrcCheckCo(SubPrcCheckInDto subPrcCheckInDto, OprInfo oprInfo) {
        OutDTO<SubPrcCheckOutDto> checkOutDtoOutDTO = iSubPrcCheckAo.subPrcCheckAo(subPrcCheckInDto, oprInfo);
        return checkOutDtoOutDTO;
    }
}
