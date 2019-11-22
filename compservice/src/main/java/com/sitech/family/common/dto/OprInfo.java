package com.sitech.family.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.sitech.family.compservice.dto.outdto.UserInfo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author shirley on 2018/8/28.
 * @Description BusiInDto完成公共接口OPR_INFO解析和校验
 */
public class OprInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "SESSION")
    private UserInfo session;

    @JSONField(name = "REGION_ID")
    @NotBlank(message = "入参REGION_ID不能为空")
    private String regionId;

    @JSONField(name = "LOGIN_NO")
    @NotBlank(message = "入参LOGIN_NO不能为空")
    private String loginNo;

    @JSONField(name = "CONTACT_ID")
    @NotBlank(message = "入参CONTACT_ID不能为空")
    private String contactId;

    @JSONField(name = "OP_NOTE")
    @NotBlank(message = "入参OP_NOTE不能为空")
    private String opNote;

    @JSONField(name = "CHANNEL_TYPE")
    @NotBlank(message = "入参CHANNEL_TYPE不能为空")
    private String channelType;

    @JSONField(name = "APPLY_ID")
    private String applyId;

    @JSONField(name = "OP_CODE")
    private String opCode;

    @JSONField(name = "GROUP_ID")
    @NotBlank(message = "入参GROUP_ID不能为空")
    private String groupId;

    @JSONField(name = "POWER_RIGHT")
    private String powerRight;

    @JSONField(name = "OP_TIME")
    private String opTime;

    @JSONField(name = "LOGIN_ACCPET")
    private String loginAccpet;

    @JSONField(name = "CREATE_TIME")
    private String createTime;

    @JSONField(name = "SYSTEM_NOTE")
    private String systemNote;

    @JSONField(name = "OUT_ACCEPT")
    private String outAccept;

    public UserInfo getSession() {
        return session;
    }

    public void setSession(UserInfo session) {
        this.session = session;
    }

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

    public String getPowerRight() {
        return powerRight;
    }

    public void setPowerRight(String powerRight) {
        this.powerRight = powerRight;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getLoginAccpet() {
        return loginAccpet;
    }

    public void setLoginAccpet(String loginAccpet) {
        this.loginAccpet = loginAccpet;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
        return "OprInfo{" +
                "session=" + session +
                ", regionId='" + regionId + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", contactId='" + contactId + '\'' +
                ", opNote='" + opNote + '\'' +
                ", channelType='" + channelType + '\'' +
                ", applyId='" + applyId + '\'' +
                ", opCode='" + opCode + '\'' +
                ", groupId='" + groupId + '\'' +
                ", powerRight='" + powerRight + '\'' +
                ", opTime='" + opTime + '\'' +
                ", loginAccpet='" + loginAccpet + '\'' +
                ", createTime='" + createTime + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", outAccept='" + outAccept + '\'' +
                '}';
    }
}
