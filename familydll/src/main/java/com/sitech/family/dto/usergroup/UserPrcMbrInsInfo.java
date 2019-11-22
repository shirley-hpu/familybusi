package com.sitech.family.dto.usergroup;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public class UserPrcMbrInsInfo implements Serializable {

    private BigDecimal memberId;
    private Long idNo;
    private Date expDate;
    private BigDecimal prodPrcInsId;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String outAccept;
    private String opNote;
    private String systemNote;
    private String state;
    private Date stateDate;
    private static final long serialVersionUID = 1L;

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getProdPrcInsId() {
        return prodPrcInsId;
    }

    public void setProdPrcInsId(BigDecimal prodPrcInsId) {
        this.prodPrcInsId = prodPrcInsId;
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
        return "UserPrcMbrInsInfo{" +
                "memberId=" + memberId +
                ", idNo=" + idNo +
                ", expDate=" + expDate +
                ", prodPrcInsId=" + prodPrcInsId +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", outAccept='" + outAccept + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                '}';
    }
}
