package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IPhoneQryAo;
import com.sitech.family.compservice.atombiz.impl.PhoneQryAoSvc;
import com.sitech.family.compservice.compbiz.IPhoneQryCo;
import com.sitech.family.compservice.dto.indto.PhoneQryInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by xuwei on 2018/12/14.
 */
@Component
public class PhoneQryCoSvc implements IPhoneQryCo {

    @Resource(name="PhoneQryAoSvc")
    private IPhoneQryAo phoneQryAoSvc;

    @Override
    public Map<String,Object> query(Map<String, Object> map) {
        Map<String,Object> outDTO= phoneQryAoSvc.query(map);
        return outDTO;
    }

    @Override
    public Map querySim(Map<String, Object> map) {
        Map<String,Object> outDTO= phoneQryAoSvc.querySim(map);
        return outDTO;
    }
}