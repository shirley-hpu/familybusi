package com.sitech.family.dao.account;


import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.ConUserRateInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭付费明细
 * @date 2018/12/17 10:15
 */
public interface IConUserRateInfoDao {

    /**
     * 新增家庭付费明细
     *
     * @param conUserRateInfo
     */
    ReturnDto create(ConUserRateInfo conUserRateInfo);

    /**
     * 修改家庭付费明细
     *
     * @param conUserRateInfo
     */
    ReturnDto modify(ConUserRateInfo conUserRateInfo);

    /**
     * 删除家庭付费明细
     *
     * @param conUserRateInfo
     */
    ReturnDto drop(ConUserRateInfo conUserRateInfo);

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
