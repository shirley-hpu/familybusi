package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserFavAttr;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠参数实例
 */
public interface IUserFavAttr {

    /**
     *
     */
    ReturnDto drop(UserFavAttr userFavAttr);

    /**
     *
     */
    ReturnDto create(UserFavAttr userFavAttr);

    /**
     *
     */
    List<UserFavAttr> query(BigDecimal favinsId, String attrId, Date effDate);

    /**
     *
     */
    ReturnDto modify(UserFavAttr userFavAttr);
}