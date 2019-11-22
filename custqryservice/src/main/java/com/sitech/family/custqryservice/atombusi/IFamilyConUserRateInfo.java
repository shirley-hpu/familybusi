package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.account.ConUserRateInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭付费明细
 * @date 2018/12/17 10:26
 */
public interface IFamilyConUserRateInfo {

    /**
     * 查询家庭付费明细
     * @return conUserRateInfo
     */
    ConUserRateInfo query(Long servAcctId, String feeCode, Date effDate, String detailCode);


    /**
     * @param map
     * @return list
     */
    List<ConUserRateInfo> qryConUserRateInfoList(Map map);
}
