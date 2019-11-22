package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGroupMbrInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserGroupMbrInfo implements IFamilyUserGroupMbrInfo {

    /**
     *
     */
    @Autowired
    private IUserGroupMbrInfoDao userGroupMbrInfoDao;

    @Override
    public ReturnDto create(UserGroupMbrInfo userGroupMbrInfoDto) {
        return userGroupMbrInfoDao.create(userGroupMbrInfoDto);
    }

    @Override
    public ReturnDto modify(UserGroupMbrInfo userGroupMbrInfoDto) {
        return userGroupMbrInfoDao.modify(userGroupMbrInfoDto);
    }

    @Override
    public ReturnDto drop(UserGroupMbrInfo userGroupMbrInfoDto) {
        return userGroupMbrInfoDao.drop(userGroupMbrInfoDto);
    }

    @Override
    public UserGroupMbrInfo query(BigDecimal memberId) {
        return userGroupMbrInfoDao.query(memberId);
    }

    @Override
    public List<UserGroupMbrInfo> qryUserGroupMbrInfoList(Map map) {
        return userGroupMbrInfoDao.qryUserGroupMbrInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo) {
        return userGroupMbrInfoDao.updateFinishState(updateOprInfo, idNo);
    }

    /**
     * 查询短流程订单
     *
     * @param map
     * @return
     */
    @Override
    public List<UserGroupMbrInfo> qryShortProcessList(Map map) {
        return userGroupMbrInfoDao.qryShortProcessList(map);
    }
}
