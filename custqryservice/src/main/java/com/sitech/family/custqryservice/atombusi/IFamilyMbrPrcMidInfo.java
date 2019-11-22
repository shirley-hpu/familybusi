package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:41
 */
public interface IFamilyMbrPrcMidInfo {


    /**
     * 查询成员订购实例
     * @param map
     * @return list
     */
    List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map);
}
