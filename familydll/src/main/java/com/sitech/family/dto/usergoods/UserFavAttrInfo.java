package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户优惠参数实例信息
 */
public class UserFavAttrInfo implements Serializable {

    private BigDecimal favinsId;

    private String attrId;

    private Date effDate;

    private String attrValue;

    private Date expDate;

    private String loginNo;

    private Long loginAccept;

    private String servOrderId;

    private Date opTime;

    private String opCode;

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
        this.attrId = attrId == null ? null : attrId.trim();
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
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
        this.loginNo = loginNo == null ? null : loginNo.trim();
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
        this.servOrderId = servOrderId == null ? null : servOrderId.trim();
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
        this.opCode = opCode == null ? null : opCode.trim();
    }

    @Override
    public String toString() {
        return "UserFavAttrInfo{" +
                "favinsId=" + favinsId +
                ", attrId='" + attrId + '\'' +
                ", effDate=" + effDate +
                ", attrValue='" + attrValue + '\'' +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", servOrderId='" + servOrderId + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                '}';
    }
}