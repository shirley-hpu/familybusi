package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserInfo;
import com.sitech.family.dao.user.IUserInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:04
 */
@Component
public class FamilyUserInfo implements IFamilyUserInfo {

    @Autowired
    private IUserInfoDao iUserInfoDao;

    /**
     * 新增家庭用户
     *
     * @param userInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserInfo userInfo) {
        return iUserInfoDao.create(userInfo);
    }

    /**
     * 修改家庭用户
     *
     * @param userInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserInfo userInfo) {
        return iUserInfoDao.modify(userInfo);
    }

    /**
     * 删除家庭用户
     *
     * @param userInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserInfo userInfo) {
        return iUserInfoDao.drop(userInfo);
    }

    /**
     * 查询家庭用户
     *
     * @param idNo
     * @return userInfo
     */
    @Override
    public UserInfo query(Long idNo) {
        return iUserInfoDao.query(idNo);
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {
        return iUserInfoDao.qryUserInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        return iUserInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
