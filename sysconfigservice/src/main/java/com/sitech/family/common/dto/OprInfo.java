package com.sitech.family.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/26 10:40
 */
public class OprInfo {

    @JsonProperty("REGION_ID")
    private String regionId;

    @JsonProperty("LOGIN_NO")
    private String loginNo;

    @JsonProperty("CONTACT_ID")
    private String contactId;

    @JsonProperty("OP_NOTE")
    private String opNote;

    @JsonProperty("CHANNEL_TYPE")
    private String channelType;

    @JsonProperty("APPLY_ID")
    private String applyId;

    @JsonProperty("OP_CODE")
    private String opCode;

    @JsonProperty("GROUP_ID")
    private String groupId;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getOpNote() {
        return opNote;
    }

    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
