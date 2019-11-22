package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.usergoods.UserFavAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠信息实例
 */
public interface IUserFavAttrInfoQryDao {

    /**
     *
     */
    List<UserFavAttrInfo> query(BigDecimal favinsId, String attrId, Date effDate);

}