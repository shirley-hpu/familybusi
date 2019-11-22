package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IStandardAddressQryAo;
import com.sitech.family.compservice.compbiz.IStandardAddressQryCo;
import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author guanqp
 * @description 宽带安装地址查询
 * @date 2018/12/18
 */
@Component
public class StandardAddressQryCoSvc implements IStandardAddressQryCo{

    @Resource(name="StandardAddressQryAoSvc")
    private IStandardAddressQryAo standardAddressQryAoSvc;

    @Override
    public OutDTO query(InDTO<Map> inDTO) {
        OutDTO<StandarAddressOutDto> outDTO = standardAddressQryAoSvc.query(inDTO);
        return outDTO;
    }
}
