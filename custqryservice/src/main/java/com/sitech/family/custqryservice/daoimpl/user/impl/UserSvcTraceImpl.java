package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserSvcTrace;
import com.sitech.family.custqryservice.dto.mapperdto.UserSvcTrace;
import com.sitech.family.custqryservice.mapper.IUserSvcTraceMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 17:55
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserSvcTraceImpl implements IUserSvcTrace {

    @Autowired
    private IUserSvcTraceMapper mapper;

    /**
     * 查询服务实例轨迹信息
     *
     * @param svcinsId
     * @return List<UserSvcTrace>
     */
    @Override
    public UserSvcTrace query(BigDecimal svcinsId) {
        UserSvcTrace userSvcTrace = new UserSvcTrace();

        try {
            userSvcTrace = mapper.query(svcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务实例轨迹信息失败" + e.getMessage());
        }

        return userSvcTrace;
    }

}
