package com.sitech.family.dto.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description 家庭用户实体
 * @date 2018/12/14 16:22
 */
public class UserInfo implements Serializable {

    private Long idNo;
    private String phoneNo;
    private Long contractNo;
    private Long custId;
    private String userPasswd;
    private String runCode;
    private Date runTime;
    private String oldRun;
    private String finishFlag;
    private Date finishTime;
    private String groupId;
    private Date openTime;
    private String createLogin;
    private String createGroup;
    private String empId;
    private String empGroup;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private String oupAccept;
    private Long loginAccept;
    private String opNote;
    private String systemNote;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Long getContractNo() {
        return contractNo;
    }

    public void setContractNo(Long contractNo) {
        this.contractNo = contractNo;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
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

    public String getOldRun() {
        return oldRun;
    }

    public void setOldRun(String oldRun) {
        this.oldRun = oldRun;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getCreateLogin() {
        return createLogin;
    }

    public void setCreateLogin(String createLogin) {
        this.createLogin = createLogin;
    }

    public String getCreateGroup() {
        return createGroup;
    }

    public void setCreateGroup(String createGroup) {
        this.createGroup = createGroup;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpGroup() {
        return empGroup;
    }

    public void setEmpGroup(String empGroup) {
        this.empGroup = empGroup;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "idNo=" + idNo +
                ", phoneNo='" + phoneNo + '\'' +
                ", contractNo=" + contractNo +
                ", custId=" + custId +
                ", userPasswd='" + userPasswd + '\'' +
                ", runCode='" + runCode + '\'' +
                ", runTime=" + runTime +
                ", oldRun='" + oldRun + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", finishTime=" + finishTime +
                ", groupId='" + groupId + '\'' +
                ", openTime=" + openTime +
                ", createLogin='" + createLogin + '\'' +
                ", createGroup='" + createGroup + '\'' +
                ", empId='" + empId + '\'' +
                ", empGroup='" + empGroup + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", oupAccept='" + oupAccept + '\'' +
                ", loginAccept=" + loginAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
