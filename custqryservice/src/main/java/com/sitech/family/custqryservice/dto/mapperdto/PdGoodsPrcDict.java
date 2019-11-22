package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户商品订购实例信息
 *
 * @author zhangc
 * @date created in 2019/09/12
 */
public class PdGoodsPrcDict implements Serializable {

    private String prcId;
    private String goodsId;
    private String goodsPrcDesc;
    private String brandId;
    private String effRuleId;
    private String expRuleId;
    private String cancelRuleId;
    private String userRange;
    private String saleFlag;
    private BigDecimal minNum;
    private BigDecimal maxNum;
    private BigDecimal version;
    private String modifyFlag;
    private String uniCode;
    private BigDecimal effNum;
    private BigDecimal unExpNum;
    private String prcClass;
    private String chineseIndex;
    private String prcName;
    private String prcType;
    private String billingMode;
    private Date effDate;
    private Date expDate;
    private String state;
    private String createLogin;
    private Date createTime;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrcDesc() {
        return goodsPrcDesc;
    }

    public void setGoodsPrcDesc(String goodsPrcDesc) {
        this.goodsPrcDesc = goodsPrcDesc;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getEffRuleId() {
        return effRuleId;
    }

    public void setEffRuleId(String effRuleId) {
        this.effRuleId = effRuleId;
    }

    public String getExpRuleId() {
        return expRuleId;
    }

    public void setExpRuleId(String expRuleId) {
        this.expRuleId = expRuleId;
    }

    public String getCancelRuleId() {
        return cancelRuleId;
    }

    public void setCancelRuleId(String cancelRuleId) {
        this.cancelRuleId = cancelRuleId;
    }

    public String getUserRange() {
        return userRange;
    }

    public void setUserRange(String userRange) {
        this.userRange = userRange;
    }

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag;
    }

    public BigDecimal getMinNum() {
        return minNum;
    }

    public void setMinNum(BigDecimal minNum) {
        this.minNum = minNum;
    }

    public BigDecimal getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(BigDecimal maxNum) {
        this.maxNum = maxNum;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    public BigDecimal getEffNum() {
        return effNum;
    }

    public void setEffNum(BigDecimal effNum) {
        this.effNum = effNum;
    }

    public BigDecimal getUnExpNum() {
        return unExpNum;
    }

    public void setUnExpNum(BigDecimal unExpNum) {
        this.unExpNum = unExpNum;
    }

    public String getPrcClass() {
        return prcClass;
    }

    public void setPrcClass(String prcClass) {
        this.prcClass = prcClass;
    }

    public String getChineseIndex() {
        return chineseIndex;
    }

    public void setChineseIndex(String chineseIndex) {
        this.chineseIndex = chineseIndex;
    }

    public String getPrcName() {
        return prcName;
    }

    public void setPrcName(String prcName) {
        this.prcName = prcName;
    }

    public String getPrcType() {
        return prcType;
    }

    public void setPrcType(String prcType) {
        this.prcType = prcType;
    }

    public String getBillingMode() {
        return billingMode;
    }

    public void setBillingMode(String billingMode) {
        this.billingMode = billingMode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateLogin() {
        return createLogin;
    }

    public void setCreateLogin(String createLogin) {
        this.createLogin = createLogin;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PdGoodsPrcDict{" +
                "prcId='" + prcId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsPrcDesc='" + goodsPrcDesc + '\'' +
                ", brandId='" + brandId + '\'' +
                ", effRuleId='" + effRuleId + '\'' +
                ", expRuleId='" + expRuleId + '\'' +
                ", cancelRuleId='" + cancelRuleId + '\'' +
                ", userRange='" + userRange + '\'' +
                ", saleFlag='" + saleFlag + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", version=" + version +
                ", modifyFlag='" + modifyFlag + '\'' +
                ", uniCode='" + uniCode + '\'' +
                ", effNum=" + effNum +
                ", unExpNum=" + unExpNum +
                ", prcClass='" + prcClass + '\'' +
                ", chineseIndex='" + chineseIndex + '\'' +
                ", prcName='" + prcName + '\'' +
                ", prcType='" + prcType + '\'' +
                ", billingMode='" + billingMode + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", state='" + state + '\'' +
                ", createLogin='" + createLogin + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
