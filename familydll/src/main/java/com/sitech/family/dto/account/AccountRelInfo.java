package com.sitech.family.dto.account;

import java.io.Serializable;
import java.util.Date;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public class AccountRelInfo implements Serializable {

    private Long servAcctId;
    private Long contractNo;
    private Long relContractNo;
    private String acctRelType;
    private String acctItems;
    private Double payValue;
    private Date effDate;
    private Date expDate;
    private Integer payOrder;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private String outAccept;
    private Long loginAccept;
    private String opNote;
    private String systemNote;
    private static final long serialVersionUID = 1L;

    public Long getServAcctId() {
        return servAcctId;
    }

    public void setServAcctId(Long servAcctId) {
        this.servAcctId = servAcctId;
    }

    public Long getContractNo() {
        return contractNo;
    }

    public void setContractNo(Long contractNo) {
        this.contractNo = contractNo;
    }

    public Long getRelContractNo() {
        return relContractNo;
    }

    public void setRelContractNo(Long relContractNo) {
        this.relContractNo = relContractNo;
    }

    public String getAcctRelType() {
        return acctRelType;
    }

    public void setAcctRelType(String acctRelType) {
        this.acctRelType = acctRelType;
    }

    public String getAcctItems() {
        return acctItems;
    }

    public void setAcctItems(String acctItems) {
        this.acctItems = acctItems;
    }

    public Double getPayValue() {
        return payValue;
    }

    public void setPayValue(Double payValue) {
        this.payValue = payValue;
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

    public Integer getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(Integer payOrder) {
        this.payOrder = payOrder;
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

    public String getOutAccept() {
        return outAccept;
    }

    public void setOutAccept(String outAccept) {
        this.outAccept = outAccept;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
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
        return "AccountRelInfo{" +
                "servAcctId=" + servAcctId +
                ", contractNo=" + contractNo +
                ", relContractNo=" + relContractNo +
                ", acctRelType='" + acctRelType + '\'' +
                ", acctItems='" + acctItems + '\'' +
                ", payValue=" + payValue +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", payOrder=" + payOrder +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", outAccept='" + outAccept + '\'' +
                ", loginAccept=" + loginAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
