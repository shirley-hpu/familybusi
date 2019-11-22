package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.FeePrice;
import com.sitech.family.dto.ReturnDto;

import java.util.Date;


public interface IFeePrice {

    /**
     * 创建服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    ReturnDto create(FeePrice feePrice);

    /**
     * 修改服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    ReturnDto modify(FeePrice feePrice);

    /**
     * 删除服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    ReturnDto drop(FeePrice feePrice);

    /**
     * 查询服务请求费用计算配置
     * @param groupId,svcId,actionId,busiMode,feeCode,feeType,effDate
     * @return ReturnDto
     */
    FeePrice query(String groupId, String svcId, String actionId, String busiMode, String feeCode, String feeType, Date effDate);

}
