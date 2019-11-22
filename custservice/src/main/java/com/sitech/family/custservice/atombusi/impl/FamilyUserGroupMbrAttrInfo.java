package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGroupMbrAttrInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员属性
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserGroupMbrAttrInfo implements IFamilyUserGroupMbrAttrInfo {

    /**
     * IUserGroupMbrAttrInfoDao
     */
    @Autowired
    private IUserGroupMbrAttrInfoDao userGroupMbrAttrInfoDao;

    @Override
    public ReturnDto create(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        return userGroupMbrAttrInfoDao.create(userGroupMbrAttrInfoDto);
    }

    @Override
    public ReturnDto modify(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        return userGroupMbrAttrInfoDao.modify(userGroupMbrAttrInfoDto);
    }

    @Override
    public ReturnDto drop(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        return userGroupMbrAttrInfoDao.drop(userGroupMbrAttrInfoDto);
    }

    @Override
    public UserGroupMbrAttrInfo query(BigDecimal memberId, String attrId, String attrNo, Date effDate) {
        return userGroupMbrAttrInfoDao.query(memberId, attrId, attrNo, effDate);
    }

    @Override
    public List<UserGroupMbrAttrInfo> qryUserGroupMbrAttrInfoList(Map map) {
        return userGroupMbrAttrInfoDao.qryUserGroupMbrAttrInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo) {
        return userGroupMbrAttrInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
