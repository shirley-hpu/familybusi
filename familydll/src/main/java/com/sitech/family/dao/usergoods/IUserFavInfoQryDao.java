package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.usergoods.UserFavInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠参数实例信息
 */
public interface IUserFavInfoQryDao {

    /**
     *
     */
    List<UserFavInfo> query(BigDecimal favinsId);

}