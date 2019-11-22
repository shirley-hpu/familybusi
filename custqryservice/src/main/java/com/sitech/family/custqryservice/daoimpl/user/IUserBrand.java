package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.UserBrand;

import java.util.Date;

public interface IUserBrand {

    /**
     * 查询用户与品牌间的关系
     * @param idNo,brandId,effDate
     * @return UserBrand
     */
    UserBrand query(Long idNo, String brandId, Date effDate);

}
