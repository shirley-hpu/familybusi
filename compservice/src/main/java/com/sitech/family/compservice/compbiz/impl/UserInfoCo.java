package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.ICheckCodeAo;
import com.sitech.family.compservice.atombiz.IGetCheckCodeAo;
import com.sitech.family.compservice.atombiz.IUserInfoQryAo;
import com.sitech.family.compservice.compbiz.IUserInfoCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.family.compservice.dto.outdto.UserInfoOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author guanqp
 * @Description 用户基本信息查询
 * @date 2019/01/15
 */
@Component
public class UserInfoCo implements IUserInfoCo {

    @Resource(name = "UserInfoQryAoSvc")
    private IUserInfoQryAo UserInfoQryAoSvc;

    @Resource(name = "GetCheckCodeAoSvc")
    private IGetCheckCodeAo iGetCheckCodeAo;

    @Resource(name = "CheckCodeAoSvc")
    private ICheckCodeAo iCheckCodeAo;

    @Override
    public OutDTO query(UserInfoQryInDto userInfoQryInDto, OprInfo oprInfo) {
        OutDTO outDTO = UserInfoQryAoSvc.userInfoQry(userInfoQryInDto, oprInfo);
        return outDTO;
    }

    @Override
    public OutDTO<Object> qryCheckCode(GetCheckCodeInDto getCheckCodeInDto, OprInfo oprInfo) {
        OutDTO<Object> outDto = iGetCheckCodeAo.getCheckCode(getCheckCodeInDto, oprInfo);
        return outDto;
    }

    @Override
    public OutDTO<Object> chkCheckCode(CheckCodeInDto checkCodeInDto, OprInfo oprInfo) {
        OutDTO<Object> objectOutDTO = iCheckCodeAo.checkCode(checkCodeInDto, oprInfo);
        return objectOutDTO;
    }
}
