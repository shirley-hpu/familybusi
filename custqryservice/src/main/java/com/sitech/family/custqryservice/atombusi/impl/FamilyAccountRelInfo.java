package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyAccountRelInfo;
import com.sitech.family.custqryservice.dto.mapperdto.AccountRel;
import com.sitech.family.dao.account.IAccountRelInfoQryDao;
import com.sitech.family.dto.account.AccountRelInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public abstract class FamilyAccountRelInfo implements IFamilyAccountRelInfo {

    /**
     *
     */
    @Resource(name = "accountRelInfoQryDaoImpl")
    private IAccountRelInfoQryDao accountRelInfoQryDao;

    @Override
    public AccountRelInfo query(Long servAcctId) {
        return accountRelInfoQryDao.query(servAcctId);
    }

    @Override
    public List<AccountRelInfo> qryAccountRelInfoList(Map map) {
        return accountRelInfoQryDao.qryAccountRelInfoList(map);
    }
}
