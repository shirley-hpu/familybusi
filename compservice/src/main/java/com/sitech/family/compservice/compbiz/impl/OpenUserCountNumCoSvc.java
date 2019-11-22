package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IOpenUserCountNumAo;
import com.sitech.family.compservice.compbiz.IOpenUserCountNumCo;
import com.sitech.family.compservice.dto.indto.OpenUserInDto;
import com.sitech.family.compservice.dto.outdto.OpenUserCountNumOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
@Component
public class OpenUserCountNumCoSvc implements IOpenUserCountNumCo {

    @Resource(name="OpenUserCountNumAoSvc")
    private IOpenUserCountNumAo iOpenUserCountNumAo;

    @Override
    public OutDTO<OpenUserCountNumOutDto> check(OpenUserInDto openUserInDto) {
        OutDTO<OpenUserCountNumOutDto> outDTO= iOpenUserCountNumAo.OpenUserCountNum(openUserInDto);
        return outDTO;
    }
}
