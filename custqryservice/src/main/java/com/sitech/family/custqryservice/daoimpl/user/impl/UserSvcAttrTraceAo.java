package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserSvcAttrTrace;
import com.sitech.family.custqryservice.dto.mapperdto.UserSvcAttrTrace;
import com.sitech.family.custqryservice.mapper.IUserSvcAttrTraceMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserSvcAttrTraceAo implements IUserSvcAttrTrace {

    @Autowired
    private IUserSvcAttrTraceMapper mapper;

    /**
     * 查询服务属性实例轨迹信息
     *
     * @param svcinsId,attrId,attrNo,effDate
     * @return UserSvcAttrTrace
     */
    @Override
    public UserSvcAttrTrace query(BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        UserSvcAttrTrace userSvcAttrTrace = new UserSvcAttrTrace();

        try {
            userSvcAttrTrace = mapper.query(svcinsId, attrId, attrNo, effDate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务属性实例轨迹信息失败" + e.getMessage());
        }

        return userSvcAttrTrace;
    }

}
