package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:41
 */
public interface IFamilyMbrAttrMidInfo {


    /**
     * 查询成员订购属性实例
     * @param map
     * @return list
     */
    List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map);
}
