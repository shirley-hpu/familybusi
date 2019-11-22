package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description 密码校验服务
 * @date 2019/1/22 14:38
 */
public interface ICheckPassWord {
    public OutDTO<Object> checkPassWord (InDTO<RequestMessage<CheckPassWordInDto>> requestMessage);
}
