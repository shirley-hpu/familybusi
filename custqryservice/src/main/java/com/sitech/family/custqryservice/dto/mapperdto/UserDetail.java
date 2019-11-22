package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
public class UserDetail implements Serializable {

    private Long idNo;
    private String runCode;
    private Date runTime;
    private String userGradeCode;
    private String stopFlag;
    private String owedFlag;
    private String userPasswd;
    private String passwdType;
    private Long cardType;
    private String vipCardNo;
    private Integer vipCreateType;
    private String oldRun;
    private String queryCdrflag;
    private String lmtAdjustType;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private String opCode;
    private String opNote;
    private String systemNote;
    private String bak1;
    private String bak2;
    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;
    private static final long serialVersionUID = 1L;

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

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public String getUserGradeCode() {
        return userGradeCode;
    }

    public void setUserGradeCode(String userGradeCode) {
        this.userGradeCode = userGradeCode;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getOwedFlag() {
        return owedFlag;
    }

    public void setOwedFlag(String owedFlag) {
        this.owedFlag = owedFlag;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getPasswdType() {
        return passwdType;
    }

    public void setPasswdType(String passwdType) {
        this.passwdType = passwdType;
    }

    public Long getCardType() {
        return cardType;
    }

    public void setCardType(Long cardType) {
        this.cardType = cardType;
    }

    public String getVipCardNo() {
        return vipCardNo;
    }

    public void setVipCardNo(String vipCardNo) {
        this.vipCardNo = vipCardNo;
    }

    public Integer getVipCreateType() {
        return vipCreateType;
    }

    public void setVipCreateType(Integer vipCreateType) {
        this.vipCreateType = vipCreateType;
    }

    public String getOldRun() {
        return oldRun;
    }

    public void setOldRun(String oldRun) {
        this.oldRun = oldRun;
    }

    public String getQueryCdrflag() {
        return queryCdrflag;
    }

    public void setQueryCdrflag(String queryCdrflag) {
        this.queryCdrflag = queryCdrflag;
    }

    public String getLmtAdjustType() {
        return lmtAdjustType;
    }

    public void setLmtAdjustType(String lmtAdjustType) {
        this.lmtAdjustType = lmtAdjustType;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "idNo=" + idNo +
                ", runCode='" + runCode + '\'' +
                ", runTime=" + runTime +
                ", userGradeCode='" + userGradeCode + '\'' +
                ", stopFlag='" + stopFlag + '\'' +
                ", owedFlag='" + owedFlag + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", passwdType='" + passwdType + '\'' +
                ", cardType=" + cardType +
                ", vipCardNo='" + vipCardNo + '\'' +
                ", vipCreateType=" + vipCreateType +
                ", oldRun='" + oldRun + '\'' +
                ", queryCdrflag='" + queryCdrflag + '\'' +
                ", lmtAdjustType='" + lmtAdjustType + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", opCode='" + opCode + '\'' +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", bak1='" + bak1 + '\'' +
                ", bak2='" + bak2 + '\'' +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}
