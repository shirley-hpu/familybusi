package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupMbrAttrInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrAttrInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource(name = "userGroupMbrAttrInfoQryDaoImpl")
    private IUserGroupMbrAttrInfoQryDao userGroupMbrAttrInfoDao;

    @Override
    public UserGroupMbrAttrInfo query(BigDecimal memberId, String attrId, String attrNo, Date effDate) {
        return userGroupMbrAttrInfoDao.query(memberId, attrId, attrNo, effDate);
    }

    @Override
    public List<UserGroupMbrAttrInfo> qryUserGroupMbrAttrInfoList(Map map) {
        return userGroupMbrAttrInfoDao.qryUserGroupMbrAttrInfoList(map);
    }
}
