package com.sitech.family.dto.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 家庭用户附加信息实体
 * @date 2018/12/14 17:37
 */
public class UserAddInfo implements Serializable {

    private Long idNo;
    private String fieldCode;
    private String busiType;
    private Integer fieldOrder;
    private String fieldValue;
    private String otherValue;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String oupAccept;
    private String opNote;
    private String systemNote;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
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

    public String getOupAccept() {
        return oupAccept;
    }

    public void setOupAccept(String oupAccept) {
        this.oupAccept = oupAccept;
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

    @Override
    public String toString() {
        return "UserAddInfo{" +
                "idNo=" + idNo +
                ", fieldCode='" + fieldCode + '\'' +
                ", busiType='" + busiType + '\'' +
                ", fieldOrder=" + fieldOrder +
                ", fieldValue='" + fieldValue + '\'' +
                ", otherValue='" + otherValue + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", oupAccept='" + oupAccept + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
