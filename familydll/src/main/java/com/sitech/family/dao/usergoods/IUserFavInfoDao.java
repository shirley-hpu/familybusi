package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠参数实例信息
 */
public interface IUserFavInfoDao {

    /**
     *
     */
    ReturnDto drop(BigDecimal favinsId);

    /**
     *
     */
    ReturnDto create(UserFavInfo record);

    /**
     *
     */
    List<UserFavInfo> query(BigDecimal favinsId);

    /**
     *
     */
    ReturnDto modify(UserFavInfo record);
}