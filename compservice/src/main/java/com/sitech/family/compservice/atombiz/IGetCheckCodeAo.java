package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  获取验证码
 * @date 2019/01/21
 */
public interface IGetCheckCodeAo {
    OutDTO<Object> getCheckCode(GetCheckCodeInDto getCheckCodeInDto,OprInfo oprInfo);
}
