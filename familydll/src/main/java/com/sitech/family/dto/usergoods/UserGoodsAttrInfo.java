package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 14:17
 */
public class UserGoodsAttrInfo implements Serializable {

    private Long idNo;
    private String insType;
    private String insValue;
    private String attrId;
    private Date effDate;
    private String attrNo;
    private String attrValue;
    private String grpNo;
    private Date expDate;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private String oupAccept;
    private Long loginAccept;
    private String opNote;
    private String systemNote;
    private String state;
    private Date stateDate;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public String getInsValue() {
        return insValue;
    }

    public void setInsValue(String insValue) {
        this.insValue = insValue;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public String getAttrNo() {
        return attrNo;
    }

    public void setAttrNo(String attrNo) {
        this.attrNo = attrNo;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
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

    public String getOupAccept() {
        return oupAccept;
    }

    public void setOupAccept(String oupAccept) {
        this.oupAccept = oupAccept;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
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
        return "UserGoodsAttrInfo{" +
                "idNo=" + idNo +
                ", insType='" + insType + '\'' +
                ", insValue='" + insValue + '\'' +
                ", attrId='" + attrId + '\'' +
                ", effDate=" + effDate +
                ", attrNo='" + attrNo + '\'' +
                ", attrValue='" + attrValue + '\'' +
                ", grpNo='" + grpNo + '\'' +
                ", expDate=" + expDate +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", oupAccept='" + oupAccept + '\'' +
                ", loginAccept=" + loginAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                '}';
    }
}
