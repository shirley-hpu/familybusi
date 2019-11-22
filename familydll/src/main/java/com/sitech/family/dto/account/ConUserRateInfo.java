package com.sitech.family.dto.account;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 09:34
 */
public class ConUserRateInfo implements Serializable {

    private Long servAcctId;
    private String feeCode;
    private String detailCode;
    private Integer rateBillOrder;
    private Double feeRate;
    private Double feeValue;
    private Date effDate;
    private Date expDate;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String oupAccept;
    private String opNote;
    private String systemNote;

    public Long getServAcctId() {
        return servAcctId;
    }

    public void setServAcctId(Long servAcctId) {
        this.servAcctId = servAcctId;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public Integer getRateBillOrder() {
        return rateBillOrder;
    }

    public void setRateBillOrder(Integer rateBillOrder) {
        this.rateBillOrder = rateBillOrder;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public Double getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Double feeValue) {
        this.feeValue = feeValue;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getOupAccept() {
        return oupAccept;
    }

    public void setOupAccept(String oupAccept) {
        this.oupAccept = oupAccept;
    }

    public String getOpNote() {
        return opNote;
    }

    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    public String getSystemNote() {
        return systemNote;
    }

    public void setSystemNote(String systemNote) {
        this.systemNote = systemNote;
    }

    @Override
    public String toString() {
        return "ConUserRateInfo{" +
                "servAcctId=" + servAcctId +
                ", feeCode='" + feeCode + '\'' +
                ", detailCode='" + detailCode + '\'' +
                ", rateBillOrder=" + rateBillOrder +
                ", feeRate=" + feeRate +
                ", feeValue=" + feeValue +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", oupAccept=" + oupAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
