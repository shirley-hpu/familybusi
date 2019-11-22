package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * 帐务付费明细
 *
 * @author shirley
 * @date created in 2018/12/10
 */
public interface IConUserRelInfo {

    /**
     * 创建帐务付费明细信息
     *
     * @param conUserRel
     * @return ReturnDto
     */
    ReturnDto create(ConUserRel conUserRel);

    /**
     * 删除帐务付费明细信息
     *
     * @param conUserRel
     * @return ReturnDto
     */
    ReturnDto drop(ConUserRel conUserRel);

    /**
     * 更新帐务付费明细信息
     *
     * @param conUserRel
     * @return ReturnDto
     */
    ReturnDto modify(ConUserRel conUserRel);

    /**
     * 查询帐务付费明细信息
     *
     * @param servAcctId
     * @return ConUserRel
     */
    ConUserRel query(Long servAcctId);

    /**
     * 查询帐务付费明细信息
     *
     * @param map
     * @return List<ConUserRel>
     */
    List<ConUserRel> qryContractRltList(Map map);

    /**
     * 查询帐务付费明细历史信息
     *
     * @param map
     * @return List<ConUserRel>
     */
    List<ConUserRel> qryContractRltHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param conUserRel
     * @return
     */
    ReturnDto updateFinishState(ConUserRel conUserRel);
}
