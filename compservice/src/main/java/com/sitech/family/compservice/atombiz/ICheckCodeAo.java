package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  验证码校验
 * @date 2019/1/21 18:11
 */
public interface ICheckCodeAo {
    OutDTO<Object> checkCode(CheckCodeInDto checkCodeInDto, OprInfo oprInfo);
}
