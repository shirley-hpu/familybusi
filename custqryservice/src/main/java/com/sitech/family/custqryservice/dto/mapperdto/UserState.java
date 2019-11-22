package com.sitech.family.custqryservice.dto.mapperdto;

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

    public long getStateChangeNo() {
        return stateChangeNo;
    }

    public void setStateChangeNo(long stateChangeNo) {
        this.stateChangeNo = stateChangeNo;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
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

    public long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(long loginAccept) {
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

    public long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(long updateAccept) {
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

    public int getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(int updateDate) {
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
                ", updateCode='" + updateCode + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateDate=" + updateDate +
                ", updateTime=" + updateTime +
                '}';
    }
}
