package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 14:33
 */
public class UserState implements Serializable {

    private Long stateChangeNo;
    private Long idNo;
    private String runCode;
    private Date effDate;
    private Date expDate;
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

    public Long getStateChangeNo() {
        return stateChangeNo;
    }

    public void setStateChangeNo(Long stateChangeNo) {
        this.stateChangeNo = stateChangeNo;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
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

    @Override
    public String toString() {
        return "UserState{" +
                "stateChangeNo=" + stateChangeNo +
                ", idNo=" + idNo +
                ", runCode='" + runCode + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
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
