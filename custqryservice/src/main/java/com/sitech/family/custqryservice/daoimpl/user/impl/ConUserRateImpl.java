package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IConUserRate;
import com.sitech.family.custqryservice.dto.mapperdto.ConUserRate;
import com.sitech.family.custqryservice.mapper.IConUserRateMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/10 09:52
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ConUserRateImpl implements IConUserRate {

    @Autowired
    private IConUserRateMapper mapper;

    /**
     * 查询账户关系信息
     * @param servAcctId,effDate,feeCode,detalCode
     * @return conUserRate
     */
    @Override
    public ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode) {
        ConUserRate conUserRate = new ConUserRate();

        try {
            conUserRate = mapper.query(servAcctId, effDate, feeCode, detalCode);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询账户关系信息失败" + e.getMessage());
        }

        return conUserRate;
    }

}
