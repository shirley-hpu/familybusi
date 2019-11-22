package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserPrc;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description 用户订购产品资费实例
 * @date 2018/12/10 10:20
 */
public interface IUserPrc {

    /**
     * 查询用户订购产品资费实例信息
     * @param prodprcinsId
     * @return UserPrc
     */
    UserPrc query(BigDecimal prodprcinsId);

}
