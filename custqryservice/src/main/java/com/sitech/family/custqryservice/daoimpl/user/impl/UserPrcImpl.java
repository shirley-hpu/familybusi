package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserPrc;
import com.sitech.family.custqryservice.dto.mapperdto.UserPrc;
import com.sitech.family.custqryservice.mapper.IUserPrcMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 用户订购产品资费实例
 * @date 2018/12/10 10:27
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserPrcImpl implements IUserPrc {

    @Autowired
    private IUserPrcMapper mapper;

    /**
     * 查询用户订购产品资费实例信息
     *
     * @param prodprcinsId
     * @return List<UserPrc>
     */
    @Override
    public UserPrc query(BigDecimal prodprcinsId) {
        UserPrc userPrc = new UserPrc();
        try {
            userPrc = mapper.query(prodprcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户订购产品资费实例信息失败" + e.getMessage());
        }

        return userPrc;
    }

}
