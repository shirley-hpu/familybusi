package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/3 17:50
 */
public class ConUserRate implements Serializable {

    private Long servAcctId;

    private Long contractNo;

    private Long idNo;

    private Integer chkoutPri;

    private Integer billOrder;

    private Double feeRate;

    private String feeCode;

    private String detalCode;

    private String opCode;

    private Date opTime;

    private String loginNo;

    private Long loginAccept;

    private String remark;

    private Date effDate;

    private Date expDate;

    private Double feeValue;

    private Date updateTime;

    private String updateType;

    private String updateCode;

    private String updateLogin;

    private Long updateAccept;

    private Integer updateDate;

    public long getServAcctId() {
        return servAcctId;
    }

    public void setServAcctId(long servAcctId) {
        this.servAcctId = servAcctId;
    }

    public long getContractNo() {
        return contractNo;
    }

    public void setContractNo(long contractNo) {
        this.contractNo = contractNo;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public int getChkoutPri() {
        return chkoutPri;
    }

    public void setChkoutPri(int chkoutPri) {
        this.chkoutPri = chkoutPri;
    }

    public int getBillOrder() {
        return billOrder;
    }

    public void setBillOrder(int billOrder) {
        this.billOrder = billOrder;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getDetalCode() {
        return detalCode;
    }

    public void setDetalCode(String detalCode) {
        this.detalCode = detalCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
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
        this.loginNo = loginNo;
    }

    public long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Double getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Double feeValue) {
        this.feeValue = feeValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    public long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public int getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(int updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ConUserRate{" +
                "servAcctId=" + servAcctId +
                ", contractNo=" + contractNo +
                ", idNo=" + idNo +
                ", chkoutPri=" + chkoutPri +
                ", billOrder=" + billOrder +
                ", feeRate=" + feeRate +
                ", feeCode='" + feeCode + '\'' +
                ", detalCode='" + detalCode + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", remark='" + remark + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", feeValue=" + feeValue +
                ", updateTime=" + updateTime +
                ", updateType='" + updateType + '\'' +
                ", updateCode='" + updateCode + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateDate=" + updateDate +
                '}';
    }
}
