package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

public interface ICrmToBossState {

    /**
     * 	新增用户CRM和BOSS状态同步
     * @param crmToBossState
     */
    ReturnDto create(CrmToBossState crmToBossState);


    /**
     * 修改用户CRM和BOSS状态同步
     * @param crmToBossState
     * @return ReturnDto
     */
    ReturnDto modify(CrmToBossState crmToBossState);

    /**
     * 删除用户CRM和BOSS状态同步
     * @param crmToBossState
     * @return ReturnDto
     */
    ReturnDto drop(CrmToBossState crmToBossState);


    /**
     * 查询用户CRM和BOSS状态同步
     * @param idNo
     * @return CrmToBossState
     */
    CrmToBossState query(Long idNo);

    /**
     * 查询用户CRM和BOSS状态同步
     * @param map
     * @return List<CrmToBossState>
     */
    List<CrmToBossState> qryCrmToBossStateList(Map map);

    /**
     * 查询用户CRM和BOSS状态同步
     * @param map
     * @return List<CrmToBossState>
     */
    List<CrmToBossState> qryCrmToBossStateHisList(Map map);
}
