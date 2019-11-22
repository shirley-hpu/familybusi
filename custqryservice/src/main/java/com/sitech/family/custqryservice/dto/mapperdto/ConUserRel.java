package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

public class ConUserRel implements Serializable {

    private Long servAcctId;
    private Long contractNo;
    private Long idNo;
    private String payType;
    private Double payValue;
    private Integer chkoutPri;
    private Integer billOrder;
    private Date effDate;
    private Date expDate;
    private String finishFlag;
    private String opCode;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private String remark;
    private Integer dateCycle;
    private String rateFlag;
    private String cycleType;
    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;
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

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Double getPayValue() {
        return payValue;
    }

    public void setPayValue(Double payValue) {
        this.payValue = payValue;
    }

    public Integer getChkoutPri() {
        return chkoutPri;
    }

    public void setChkoutPri(Integer chkoutPri) {
        this.chkoutPri = chkoutPri;
    }

    public Integer getBillOrder() {
        return billOrder;
    }

    public void setBillOrder(Integer billOrder) {
        this.billOrder = billOrder;
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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag == null ? null : finishFlag.trim();
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo == null ? null : loginNo.trim();
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        this.rateFlag = rateFlag == null ? null : rateFlag.trim();
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType == null ? null : cycleType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(Long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    @Override
    public String toString() {
        return "ConUserRel{" +
                "servAcctId=" + servAcctId +
                ", contractNo=" + contractNo +
                ", idNo=" + idNo +
                ", payType='" + payType + '\'' +
                ", payValue=" + payValue +
                ", chkoutPri=" + chkoutPri +
                ", billOrder=" + billOrder +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", finishFlag='" + finishFlag + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", remark='" + remark + '\'' +
                ", dateCycle=" + dateCycle +
                ", rateFlag='" + rateFlag + '\'' +
                ", cycleType='" + cycleType + '\'' +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}