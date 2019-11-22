package com.sitech.family.dto.user;

import java.util.Date;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/19 9:42
 */
public class CrmToBossStateInfo {
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

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
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
}
