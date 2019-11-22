package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IFeePrice;

import com.sitech.family.custservice.dto.mapperdto.FeePrice;
import com.sitech.family.custservice.mapper.FeePriceMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: familybusi
 * @description: 服务请求费用计算配置信息实体实现
 * @author: yang xing
 * @create: 2018-12-19 17:14
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class FeePriceImpl implements IFeePrice {

    @Autowired
    private FeePriceMapper feePriceMapper;

    /**
     * 创建服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(FeePrice feePrice) {
        ReturnDto returnDto = new ReturnDto();

        try {
            feePriceMapper.create(feePrice);
        } catch (Exception e) {
            throw new BusiException("创建服务请求费用计算配置失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 修改服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(FeePrice feePrice) {
        ReturnDto returnDto = new ReturnDto();

        try {
            feePriceMapper.modify(feePrice);
        } catch (Exception e) {
            throw new BusiException("修改服务请求费用计算配置失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除服务请求费用计算配置
     * @param feePrice
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(FeePrice feePrice) {
        ReturnDto returnDto = new ReturnDto();

        try {
            feePriceMapper.drop(feePrice);
        } catch (Exception e) {
            throw new BusiException("删除服务请求费用计算配置失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询服务请求费用计算配置
     * @param groupId,svcId,actionId,busiMode,feeCode,feeType,effDate
     * @return ReturnDto
     */
    @Override
    public FeePrice query(String groupId, String svcId, String actionId, String busiMode, String feeCode, String feeType, Date effDate) {
        FeePrice feePrice = new FeePrice();

        try {
            feePrice = feePriceMapper.query(groupId, svcId, actionId, busiMode, feeCode, feeType, effDate);
        } catch (Exception e) {
            throw new BusiException("查询服务请求费用计算配置失败:" + e.getMessage());
        }

        return feePrice;
    }
}
