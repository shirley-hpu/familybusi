package com.sitech.family.compservice.atombiz;

import com.sitech.family.compservice.dto.indto.UniOrderInfoDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * Created by xuwei on 2019/4/24.
 */
public interface IFamilyOpenAo {
    OutDTO<Object> createUniOrder(UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto);
}
