package com.sitech.family.compservice.compbiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  密码校验服务
 * @date 2019/1/22 14:55
 */
public interface ICheckPassWordCo {
    OutDTO<Object> checkPassWord(CheckPassWordInDto checkPassWordInDto,OprInfo oprInfo);
}
