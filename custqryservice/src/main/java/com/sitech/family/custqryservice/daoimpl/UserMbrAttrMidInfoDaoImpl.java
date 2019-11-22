package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.IMbrAttrMid;
import com.sitech.family.custqryservice.dto.mapperdto.MbrAttrMid;
import com.sitech.family.dao.usergroup.IUserMbrAttrMidInfoDao;
import com.sitech.family.dao.usergroup.IUserMbrAttrMidInfoQryDao;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 22:00
 */
@Component
public class UserMbrAttrMidInfoDaoImpl implements IUserMbrAttrMidInfoQryDao {

    private final IMbrAttrMid iMbrAttrMid;

    @Autowired
    public UserMbrAttrMidInfoDaoImpl(IMbrAttrMid iMbrAttrMid) {
        this.iMbrAttrMid = iMbrAttrMid;
    }


    /**
     * 查询
     *
     * @param map
     * @return
     */
    @Override
    public List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map) {
        List<UserMbrAttrMidInfo> userMbrAttrMidInfoList;

        try {
            List<MbrAttrMid> mbrAttrMidList = iMbrAttrMid.qryMbrAttrMidList(map);

            userMbrAttrMidInfoList = new ArrayList<>();

            for (MbrAttrMid mbrAttrMid : mbrAttrMidList) {
                UserMbrAttrMidInfo userMbrAttrMidInfo = new UserMbrAttrMidInfo();

                userMbrAttrMidInfo.setInsType(mbrAttrMid.getInsType());
                userMbrAttrMidInfo.setInsValue(mbrAttrMid.getInsValue());
                userMbrAttrMidInfo.setAttrId(mbrAttrMid.getAttrId());
                userMbrAttrMidInfo.setEffDate(mbrAttrMid.getEffDate());
                userMbrAttrMidInfo.setAttrNo(mbrAttrMid.getAttrNo());
                userMbrAttrMidInfo.setAttrValue(mbrAttrMid.getAttrValue());
                userMbrAttrMidInfo.setGrpNo(mbrAttrMid.getGrpNo());
                userMbrAttrMidInfo.setExpDate(mbrAttrMid.getExpDate());
                userMbrAttrMidInfo.setOpTime(mbrAttrMid.getOpTime());
                userMbrAttrMidInfo.setOpCode(mbrAttrMid.getOpCode());
                userMbrAttrMidInfo.setLoginNo(mbrAttrMid.getLoginNo());
                userMbrAttrMidInfo.setOutAccept(mbrAttrMid.getOutAccept());
                userMbrAttrMidInfo.setLoginAccept(mbrAttrMid.getLoginAccept());
                userMbrAttrMidInfo.setOpNote(mbrAttrMid.getOpNote());
                userMbrAttrMidInfo.setSystemNote(mbrAttrMid.getSystemNote());

                userMbrAttrMidInfoList.add(userMbrAttrMidInfo);
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        return userMbrAttrMidInfoList;
    }

    @Override
    public UserMbrAttrMidInfo query(BigDecimal insValue, String attrId, Date effDate, String attrNo) {
        return null;
    }
}
