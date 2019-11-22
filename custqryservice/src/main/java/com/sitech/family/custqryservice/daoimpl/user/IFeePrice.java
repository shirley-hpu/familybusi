package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.FeePrice;

import java.util.Date;

public interface IFeePrice {

    /**
     * 查询服务请求费用计算配置
     * @param groupId,svcId,actionId,busiMode,feeCode,feeType,effDate
     * @return FeePrice
     */
    FeePrice query(String groupId, String svcId, String actionId, String busiMode, String feeCode, String feeType, Date effDate);

}
