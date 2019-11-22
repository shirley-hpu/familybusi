package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户优惠信息实例
 */
public class UserFavInfo implements Serializable {

    private BigDecimal favinsId;

    private String attrId;

    private String svcObjType;

    private String svcObjValue;

    private String favObjType;

    private String favObjValue;

    private Integer opsourceType;

    private String opsourceValue;

    private String favType;

    private String favtempId;

    private String favId;

    private Date effDate;

    private Date expDate;

    private String loginNo;

    private Long loginAccept;

    private String servOrderId;

    private Date opTime;

    private String opCode;

    private String mbrType;

    private String mbrRole;

    private static final long serialVersionUID = 1L;

    public BigDecimal getFavinsId() {
        return favinsId;
    }

    public void setFavinsId(BigDecimal favinsId) {
        this.favinsId = favinsId;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getSvcObjType() {
        return svcObjType;
    }

    public void setSvcObjType(String svcObjType) {
        this.svcObjType = svcObjType;
    }

    public String getSvcObjValue() {
        return svcObjValue;
    }

    public void setSvcObjValue(String svcObjValue) {
        this.svcObjValue = svcObjValue;
    }

    public String getFavObjType() {
        return favObjType;
    }

    public void setFavObjType(String favObjType) {
        this.favObjType = favObjType;
    }

    public String getFavObjValue() {
        return favObjValue;
    }

    public void setFavObjValue(String favObjValue) {
        this.favObjValue = favObjValue;
    }

    public Integer getOpsourceType() {
        return opsourceType;
    }

    public void setOpsourceType(Integer opsourceType) {
        this.opsourceType = opsourceType;
    }

    public String getOpsourceValue() {
        return opsourceValue;
    }

    public void setOpsourceValue(String opsourceValue) {
        this.opsourceValue = opsourceValue;
    }

    public String getFavType() {
        return favType;
    }

    public void setFavType(String favType) {
        this.favType = favType;
    }

    public String getFavtempId() {
        return favtempId;
    }

    public void setFavtempId(String favtempId) {
        this.favtempId = favtempId;
    }

    public String getFavId() {
        return favId;
    }

    public void setFavId(String favId) {
        this.favId = favId;
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getServOrderId() {
        return servOrderId;
    }

    public void setServOrderId(String servOrderId) {
        this.servOrderId = servOrderId;
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

    public String getMbrType() {
        return mbrType;
    }

    public void setMbrType(String mbrType) {
        this.mbrType = mbrType;
    }

    public String getMbrRole() {
        return mbrRole;
    }

    public void setMbrRole(String mbrRole) {
        this.mbrRole = mbrRole;
    }

    @Override
    public String toString() {
        return "UserFavInfo{" +
                "favinsId=" + favinsId +
                ", attrId='" + attrId + '\'' +
                ", svcObjType='" + svcObjType + '\'' +
                ", svcObjValue='" + svcObjValue + '\'' +
                ", favObjType='" + favObjType + '\'' +
                ", favObjValue='" + favObjValue + '\'' +
                ", opsourceType=" + opsourceType +
                ", opsourceValue='" + opsourceValue + '\'' +
                ", favType='" + favType + '\'' +
                ", favtempId='" + favtempId + '\'' +
                ", favId='" + favId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", servOrderId='" + servOrderId + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", mbrType='" + mbrType + '\'' +
                ", mbrRole='" + mbrRole + '\'' +
                '}';
    }
}