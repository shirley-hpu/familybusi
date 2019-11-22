package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserInfo;
import com.sitech.family.dao.user.IUserInfoQryDao;
import com.sitech.family.dto.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangc
 * @description
 * @date 2019/09/16 17:19
 */
@Component("familyUserDetailInfo")
public class FamilyUserDetailInfo implements IFamilyUserInfo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyUserDetailInfo.class);

    @Resource(name="userDetailInfoDaoImpl")
    private IUserInfoQryDao iUserDetailInfoQryDao;

    @Override
    public UserInfo query(Long idNo) {

        return iUserDetailInfoQryDao.query(idNo);
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {

        return null;
    }

    @Override
    public UserInfo qryFamilyUserBasicInfo(Map map) {

        return null;
    }

    /**
     * 手机号码查询已订购附加信息
     *
     * @param map
     * @return
     */
    @Override
    public List qryOrderFeeByPhoneNo(Map map) {

        return null;
    }
}
