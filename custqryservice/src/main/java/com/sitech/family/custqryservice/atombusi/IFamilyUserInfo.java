package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.custqryservice.dto.mapperdto.User;
import com.sitech.family.dto.user.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户
 * @date 2018/12/14 17:00
 */
public interface IFamilyUserInfo {

    /**
     * 查询家庭用户
     * @param idNo
     * @return userInfo
     */
    UserInfo query(Long idNo);

    /**
     * @param map
     * @return
     */
    List<UserInfo> qryUserInfoList(Map map);

    UserInfo qryFamilyUserBasicInfo(Map map);

    /**
     * 手机号码查询已订购附加信息
     * @param map
     * @return
     */
    List qryOrderFeeByPhoneNo(Map map);
}
