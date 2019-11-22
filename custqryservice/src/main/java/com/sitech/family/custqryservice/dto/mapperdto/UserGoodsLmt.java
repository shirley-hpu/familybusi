package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/19
 */
public class UserGoodsLmt implements Serializable {

    private BigDecimal limitinsId;
    private Long idNo;
    private String goodsId;
    private String prcId;
    private String functionCode;
    private String limitType;
    private Integer ruleId;
    private String limitLevelId;
    private Date effDate;
    private Date expDate;
    private String limitFlag;
    private Integer maxValue;
    private Integer mixValue;
    private String brandId;
    private String opCode;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private String limitDetailmsg;
    private String remark;private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;
    private static final long serialVersionUID = 1L;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getLimitLevelId() {
        return limitLevelId;
    }

    public void setLimitLevelId(String limitLevelId) {
        this.limitLevelId = limitLevelId;
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

    public String getLimitFlag() {
        return limitFlag;
    }

    public void setLimitFlag(String limitFlag) {
        this.limitFlag = limitFlag;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMixValue() {
        return mixValue;
    }

    public void setMixValue(Integer mixValue) {
        this.mixValue = mixValue;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
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

    public String getLimitDetailmsg() {
        return limitDetailmsg;
    }

    public void setLimitDetailmsg(String limitDetailmsg) {
        this.limitDetailmsg = limitDetailmsg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "UserGoodsLmt{" +
                "limitinsId=" + limitinsId +
                ", idNo=" + idNo +
                ", goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", functionCode='" + functionCode + '\'' +
                ", limitType='" + limitType + '\'' +
                ", ruleId=" + ruleId +
                ", limitLevelId='" + limitLevelId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", limitFlag='" + limitFlag + '\'' +
                ", maxValue=" + maxValue +
                ", mixValue=" + mixValue +
                ", brandId='" + brandId + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opTime=" + opTime +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", limitDetailmsg='" + limitDetailmsg + '\'' +
                ", remark='" + remark + '\'' +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}
