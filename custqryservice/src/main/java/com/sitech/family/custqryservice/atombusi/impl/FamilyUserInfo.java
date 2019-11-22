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
 * @author wusm
 * @description
 * @date 2018/12/14 17:04
 */
@Component
public class FamilyUserInfo implements IFamilyUserInfo {
    private static final Logger logger = LoggerFactory.getLogger(FamilyUserInfo.class);
    @Resource(name="userInfoDaoImpl")
    private IUserInfoQryDao iUserInfoQryDao;

    @Override
    public UserInfo query(Long idNo) {
        return iUserInfoQryDao.query(idNo);
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {
        return iUserInfoQryDao.qryUserInfoList(map);
    }

    @Override
    public UserInfo qryFamilyUserBasicInfo(Map map) {
        List<UserInfo> userInfos = iUserInfoQryDao.qryUserInfoList(map);
        logger.debug(">>>>>>>>>>>>"+userInfos.get(0));
        return userInfos.get(0);
    }

    /**
     * 手机号码查询已订购附加信息
     *
     * @param map
     * @return
     */
    @Override
    public List qryOrderFeeByPhoneNo(Map map) {
        return iUserInfoQryDao.qryOrderFeeByPhoneNo(map);
    }
}
