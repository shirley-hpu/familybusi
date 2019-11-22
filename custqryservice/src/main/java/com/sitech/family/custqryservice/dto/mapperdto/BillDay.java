package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 17:39
 */
public class BillDay implements Serializable {

    private Long contractNo;

    private Date effDate;

    private Long idNo;

    private String masterServId;

    private String phoneNo;

    private String billDay;

    private Date expDate;

    private String durFlag;

    private String loginNo;

    private Date opTime;

    private String opCode;

    private Long loginAccept;

    private Long updateAccept;

    private String updateType;

    private Integer updateDate;

    private String updateCode;

    private Date updateTime;

    private String updateLogin;

    public Long getContractNo() {
        return contractNo;
    }

    public void setContractNo(Long contractNo) {
        this.contractNo = contractNo;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBillDay() {
        return billDay;
    }

    public void setBillDay(String billDay) {
        this.billDay = billDay;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getDurFlag() {
        return durFlag;
    }

    public void setDurFlag(String durFlag) {
        this.durFlag = durFlag;
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

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
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

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    @Override
    public String toString() {
        return "BillDay{" +
                "contractNo=" + contractNo +
                ", effDate=" + effDate +
                ", idNo=" + idNo +
                ", masterServId='" + masterServId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", billDay='" + billDay + '\'' +
                ", expDate=" + expDate +
                ", durFlag='" + durFlag + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginAccept=" + loginAccept +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateCode='" + updateCode + '\'' +
                ", updateTime=" + updateTime +
                ", updateLogin='" + updateLogin + '\'' +
                '}';
    }
}
