package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  密码校验服务
 * @date 2019/1/22 15:06
 */
public interface ICheckPassWordAo {
    OutDTO<Object> checkPassWord(CheckPassWordInDto checkPassWordInDto,OprInfo oprInfo);
}
