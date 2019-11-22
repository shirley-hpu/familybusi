package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import com.sitech.family.custqryservice.mapper.IUserGroupMapper;
import com.sitech.family.dao.usergroup.IUserGroupInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 16:09
 */
@Component
public class FamilyUserGroupInfo implements IFamilyUserGroupInfo {

    @Autowired
    private IUserGroupInfoQryDao iUserGroupInfoQryDao;

    @Override
    public UserGroupInfo query(BigDecimal groupId) {
        return iUserGroupInfoQryDao.query(groupId);
    }

    @Override
    public List<UserGroupInfo> qryUserGroupInfoList(Map map) {
        return iUserGroupInfoQryDao.qryUserGroupInfoList(map);
    }

    @Override
    public UserGroupInfo qryUserGroupInfo(Map map) {
        List<UserGroupInfo> userGroupInfos = iUserGroupInfoQryDao.qryUserGroupInfoList(map);
        return userGroupInfos.get(0);
    }

}
