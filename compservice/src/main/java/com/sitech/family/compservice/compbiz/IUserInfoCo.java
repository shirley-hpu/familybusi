package com.sitech.family.compservice.compbiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.family.compservice.dto.outdto.UserInfoOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  用户基本信息查询
 * @date 2019/01/15
 */
public interface IUserInfoCo {
    OutDTO query(UserInfoQryInDto userInfoQryInDto, OprInfo oprInfo);

    OutDTO<Object> qryCheckCode(GetCheckCodeInDto getCheckCodeInDto, OprInfo oprInfo);

    OutDTO<Object> chkCheckCode(CheckCodeInDto checkCodeInDto, OprInfo oprInfo);
}
