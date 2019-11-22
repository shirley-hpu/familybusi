package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserFav;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠参数实例信息
 */
public interface IUserFav {

    /**
     *
     */
    ReturnDto drop(UserFav userFav);

    /**
     *
     */
    ReturnDto create(UserFav userFav);

    /**
     *
     */
    List<UserFav> query(BigDecimal favinsId);

    /**
     *
     */
    ReturnDto modify(UserFav userFav);
}