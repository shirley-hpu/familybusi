package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyAccountRelInfo;
import com.sitech.family.dao.account.IAccountRelInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.AccountRelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyAccountRelInfo implements IFamilyAccountRelInfo {

    /**
     *
     */
    @Autowired
    private IAccountRelInfoDao accountRelInfoDao;

    @Override
    public ReturnDto create(AccountRelInfo accountRelInfoDto) {
        return accountRelInfoDao.create(accountRelInfoDto);
    }

    @Override
    public ReturnDto modify(AccountRelInfo accountRelInfoDto) {
        return accountRelInfoDao.modify(accountRelInfoDto);
    }

    @Override
    public ReturnDto drop(AccountRelInfo accountRelInfoDto) {
        return accountRelInfoDao.drop(accountRelInfoDto);
    }

    @Override
    public AccountRelInfo query(Long servAcctId) {
        return accountRelInfoDao.query(servAcctId);
    }

    @Override
    public List<AccountRelInfo> qryAccountRelInfoList(Map map) {
        return accountRelInfoDao.qryAccountRelInfoList(map);
    }
}
