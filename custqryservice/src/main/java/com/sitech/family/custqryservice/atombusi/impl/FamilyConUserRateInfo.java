package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyConUserRateInfo;
import com.sitech.family.dao.account.IConUserRateInfoQryDao;
import com.sitech.family.dto.account.ConUserRateInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 10:35
 */
@Component
public class FamilyConUserRateInfo implements IFamilyConUserRateInfo {

    @Autowired
    private IConUserRateInfoQryDao iConUserRateInfoQryDao;

    @Override
    public ConUserRateInfo query(Long servAcctId, String feeCode, Date effDate, String detailCode) {
        return iConUserRateInfoQryDao.query(servAcctId, feeCode, effDate, detailCode);
    }

    @Override
    public List<ConUserRateInfo> qryConUserRateInfoList(Map map) {
        return iConUserRateInfoQryDao.qryConUserRateInfoList(map);
    }
}
