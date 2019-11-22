package com.sitech.family.dao.account;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.account.ConUserRelInfo;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public interface IConUserRelInfoDao {

    /**
     * 新增
     *
     * @param conUserRelInfo
     * @return
     */
    ReturnDto create(ConUserRelInfo conUserRelInfo);

    /**
     * 修改
     *
     * @param conUserRelInfo
     * @return
     */
    ReturnDto modify(ConUserRelInfo conUserRelInfo);

    /**
     * 删除
     *
     * @param conUserRelInfo
     * @return
     */
    ReturnDto drop(ConUserRelInfo conUserRelInfo);

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
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
