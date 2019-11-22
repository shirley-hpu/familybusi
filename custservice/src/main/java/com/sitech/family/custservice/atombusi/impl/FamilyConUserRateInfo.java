package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyConUserRateInfo;

import com.sitech.family.dao.account.IConUserRateInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.ConUserRateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 10:35
 */
@Component
public class FamilyConUserRateInfo implements IFamilyConUserRateInfo {

    @Autowired
    private IConUserRateInfoDao iConUserRateInfoDao;

    /**
     * 新增家庭付费明细
     *
     * @param conUserRateInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(ConUserRateInfo conUserRateInfo) {
        return iConUserRateInfoDao.create(conUserRateInfo);
    }

    /**
     * 修改家庭付费明细
     *
     * @param conUserRateInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(ConUserRateInfo conUserRateInfo) {
        return iConUserRateInfoDao.modify(conUserRateInfo);
    }

    /**
     * 删除家庭付费明细
     *
     * @param conUserRateInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(ConUserRateInfo conUserRateInfo) {
        return iConUserRateInfoDao.drop(conUserRateInfo);
    }

    /**
     * 查询家庭群成员信息
     *
     * @return conUserRateInfo
     */
    @Override
    public ConUserRateInfo query(Long servAcctId, String feeCode, Date effDate, String detailCode) {
        return iConUserRateInfoDao.query(servAcctId, feeCode, effDate, detailCode);
    }

    @Override
    public List<ConUserRateInfo> qryConUserRateInfoList(Map map) {
        return iConUserRateInfoDao.qryConUserRateInfoList(map);
    }
}
