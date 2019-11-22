package com.sitech.family.dao.account;

import com.sitech.family.dto.account.ConUserRateInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:17
 */
public interface IConUserRateInfoQryDao {

    /**
     * 查询家庭付费明细
     */
    ConUserRateInfo query(Long servAcctId, String feeCode, Date effDate, String detailCode);

    /**
     * @param map
     * @return list
     */
    List<ConUserRateInfo> qryConUserRateInfoList(Map map);
}
