package com.sitech.family.dto.dict;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guanqp
 * @Description  逻辑层实体类
 * @date 2019/3/29 13:39
 */
public class CustCheckCodeInfo {

    private BigDecimal checkCode;
    private BigDecimal effectiveTime;
    private String phoneNo;
    private Date opTime;

    public BigDecimal getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(BigDecimal checkCode) {
        this.checkCode = checkCode;
    }

    public BigDecimal getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(BigDecimal effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    @Override
    public String toString() {
        return "CustCheckCodeInfo{" +
                "checkCode=" + checkCode +
                ", effectiveTime=" + effectiveTime +
                ", phoneNo='" + phoneNo + '\'' +
                ", opTime=" + opTime +
                '}';
    }
}
