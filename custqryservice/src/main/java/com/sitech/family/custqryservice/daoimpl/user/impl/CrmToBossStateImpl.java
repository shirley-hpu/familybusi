package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.ICrmToBossState;
import com.sitech.family.custqryservice.dto.mapperdto.CrmToBossState;
import com.sitech.family.custqryservice.mapper.CrmToBossStateMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @program: familybusi
 * @description: 用户CRM&BOSS状态同步实体实现
 * @author: yang xing
 * @create: 2018-12-19 17:22
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class CrmToBossStateImpl implements ICrmToBossState {

    @Autowired
    private CrmToBossStateMapper crmToBossStateMapper;

    /**
     * 查询用户CRM和BOSS状态同步
     * @param idNo
     * @return CrmToBossState
     */
    @Override
    public CrmToBossState query(Long idNo) {
        CrmToBossState crmToBossState = new CrmToBossState();

        try {
            crmToBossState = crmToBossStateMapper.query(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        return crmToBossState;
    }

}
