package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.ConUserRel;

/**
 * 帐务付费明细
 *
 * @author shirley
 * @date created in 2018/12/10
 */
public interface IConUserRelInfo {

    /**
     * 查询帐务付费明细信息
     *
     * @param servAcctId
     * @return ConUserRel
     */
    ConUserRel query(Long servAcctId);

}
