package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠参数实例
 */
public interface IFamilyUserFavAttrInfo {

    /**
     *
     */
    ReturnDto drop(UserFavAttrInfo userFavAttrInfo);

    /**
     *
     */
    ReturnDto create(UserFavAttrInfo userFavAttrInfo);

    /**
     *
     */
    List<UserFavAttrInfo> query(BigDecimal favinsId, String attrId, Date effDate);

    /**
     *
     */
    ReturnDto modify(UserFavAttrInfo userFavAttrInfo);
}
