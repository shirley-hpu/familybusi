package com.sitech.family.custservice.dto.mapperdto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guanqp
 * @Description  验证码实体
 * @date 2019/3/28 19:42
 */
public class CustCheckCode {

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
        return "CustCheckCode{" +
                "checkCode=" + checkCode +
                ", effectiveTime=" + effectiveTime +
                ", phoneNo='" + phoneNo + '\'' +
                ", opTime=" + opTime +
                '}';
    }
}
