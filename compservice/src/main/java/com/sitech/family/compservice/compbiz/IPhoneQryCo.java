package com.sitech.family.compservice.compbiz;

import com.sitech.family.compservice.dto.indto.PhoneQryInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * Created by xuwei on 2018/12/14.
 */
public interface IPhoneQryCo {
    Map query(Map<String, Object> map);

    /**
     * SIM卡号查询
     * @param map
     * @return
     */
    Map querySim(Map<String,Object> map);
}
