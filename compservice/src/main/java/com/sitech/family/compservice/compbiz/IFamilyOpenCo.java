package com.sitech.family.compservice.compbiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.FamilyOpenCfmInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * Created by xuwei on 2019/4/22.
 */


public interface IFamilyOpenCo {
    OutDTO<Object> create(FamilyOpenCfmInDto familyOpenCfmInDto, OprInfo oprInfo);
}
