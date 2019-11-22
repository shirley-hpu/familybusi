package com.sitech.family.familyservice.dto.commondto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/3/11 11:04
 */
public class OprInfo implements Serializable {

    /**
     * 操作流水
     */
    @JSONField(name = "LOGIN_ACCEPT")
    @JsonProperty("LOGIN_ACCEPT")
    @NotBlank(message = "入参LOGIN_ACCEPT不能为空")
    private String loginAccept;

    /**
     * 创建时间
     */
    @JSONField(name = "CREATE_TIME")
    @JsonProperty("CREATE_TIME")
    @NotBlank(message = "入参CREATE_TIME不能为空")
    private String createTime;

    /**
     * 营业厅代码
     */
    @JSONField(name = "GROUP_ID")
    @JsonProperty("GROUP_ID")
    @NotBlank(message = "入参GROUP_ID不能为空")
    private String groupId;

    /**
     * 操作工号
     */
    @JSONField(name = "LOGIN_NO")
    @JsonProperty("LOGIN_NO")
    @NotBlank(message = "入参LOGIN_NO不能为空")
    private String loginNo;

    /**
     * 操作备注
     */
    @JSONField(name = "OP_NOTE")
    @JsonProperty("OP_NOTE")
    @NotBlank(message = "入参OP_NOTE不能为空")
    private String opNote;

    /**
     * 操作代码
     */
    @JSONField(name = "OP_CODE")
    @JsonProperty("OP_CODE")
    @NotBlank(message = "入参OP_CODE不能为空")
    private String opCode;

    /**
     * 地市
     */
    @JSONField(name = "REGION_ID")
    @JsonProperty("REGION_ID")
    @NotBlank(message = "入参REGION_ID不能为空")
    private String regionId;

    /**
     * 接触ID
     */
    @JSONField(name = "CONTACT_ID")
    @JsonProperty("CONTACT_ID")
    @NotBlank(message = "入参CONTACT_ID不能为空")
    private String contactId;

    /**
     * 系统备注
     */
    @JSONField(name = "SYSTEM_NOTE")
    @JsonProperty("SYSTEM_NOTE")
    @NotBlank(message = "入参SYSTEM_NOTE不能为空")
    private String systemNote;

    /**
     * 外部流水
     */
    @JSONField(name = "OUT_ACCEPT")
    @JsonProperty("OUT_ACCEPT")
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
                "loginAccept=" + loginAccept +
                ", createTime=" + createTime +
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
