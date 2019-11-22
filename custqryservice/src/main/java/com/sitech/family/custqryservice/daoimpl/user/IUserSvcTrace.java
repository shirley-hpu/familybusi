package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserSvcTrace;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description 服务实例轨迹信息
 * @date 2018/12/17 17:53
 */
public interface IUserSvcTrace {

    /**
     * 查询服务实例轨迹信息
     * @param svcinsId
     * @return UserSvcTrace
     */
    UserSvcTrace query(BigDecimal svcinsId);

}
