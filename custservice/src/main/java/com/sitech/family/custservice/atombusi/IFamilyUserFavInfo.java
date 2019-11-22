package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠订购实例信息
 */
public interface IFamilyUserFavInfo {

    /**
     *
     */
    ReturnDto drop(UserFavInfo userFavInfoDto);

    /**
     *
     */
    ReturnDto create(UserFavInfo userFavInfoDto);

    /**
     *
     */
    List<UserFavInfo> query(BigDecimal favinsId);

    /**
     *
     */
    ReturnDto modify(UserFavInfo userFavInfoDto);

}
