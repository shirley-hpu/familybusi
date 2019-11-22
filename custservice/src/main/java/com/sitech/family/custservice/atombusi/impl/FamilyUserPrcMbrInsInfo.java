package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserPrcMbrInsInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserPrcMbrInsInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserPrcMbrInsInfo implements IFamilyUserPrcMbrInsInfo {

    /**
     *
     */
    @Autowired
    private IUserPrcMbrInsInfoDao userPrcMbrInsInfoDao;

    @Override
    public ReturnDto create(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        return userPrcMbrInsInfoDao.create(userPrcMbrInsInfoDto);
    }

    @Override
    public ReturnDto modify(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        return userPrcMbrInsInfoDao.modify(userPrcMbrInsInfoDto);
    }

    @Override
    public ReturnDto drop(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        return userPrcMbrInsInfoDao.drop(userPrcMbrInsInfoDto);
    }

    @Override
    public UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId) {
        return userPrcMbrInsInfoDao.query(memberId, prodPrcInsId);
    }

    @Override
    public List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map) {
        return userPrcMbrInsInfoDao.qryUserPrcMbrInsInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo) {
        return userPrcMbrInsInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
