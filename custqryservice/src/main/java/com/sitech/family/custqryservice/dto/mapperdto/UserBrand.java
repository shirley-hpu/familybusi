package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

public class UserBrand implements Serializable {

    private Long idNo;

    private String brandId;

    private Date effDate;

    private Date expDate;

    private String finishFlag;

    private String loginNo;

    private long loginAccept;

    private String opCode;

    private Date opTime;

    private long updateAccept;

    private String updateType;

    private int updateDate;

    private String updateCode;

    private Date updateTime;

    private String updateLogin;

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
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
        this.finishFlag = finishFlag;
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

    public long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public int getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(int updateDate) {
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
        return "UserBrand{" +
                "idNo=" + idNo +
                ", brandId='" + brandId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", finishFlag='" + finishFlag + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept='" + loginAccept + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateCode='" + updateCode + '\'' +
                ", updateTime=" + updateTime +
                ", updateLogin='" + updateLogin + '\'' +
                '}';
    }
}
