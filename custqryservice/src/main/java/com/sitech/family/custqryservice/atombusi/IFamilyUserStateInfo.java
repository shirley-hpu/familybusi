package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.user.UserStateInfo;

import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户状态变化
 * @date 2018/12/14 14:27
 */
public interface IFamilyUserStateInfo {

    /**
     * 查询家庭用户状态变化
     * @param userStateInfo
     * @return userStateInfo
     */
    Map<String,Object> query(UserStateInfo userStateInfo);
}
