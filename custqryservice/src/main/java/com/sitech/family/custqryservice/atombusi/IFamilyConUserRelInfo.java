package com.sitech.family.custqryservice.atombusi;

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

}
