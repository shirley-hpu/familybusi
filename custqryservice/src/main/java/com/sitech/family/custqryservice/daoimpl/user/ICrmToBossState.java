package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.CrmToBossState;

public interface ICrmToBossState {

    /**
     * 查询用户CRM和BOSS状态同步
     * @param idNo
     * @return CrmToBossState
     */
    CrmToBossState query(Long idNo);

}
