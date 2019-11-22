package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserFavAttr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 用户优惠信息实例
 */
@Repository
public interface UserFavAttrMapper {

    /**
     *
     */
    int drop(BigDecimal favinsId, String attrId, Date effDate);

    /**
     *
     */
    int create(UserFavAttr userFavAttr);

    /**
     * 历史表
     */
    int insert(UserFavAttr userFavAttr);

    /**
     *
     */
    List<UserFavAttr> query(BigDecimal favinsId, String attrId, Date effDate);

    /**
     *
     */
    int modify(UserFavAttr userFavAttr);
}