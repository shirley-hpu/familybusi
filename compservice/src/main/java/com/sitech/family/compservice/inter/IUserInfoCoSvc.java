package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.family.compservice.dto.outdto.UserInfoOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description 用户基本信息查询
 * @date 2019/01/15
 */
public interface IUserInfoCoSvc {

    /**
     * 获取用户基本信息
     *
     * @param requestMessage
     * @return
     */
    public OutDTO qryUserInfo(InDTO<RequestMessage<UserInfoQryInDto>> requestMessage);

    /**
     * 获取验证码
     *
     * @param requestMessage
     * @return
     */
    public OutDTO<Object> qryCheckCode(InDTO<RequestMessage<GetCheckCodeInDto>> requestMessage);

    /**
     * 验证码或密码提交校验
     *
     * @param requestMessage
     * @return
     */
    public OutDTO<Object> chkCheckCode(InDTO<RequestMessage<CheckCodeInDto>> requestMessage);
}
