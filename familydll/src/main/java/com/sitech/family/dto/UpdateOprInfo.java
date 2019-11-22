package com.sitech.family.dto;

import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/5/25 15:02
 */
public class UpdateOprInfo implements Serializable {

    private String loginAccept;

    private String createTime;

    private String groupId;

    private String loginNo;

    private String opNote;

    private String opCode;

    private String regionId;

    private String contactId;

    private String systemNote;

    private String outAccept;

    public String getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(String loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getOpNote() {
        return opNote;
    }

    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSystemNote() {
        return systemNote;
    }

    public void setSystemNote(String systemNote) {
        this.systemNote = systemNote;
    }

    public String getOutAccept() {
        return outAccept;
    }

    public void setOutAccept(String outAccept) {
        this.outAccept = outAccept;
    }

    @Override
    public String toString() {
        return "UpdateOprInfo{" +
                "loginAccept='" + loginAccept + '\'' +
                ", createTime='" + createTime + '\'' +
                ", groupId='" + groupId + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", opNote='" + opNote + '\'' +
                ", opCode='" + opCode + '\'' +
                ", regionId='" + regionId + '\'' +
                ", contactId='" + contactId + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", outAccept='" + outAccept + '\'' +
                '}';
    }
}
