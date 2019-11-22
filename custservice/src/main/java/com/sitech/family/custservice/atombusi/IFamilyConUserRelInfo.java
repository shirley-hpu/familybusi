package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.account.ConUserRelInfo;

import java.util.List;
import java.util.Map;

/**
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public interface IFamilyConUserRelInfo {

    /**
     * 新增
     *
     * @param conUserRelInfoDto
     * @return
     */
    ReturnDto create(ConUserRelInfo conUserRelInfoDto);

    /**
     * 修改
     *
     * @param conUserRelInfoDto
     * @return
     */
    ReturnDto modify(ConUserRelInfo conUserRelInfoDto);

    /**
     * 删除
     *
     * @param conUserRelInfoDto
     * @return
     */
    ReturnDto drop(ConUserRelInfo conUserRelInfoDto);

    /**
     * 查询
     *
     * @param servAcctId
     * @return
     */
    ConUserRelInfo query(Long servAcctId);

    /**
     * @param map
     * @return list
     */
    List<ConUserRelInfo> qryConUserRelInfoList(Map map);

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
