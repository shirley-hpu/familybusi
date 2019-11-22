package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 受限实例标识 入参
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public class UserGoodsLmtInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private BigDecimal limitinsId;
    private Long idNo;
    private String busiType;
    private String limitType;
    private String limitLevel;
    private String limitFlag;
    private String limitValue;
    private String limitDetailMsg;
    private Date effDate;
    private Date expDate;
    private String busiInfoValue;
    private Integer ruleId;
    private Integer maxValue;
    private Integer minValue;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private Long loginAccept;
    private String oupAccept;
    private String opNote;
    private String systemNote;

    public String getBusiInfoValue() {
        return busiInfoValue;
    }

    public void setBusiInfoValue(String busiInfoValue) {
        this.busiInfoValue = busiInfoValue;
    }

    public BigDecimal getLimitinsId() {
        return limitinsId;
    }

    public void setLimitinsId(BigDecimal limitinsId) {
        this.limitinsId = limitinsId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getLimitLevel() {
        return limitLevel;
    }

    public void setLimitLevel(String limitLevel) {
        this.limitLevel = limitLevel;
    }

    public String getLimitFlag() {
        return limitFlag;
    }

    public void setLimitFlag(String limitFlag) {
        this.limitFlag = limitFlag;
    }

    public String getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
    }

    public String getLimitDetailMsg() {
        return limitDetailMsg;
    }

    public void setLimitDetailMsg(String limitDetailMsg) {
        this.limitDetailMsg = limitDetailMsg;
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

    public String getBusiinfoValue() {
        return busiInfoValue;
    }

    public void setBusiinfoValue(String busiInfoValue) {
        this.busiInfoValue = busiInfoValue;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
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

    public String getOupAccept() {
        return oupAccept;
    }

    public void setOupAccept(String oupAccept) {
        this.oupAccept = oupAccept;
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
        return "UserGoodsLmtInfo{" +
                "limitinsId=" + limitinsId +
                ", idNo=" + idNo +
                ", busiType='" + busiType + '\'' +
                ", limitType='" + limitType + '\'' +
                ", limitLevel='" + limitLevel + '\'' +
                ", limitFlag='" + limitFlag + '\'' +
                ", limitValue='" + limitValue + '\'' +
                ", limitDetailMsg='" + limitDetailMsg + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", busiInfoValue='" + busiInfoValue + '\'' +
                ", ruleId=" + ruleId +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", oupAccept=" + oupAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
