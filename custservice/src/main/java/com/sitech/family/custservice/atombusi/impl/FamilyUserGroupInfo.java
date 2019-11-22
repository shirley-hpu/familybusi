package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 16:09
 */
@Component
public class FamilyUserGroupInfo implements IFamilyUserGroupInfo {

    @Autowired
    private IUserGroupInfoDao iUserGroupInfoDao;

    /**
     * 新增家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGroupInfo userGroup) {
        return iUserGroupInfoDao.create(userGroup);
    }

    /**
     * 修改家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGroupInfo userGroup) {
        return iUserGroupInfoDao.modify(userGroup);
    }

    /**
     * 删除家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGroupInfo userGroup) {
        return iUserGroupInfoDao.drop(userGroup);
    }

    /**
     * 查询家庭群成员信息
     *
     * @param groupId
     * @return userGroup
     */
    @Override
    public UserGroupInfo query(BigDecimal groupId) {
        return iUserGroupInfoDao.query(groupId);
    }

    @Override
    public List<UserGroupInfo> qryUserGroupInfoList(Map map) {
        return iUserGroupInfoDao.qryUserGroupInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        return iUserGroupInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
