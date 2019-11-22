package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.ICrmToBossStateInfo;
import com.sitech.family.dao.user.ICrmToBossStateDao;
import com.sitech.family.dto.ReturnDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 16:07
 */
@Component
public class CrmToBossStateInfo implements ICrmToBossStateInfo {
    @Resource
    private ICrmToBossStateDao crmToBossStateDao;

    @Override
    public void create(com.sitech.family.dto.user.CrmToBossStateInfo crmToBossStateInfo) {

    }

    @Override
    public ReturnDto drop(com.sitech.family.dto.user.CrmToBossStateInfo crmToBossStateInfo) {
        return null;
    }

    @Override
    public void modify(com.sitech.family.dto.user.CrmToBossStateInfo crmToBossStateInfo) {
        crmToBossStateDao.modify(crmToBossStateInfo);
    }

    @Override
    public com.sitech.family.dto.user.CrmToBossStateInfo query(com.sitech.family.dto.user.CrmToBossStateInfo crmToBossStateInfo) {
        return crmToBossStateDao.query(crmToBossStateInfo);
    }
}
