package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.AccountRel;

import org.springframework.stereotype.Repository;

/**
 * 账户关系实体
 */
@Repository
public interface AccountRelMapper {

    /**
     * @param servAcctId
     * @return AccountRel
     */
    AccountRel query(Long servAcctId);

}