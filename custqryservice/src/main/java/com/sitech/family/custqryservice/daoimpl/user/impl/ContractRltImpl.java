package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IContractRlt;
import com.sitech.family.custqryservice.dto.mapperdto.AccountRel;
import com.sitech.family.custqryservice.mapper.AccountRelMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户关系实体 实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
public class ContractRltImpl implements IContractRlt {

    @Autowired
    private AccountRelMapper accountRelMapper;

    /**
     * 查询账户关系信息
     *
     * @param servAcctId
     * @return AccountRel
     */
    @Override
    public AccountRel query(Long servAcctId) {
        AccountRel accountRel = new AccountRel();

        try {
            accountRel = accountRelMapper.query(servAcctId);
        } catch (Exception e) {
            throw new BusiException("查询账户关系信息失败:" + e.getMessage());
        }

        return accountRel;
    }

}
