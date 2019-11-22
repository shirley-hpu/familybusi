package com.sitech.family.dao.account;

import com.sitech.family.dto.account.ConUserRelInfo;

import java.util.List;
import java.util.Map;


public interface IConUserRelInfoQryDao {

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
