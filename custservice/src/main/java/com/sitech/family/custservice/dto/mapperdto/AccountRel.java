package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户关系实体
 */
public class AccountRel implements Serializable {

    private Long servAcctId;
    private Long loginAccept;
    private Long contractNo;
    private Long relContractNo;
    private String acctRelType;
    private String acctItems;
    private Double payValue;
    private Integer payPri;
    private Date effDate;
    private Date expDate;
    private String loginNo;
    private Date opTime;
    private String remark;

    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;

    public Long getServAcctId() {
        return servAcctId;
    }

    public void setServAcctId(Long servAcctId) {
        this.servAcctId = servAcctId;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
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

    public Integer getPayPri() {
        return payPri;
    }

    public void setPayPri(Integer payPri) {
        this.payPri = payPri;
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

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "AccountRel{" +
                "servAcctId=" + servAcctId +
                ", loginAccept=" + loginAccept +
                ", contractNo=" + contractNo +
                ", relContractNo=" + relContractNo +
                ", acctRelType='" + acctRelType + '\'' +
                ", acctItems='" + acctItems + '\'' +
                ", payValue=" + payValue +
                ", payPri=" + payPri +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", opTime=" + opTime +
                ", remark='" + remark + '\'' +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}