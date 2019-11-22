package com.sitech.family.custqryservice.dto.mapperdto;

import java.util.Date;

/**
 * @program: familybusi
 * @description: 用户CRM&BOSS状态同步
 * @author: yang xing
 * @create: 2018-12-19 16:30
 */
public class CrmToBossState {

    private Long idNo;
    private String crmRunCode;
    private Date crmRunTime;
    private String bossRunCode;
    private Date bossRunTime;
    private String opCode;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private String bakField;
    private String runCode;

    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public String getCrmRunCode() {
        return crmRunCode;
    }

    public void setCrmRunCode(String crmRunCode) {
        this.crmRunCode = crmRunCode;
    }

    public Date getCrmRunTime() {
        return crmRunTime;
    }

    public void setCrmRunTime(Date crmRunTime) {
        this.crmRunTime = crmRunTime;
    }

    public String getBossRunCode() {
        return bossRunCode;
    }

    public void setBossRunCode(String bossRunCode) {
        this.bossRunCode = bossRunCode;
    }

    public Date getBossRunTime() {
        return bossRunTime;
    }

    public void setBossRunTime(Date bossRunTime) {
        this.bossRunTime = bossRunTime;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
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

    public String getBakField() {
        return bakField;
    }

    public void setBakField(String bakField) {
        this.bakField = bakField;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
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
        return "CrmToBossState{" +
                "idNo=" + idNo +
                ", crmRunCode='" + crmRunCode + '\'' +
                ", crmRunTime=" + crmRunTime +
                ", bossRunCode='" + bossRunCode + '\'' +
                ", bossRunTime=" + bossRunTime +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", bakField='" + bakField + '\'' +
                ", runCode='" + runCode + '\'' +
                '}';
    }
}
