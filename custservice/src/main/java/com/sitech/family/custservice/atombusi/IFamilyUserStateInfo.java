package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserStateInfo;

/**
 * @author wusm
 * @description 家庭用户状态变化
 * @date 2018/12/14 14:27
 */
public interface IFamilyUserStateInfo {

    /**
     * 新增家庭用户状态变化
     * @param userStateInfo
     * @return ReturnDto
     */
    void create(UserStateInfo userStateInfo);

    /**
     * 修改家庭用户状态变化
     * @param userStateInfo
     * @return ReturnDto
     */
    void modify(UserStateInfo userStateInfo);

    /**
     * 删除家庭用户状态变化
     * @param userStateInfo
     * @return ReturnDto
     */
    ReturnDto drop(UserStateInfo userStateInfo);

    /**
     * 查询家庭用户状态变化
     * @param userStateInfo
     * @return userStateInfo
     */
    UserStateInfo query(UserStateInfo userStateInfo);

}
