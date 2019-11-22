package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public class UserGroupMbr implements Serializable {

    private BigDecimal memberId;
    private BigDecimal groupId;
    private Long mbrRole;
    private String mbrType;
    private String elementId;
    private String objectType;
    private String objectId;
    private String phoneNo;
    private String shortNum;
    private String lockFlag;
    private String state;
    private Date stateDate;
    private String memberDesc;
    private String memberName;
    private Date effDate;
    private Date expDate;
    private String finishFlag;
    private String opCode;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;
    private static final long serialVersionUID = 1L;

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
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

    public String getShortNum() {
        return shortNum;
    }

    public void setShortNum(String shortNum) {
        this.shortNum = shortNum;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
        return "UserGroupMbr{" +
                "memberId=" + memberId +
                ", groupId=" + groupId +
                ", mbrRole=" + mbrRole +
                ", mbrType='" + mbrType + '\'' +
                ", elementId='" + elementId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", shortNum='" + shortNum + '\'' +
                ", lockFlag='" + lockFlag + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                ", memberDesc='" + memberDesc + '\'' +
                ", memberName='" + memberName + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", finishFlag='" + finishFlag + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}
