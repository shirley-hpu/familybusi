package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserAddInfo;
import com.sitech.family.dao.user.IUserAddInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserAddInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:59
 */
@Component
public class FamilyUserAddInfo implements IFamilyUserAddInfo {

    @Autowired
    private IUserAddInfoDao iUserAddInfoDao;

    /**
     * 新增家庭用户附加信息
     *
     * @param userAddInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserAddInfo userAddInfo) {
        return iUserAddInfoDao.create(userAddInfo);
    }

    /**
     * 修改家庭用户附加信息
     *
     * @param userAddInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserAddInfo userAddInfo) {
        return iUserAddInfoDao.modify(userAddInfo);
    }

    /**
     * 删除家庭用户附加信息
     *
     * @param userAddInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserAddInfo userAddInfo) {
        return iUserAddInfoDao.drop(userAddInfo);
    }

    /**
     * 查询家庭用户附加信息
     *
     * @return userAddInfo
     */
    @Override
    public UserAddInfo query(Long idNo, String fieldCode) {
        return iUserAddInfoDao.query(idNo, fieldCode);
    }

    @Override
    public List<UserAddInfo> qryUserAddInfoList(Map map) {
        return null;
    }
}
