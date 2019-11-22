package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.account.AccountRelInfo;

import java.util.List;
import java.util.Map;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IFamilyAccountRelInfo {

    /**
     * 查询
     *
     * @param servAcctId
     * @return list
     */
    AccountRelInfo query(Long servAcctId);

    /**
     * @param map
     * @return list
     */
    List<AccountRelInfo> qryAccountRelInfoList(Map map);

}
