package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserStateInfo;
import com.sitech.family.dao.user.IUserStateInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserStateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 14:09
 */
@Component
public class FamilyUserStateInfo implements IFamilyUserStateInfo {

    @Autowired
    private IUserStateInfoDao iUserStateInfoDao;

    /**
     * 新增家庭用户状态变化
     *
     * @param userStateInfo
     * @return ReturnDto
     */
    @Override
    public void create(UserStateInfo userStateInfo) {
        iUserStateInfoDao.create(userStateInfo);
    }
    /**
     * 修改家庭用户状态变化
     * @param userStateInfo
     * @return ReturnDto
     */
    @Override
    public void modify(UserStateInfo userStateInfo) {
        iUserStateInfoDao.modify(userStateInfo);
    }
    /**
     * 删除家庭用户状态变化
     *
     * @param userStateInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserStateInfo userStateInfo) {
        return null;
    }
    /**
     * 查询家庭用户状态变化
     *
     * @param userStateInfo
     * @return userStateInfo
     */
    @Override
    public UserStateInfo query(UserStateInfo userStateInfo) {
        return null;
    }
}
