package com.sitech.family.custqryservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 主号家庭信息
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:39
 */
public class MainRoleGroupInfo implements Serializable {

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

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
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

    @Override
    public String toString() {
        return "MainRoleGroupInfo{" +
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
                '}';
    }
}
