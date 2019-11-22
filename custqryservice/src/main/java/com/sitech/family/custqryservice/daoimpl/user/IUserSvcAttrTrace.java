package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserSvcAttrTrace;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */
public interface IUserSvcAttrTrace {

    /**
     * 查询服务属性实例轨迹信息
     * @param svcinsId,attrId,attrNo,effDate
     * @return UserSvcAttrTrace
     */
    UserSvcAttrTrace query(BigDecimal svcinsId , String attrId, String attrNo, Date effDate);

}
