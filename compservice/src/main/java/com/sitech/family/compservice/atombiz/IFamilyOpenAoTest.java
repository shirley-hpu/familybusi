package com.sitech.family.compservice.atombiz;

import com.sitech.family.compservice.dto.indto.UniOrderInfoDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author wusm
 * @description
 * @date 2019/5/14 11:17
 */
public interface IFamilyOpenAoTest {

    /**
     * 在途状态
     * @param familyOrderBodyInfoDto
     * @return
     */
    public OutDTO createUniOrderTest(UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto);
}
