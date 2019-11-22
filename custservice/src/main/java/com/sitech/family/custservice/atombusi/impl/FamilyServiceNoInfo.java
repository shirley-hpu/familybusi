package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyServiceNoInfo;
import com.sitech.family.dao.user.IServiceNoInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserServiceNoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:29
 */
@Component
public class FamilyServiceNoInfo implements IFamilyServiceNoInfo {

    @Autowired
    private IServiceNoInfoDao iServiceNoInfoDao;

    /**
     * 新增家庭用户状态
     *
     * @param userServiceNoInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserServiceNoInfo userServiceNoInfo) {
        return iServiceNoInfoDao.create(userServiceNoInfo);
    }

    /**
     * 修改家庭用户状态
     *
     * @param userServiceNoInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserServiceNoInfo userServiceNoInfo) {
        return iServiceNoInfoDao.modify(userServiceNoInfo);
    }

    /**
     * 删除家庭用户状态
     *
     * @param userServiceNoInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserServiceNoInfo userServiceNoInfo) {
        return iServiceNoInfoDao.drop(userServiceNoInfo);
    }

    /**
     * 查询家庭用户状态
     *
     * @return userServiceNoInfo
     */
    @Override
    public UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType) {
        return iServiceNoInfoDao.query(serviceNo, idNo, serviceType);
    }

    @Override
    public List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map) {
        return iServiceNoInfoDao.qryUserServiceNoInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        return iServiceNoInfoDao.updateFinishState(updateOprInfo, idNo);
    }
}
