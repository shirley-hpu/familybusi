package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.user.UserServiceNoInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户状态
 * @date 2018/12/14 17:27
 */
public interface IFamilyServiceNoInfo {

    /**
     * 查询家庭用户状态
     * @return userServiceNoInfo
     */
    UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType);

    /**
     * @param map
     * @return list
     */
    List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map);
}
