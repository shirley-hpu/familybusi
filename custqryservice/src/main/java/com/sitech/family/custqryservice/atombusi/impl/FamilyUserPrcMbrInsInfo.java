package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserPrcMbrInsInfo;
import com.sitech.family.dao.usergroup.IUserPrcMbrInsInfoQryDao;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource(name = "userPrcMbrInsInfoQryDaoImpl")
    private IUserPrcMbrInsInfoQryDao userPrcMbrInsInfoDao;

    @Override
    public UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId) {
        return userPrcMbrInsInfoDao.query(memberId, prodPrcInsId);
    }

    @Override
    public List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map) {
        return userPrcMbrInsInfoDao.qryUserPrcMbrInsInfoList(map);
    }
}
