package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 用户扩展属性信息
 * @date 2018/12/20 10:38
 */
public class UserAdd implements Serializable {

    private Long idNo;

    private String fieldCode;

    private String busiType;

    private Integer fieldOrder;

    private String fieldValue;

    private String otherValue;

    private String finishFlag;

    private Date opTime;

    private String loginNo;

    private Long loginAccept;

    private String opCode;

    private String opNote;

    private String systemNote;

    private String bak1;

    private String bak2;

    private String updateCode;

    private Long updateAccept;

    private String updateType;

    private String updateLogin;

    private Integer updateDate;

    private Date updateTime;

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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
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

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
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

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
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

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    @Override
    public String toString() {
        return "UserAdd{" +
                "idNo=" + idNo +
                ", fieldCode='" + fieldCode + '\'' +
                ", busiType='" + busiType + '\'' +
                ", fieldOrder=" + fieldOrder +
                ", fieldValue='" + fieldValue + '\'' +
                ", otherValue='" + otherValue + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", opCode='" + opCode + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", bak1='" + bak1 + '\'' +
                ", bak2='" + bak2 + '\'' +
                ", updateCode='" + updateCode + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateDate=" + updateDate +
                ", updateTime=" + updateTime +
                '}';
    }
}
