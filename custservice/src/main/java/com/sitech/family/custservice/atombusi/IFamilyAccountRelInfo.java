package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
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
     * 新增
     *
     * @param accountRelInfo
     * @return
     */
    ReturnDto create(AccountRelInfo accountRelInfo);

    /**
     * 修改
     *
     * @param accountRelInfo
     * @return
     */
    ReturnDto modify(AccountRelInfo accountRelInfo);

    /**
     * 删除
     *
     * @param accountRelInfo
     * @return
     */
    ReturnDto drop(AccountRelInfo accountRelInfo);

    /**
     * 查询
     *
     * @param servAcctId
     * @return
     */
    AccountRelInfo query(Long servAcctId);

    /**
     * @param map
     * @return list
     */
    List<AccountRelInfo> qryAccountRelInfoList(Map map);

}
