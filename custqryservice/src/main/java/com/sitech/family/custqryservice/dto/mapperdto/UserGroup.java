package com.sitech.family.custqryservice.dto.mapperdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description 群实例
 * @date 2018/12/21 10:30
 */
public class UserGroup implements Serializable {

    @JSONField(name = "GROUP_ID")
    private BigDecimal groupId;

    @JSONField(name = "ID_NO")
    private Long idNo;

    @JSONField(name = "GROUP_CODE")
    private String groupCode;

    @JSONField(name = "GROUP_TYPE")
    private String groupType;

    @JSONField(name = "GROUP_NAME")
    private String groupName;

    @JSONField(name = "GROUP_DESC")
    private String groupDesc;

    @JSONField(name = "STATE")
    private String state;

    @JSONField(name = "STATE_DATE")
    private Date stateDate;

    @JSONField(name = "EFF_DATE")
    private Date effDate;

    @JSONField(name = "EXP_DATE")
    private Date expDate;

    @JSONField(name = "LOGIN_NO")
    private String loginNo;

    @JSONField(name = "FINISH_FLAG")
    private String finishFlag;

    @JSONField(name = "LOCK_FLAG")
    private String lockFlag;

    @JSONField(name = "LOGIN_ACCEPT")
    private Long loginAccept;

    @JSONField(name = "OP_TIME")
    private Date opTime;

    @JSONField(name = "OP_CODE")
    private String opCode;

    private Integer updateDate;

    private Date updateTime;

    private String updateLogin;

    private String updateCode;

    private Long updateAccept;

    private String updateType;

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
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

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(long loginAccept) {
        this.loginAccept = loginAccept;
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

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupId=" + groupId +
                ", idNo=" + idNo +
                ", groupCode='" + groupCode + '\'' +
                ", groupType='" + groupType + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", lockFlag='" + lockFlag + '\'' +
                ", loginAccept=" + loginAccept +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", updateDate=" + updateDate +
                ", updateTime=" + updateTime +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                '}';
    }
}
