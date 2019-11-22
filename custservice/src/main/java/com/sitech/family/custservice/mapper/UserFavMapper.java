package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserFav;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户优惠参数实例信息
 */
@Repository
public interface UserFavMapper {

    /**
     *
     */
    int drop(BigDecimal favinsId);

    /**
     *
     */
    int create(UserFav userFav);

    /**
     * 历史表
     */
    int insert(UserFav userFav);

    /**
     *
     */
    List<UserFav> query(BigDecimal favinsId);

    /**
     *
     */
    int modify(UserFav userFav);
}