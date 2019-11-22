package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserStateInfo;
import com.sitech.family.dao.user.IUserStateInfoQryDao;
import com.sitech.family.dto.user.UserStateInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 18:26
 */
@Component
public class FamilyUserStateInfo implements IFamilyUserStateInfo {

    @Autowired
    private IUserStateInfoQryDao iUserStateInfoQryDao;

    /**
     * 查询家庭用户状态变化
     * @param userStateInfo
     * @return userStateInfo
     */
    @Override
    public Map<String, Object> query(UserStateInfo userStateInfo) {
        Map<String, Object> map = new HashMap<>();

        try {
            UserStateInfo stateInfo = iUserStateInfoQryDao.query(userStateInfo.getStateChangeNo());

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户状态变化失败");
        }

        return map;
    }
}
