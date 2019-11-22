package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.ConUserRate;

import java.util.Date;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/10 09:15
 */
public interface IConUserRate {

    /**
     * 查询账户关系信息
     *
     * @param
     * @return ConUserRate
     */
    ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode);

}
