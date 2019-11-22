package com.sitech.family.dto.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public class ConUserRelInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long servAcctId;
    private Long idNo;
    private Long contractNo;
    private String payType;
    private Double payValue;
    private String cycleType;
    private Integer dateCycle;
    private String rateFlag;
    private Integer billOrder;
    private Integer payOrder;
    private Date effDate;
    private Date expDate;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String outAccept;
    private String opNote;
    private String systemNote;
    private String finishFlag;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getServAcctId() {
        return servAcctId;
    }

    public void setServAcctId(Long servAcctId) {
        this.servAcctId = servAcctId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public Long getContractNo() {
        return contractNo;
    }

    public void setContractNo(Long contractNo) {
        this.contractNo = contractNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getPayValue() {
        return payValue;
    }

    public void setPayValue(Double payValue) {
        this.payValue = payValue;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public Integer getDateCycle() {
        return dateCycle;
    }

    public void setDateCycle(Integer dateCycle) {
        this.dateCycle = dateCycle;
    }

    public String getRateFlag() {
        return rateFlag;
    }

    public void setRateFlag(String rateFlag) {
        this.rateFlag = rateFlag;
    }

    public Integer getBillOrder() {
        return billOrder;
    }

    public void setBillOrder(Integer billOrder) {
        this.billOrder = billOrder;
    }

    public Integer getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(Integer payOrder) {
        this.payOrder = payOrder;
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

    public String getOutAccept() {
        return outAccept;
    }

    public void setOutAccept(String outAccept) {
        this.outAccept = outAccept;
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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    @Override
    public String toString() {
        return "ConUserRelInfo{" +
                "servAcctId=" + servAcctId +
                ", idNo=" + idNo +
                ", contractNo=" + contractNo +
                ", payType='" + payType + '\'' +
                ", payValue=" + payValue +
                ", cycleType='" + cycleType + '\'' +
                ", dateCycle=" + dateCycle +
                ", rateFlag='" + rateFlag + '\'' +
                ", billOrder=" + billOrder +
                ", payOrder=" + payOrder +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", outAccept='" + outAccept + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                '}';
    }
}
