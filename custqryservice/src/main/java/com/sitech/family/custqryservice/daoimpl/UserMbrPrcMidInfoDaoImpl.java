package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.IMbrPrcMid;
import com.sitech.family.custqryservice.dto.mapperdto.MbrPrcMid;
import com.sitech.family.dao.usergroup.IUserMbrPrcMidInfoQryDao;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
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
public class UserMbrPrcMidInfoDaoImpl implements IUserMbrPrcMidInfoQryDao {

    private final IMbrPrcMid iMbrPrcMid;

    @Autowired
    public UserMbrPrcMidInfoDaoImpl(IMbrPrcMid iMbrPrcMid) {
        this.iMbrPrcMid = iMbrPrcMid;
    }


    /**
     * @param map
     * @return
     */
    @Override
    public List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map) {

        List<UserMbrPrcMidInfo> userMbrPrcMidInfoList;

        try {
            List<MbrPrcMid> mbrPrcMidList = iMbrPrcMid.qryMbrPrcMidList(map);

            userMbrPrcMidInfoList = new ArrayList<>();

            for (MbrPrcMid mbrPrcMid : mbrPrcMidList) {
                UserMbrPrcMidInfo userMbrPrcMidInfo = new UserMbrPrcMidInfo();

                userMbrPrcMidInfo.setMemberId(mbrPrcMid.getMemberId());
                userMbrPrcMidInfo.setInsType(mbrPrcMid.getInsType());
                userMbrPrcMidInfo.setInsValue(mbrPrcMid.getInsValue());
                userMbrPrcMidInfo.setParinsId(mbrPrcMid.getParinsId());
                userMbrPrcMidInfo.setOtherinsId(mbrPrcMid.getOtherinsId());
                userMbrPrcMidInfo.setRelopType(mbrPrcMid.getRelopType());
                userMbrPrcMidInfo.setRelationType(mbrPrcMid.getRelationType());
                userMbrPrcMidInfo.setRelinsId(mbrPrcMid.getRelinsId());
                userMbrPrcMidInfo.setMainFlag(mbrPrcMid.getMainFlag());
                userMbrPrcMidInfo.setGoodsId(mbrPrcMid.getGoodsId());
                userMbrPrcMidInfo.setPrcId(mbrPrcMid.getPrcId());
                userMbrPrcMidInfo.setSvcId(mbrPrcMid.getSvcId());
                userMbrPrcMidInfo.setProdId(mbrPrcMid.getProdId());
                userMbrPrcMidInfo.setEffDate(mbrPrcMid.getEffDate());
                userMbrPrcMidInfo.setExpDate(mbrPrcMid.getExpDate());
                userMbrPrcMidInfo.setOrderDate(mbrPrcMid.getOrderDate());
                userMbrPrcMidInfo.setOpTime(mbrPrcMid.getOpTime());
                userMbrPrcMidInfo.setOpCode(mbrPrcMid.getOpCode());
                userMbrPrcMidInfo.setLoginNo(mbrPrcMid.getLoginNo());
                userMbrPrcMidInfo.setOutAccept(mbrPrcMid.getOutAccept());
                userMbrPrcMidInfo.setLoginAccept(mbrPrcMid.getLoginAccept());
                userMbrPrcMidInfo.setOpNote(mbrPrcMid.getOpNote());
                userMbrPrcMidInfo.setSystemNote(mbrPrcMid.getSystemNote());

                userMbrPrcMidInfoList.add(userMbrPrcMidInfo);
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        return userMbrPrcMidInfoList;
    }

    @Override
    public UserMbrPrcMidInfo query(BigDecimal insValue) {
        return null;
    }
}
