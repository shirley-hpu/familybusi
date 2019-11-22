package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.family.compservice.dto.outdto.UserInfoOutDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  用户基本信息查询
 * @date 2019/01/15
 */
public interface IUserInfoQryAo {
    public OutDTO userInfoQry(UserInfoQryInDto userInfoQryInDto, OprInfo oprInfo);
}
