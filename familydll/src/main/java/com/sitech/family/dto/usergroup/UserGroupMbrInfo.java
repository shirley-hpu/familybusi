package com.sitech.family.dto.usergroup;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public class UserGroupMbrInfo implements Serializable {

    private BigDecimal memberId;
    private BigDecimal relMemberId;
    private BigDecimal groupId;
    private Long mbrRole;
    private String mbrType;
    private String elementId;
    private String memberDesc;
    private String memberName;
    private String objectType;
    private String objectId;
    private Date effDate;
    private Date expDate;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String outAccept;
    private String opNote;
    private String systemNote;
    private String phoneNo;
    private String state;
    private Date stateDate;

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getRelMemberId() {
        return relMemberId;
    }

    public void setRelMemberId(BigDecimal relMemberId) {
        this.relMemberId = relMemberId;
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public Long getMbrRole() {
        return mbrRole;
    }

    public void setMbrRole(Long mbrRole) {
        this.mbrRole = mbrRole;
    }

    public String getMemberDesc() {
        return memberDesc;
    }

    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getMbrType() {
        return mbrType;
    }

    public void setMbrType(String mbrType) {
        this.mbrType = mbrType;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    @Override
    public String toString() {
        return "UserGroupMbrInfo{" +
                "memberId=" + memberId +
                ", relMemberId=" + relMemberId +
                ", groupId=" + groupId +
                ", mbrRole=" + mbrRole +
                ", mbrType='" + mbrType + '\'' +
                ", elementId='" + elementId + '\'' +
                ", memberDesc='" + memberDesc + '\'' +
                ", memberName='" + memberName + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", outAccept='" + outAccept + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                '}';
    }
}
