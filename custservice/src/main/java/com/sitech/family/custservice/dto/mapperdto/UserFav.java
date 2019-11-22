package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户优惠信息实例
 */
public class UserFav implements Serializable {

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

    private Date updateTime;

    private Long updateAccept;

    private String updateType;

    private Integer updateDate;

    private String updateLogin;

    private String updateCode;

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
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}