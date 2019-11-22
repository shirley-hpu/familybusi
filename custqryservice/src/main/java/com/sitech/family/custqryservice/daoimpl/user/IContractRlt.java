package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.AccountRel;

import java.util.List;

/**
 * @author shirley
 * @description 账户关系实体
 * @date created in 2018/12/3
 * @modified
 */
public interface IContractRlt {

   /**
     * 查询账户关系信息
     *
     * @param servAcctId
     * @return AccountRel
     */
    AccountRel query(Long servAcctId);


}
