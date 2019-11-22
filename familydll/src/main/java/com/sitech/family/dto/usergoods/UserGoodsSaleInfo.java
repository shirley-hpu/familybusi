package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 家庭商品销售轨迹信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public class UserGoodsSaleInfo implements Serializable {

    private Long loginAccept;
    private BigDecimal goodsInsId;
    private Long idNo;
    private String goodsId;
    private String prcId;
    private String skuId;
    private String resourceNo;
    private Long sellSerialNo;
    private String backFlag;
    private Long backAccept;
    private Double shouldPay;
    private Double realPay;
    private Double favFee;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private String oupAccept;
    private String opNote;
    private String systemNote;

    //以下字段 模型中待研讨  //实物类资源销售记录模型使用方式待研讨 UR_RESSELLTERM_INFO
    private Date effDate;
    private Date expDate;
    private String finishFlag;
    private String opType;
    private BigDecimal oldProdprcinsId;
    private Long oldSellSerialNo;
    private String oldGoodsId;
    private String oldPrcId;
    private String oldSkuId;
    private String oldResourceNo;
    private String developLogin;
    private String buyName;
    private String buyIccid;
    private String contactId;
    private String subOrderId;
    private Long subOrderAccept;
    private String ordlineId;
    private String backAcceptId;
    private String chantypeId;
    private String opSource;
    private String outOrderId;
    private String resourceType;
    private String resourceCode;
    private String resourceModel;
    private String receiveName;
    private String receivePhone;
    private String sellType;
    private Long resCostPrice;
    private Long resSellPrice;
    private Long resActPrice;
    private Integer sellNum;
    private String outterLoginNo;
    private Date outterTime;
    private String orgGroup;
    private String usePhone;
    private String sellSolutionId;
    private String sellMeanId;
    private static final long serialVersionUID = 1L;

    public String getSellSolutionId() {
        return sellSolutionId;
    }

    public void setSellSolutionId(String sellSolutionId) {
        this.sellSolutionId = sellSolutionId;
    }

    public String getSellMeanId() {
        return sellMeanId;
    }

    public void setSellMeanId(String sellMeanId) {
        this.sellMeanId = sellMeanId;
    }

    public String getUsePhone() {
        return usePhone;
    }

    public void setUsePhone(String usePhone) {
        this.usePhone = usePhone;
    }

    public String getOrgGroup() {
        return orgGroup;
    }

    public void setOrgGroup(String orgGroup) {
        this.orgGroup = orgGroup;
    }

    public Date getOutterTime() {
        return outterTime;
    }

    public void setOutterTime(Date outterTime) {
        this.outterTime = outterTime;
    }

    public String getOutterLoginNo() {
        return outterLoginNo;
    }

    public void setOutterLoginNo(String outterLoginNo) {
        this.outterLoginNo = outterLoginNo;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Long getResActPrice() {
        return resActPrice;
    }

    public void setResActPrice(Long resActPrice) {
        this.resActPrice = resActPrice;
    }

    public Long getResSellPrice() {
        return resSellPrice;
    }

    public void setResSellPrice(Long resSellPrice) {
        this.resSellPrice = resSellPrice;
    }

    public Long getResCostPrice() {
        return resCostPrice;
    }

    public void setResCostPrice(Long resCostPrice) {
        this.resCostPrice = resCostPrice;
    }

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getResourceModel() {
        return resourceModel;
    }

    public void setResourceModel(String resourceModel) {
        this.resourceModel = resourceModel;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getBuyIccid() {
        return buyIccid;
    }

    public void setBuyIccid(String buyIccid) {
        this.buyIccid = buyIccid;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public Long getSubOrderAccept() {
        return subOrderAccept;
    }

    public void setSubOrderAccept(Long subOrderAccept) {
        this.subOrderAccept = subOrderAccept;
    }

    public String getOrdlineId() {
        return ordlineId;
    }

    public void setOrdlineId(String ordlineId) {
        this.ordlineId = ordlineId;
    }

    public String getBackAcceptId() {
        return backAcceptId;
    }

    public void setBackAcceptId(String backAcceptId) {
        this.backAcceptId = backAcceptId;
    }

    public String getChantypeId() {
        return chantypeId;
    }

    public void setChantypeId(String chantypeId) {
        this.chantypeId = chantypeId;
    }

    public String getOpSource() {
        return opSource;
    }

    public void setOpSource(String opSource) {
        this.opSource = opSource;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public String getDevelopLogin() {
        return developLogin;
    }

    public void setDevelopLogin(String developLogin) {
        this.developLogin = developLogin;
    }

    public String getOldGoodsId() {
        return oldGoodsId;
    }

    public void setOldGoodsId(String oldGoodsId) {
        this.oldGoodsId = oldGoodsId;
    }

    public String getOldPrcId() {
        return oldPrcId;
    }

    public void setOldPrcId(String oldPrcId) {
        this.oldPrcId = oldPrcId;
    }

    public String getOldSkuId() {
        return oldSkuId;
    }

    public void setOldSkuId(String oldSkuId) {
        this.oldSkuId = oldSkuId;
    }

    public String getOldResourceNo() {
        return oldResourceNo;
    }

    public void setOldResourceNo(String oldResourceNo) {
        this.oldResourceNo = oldResourceNo;
    }

    public Long getOldSellSerialNo() {
        return oldSellSerialNo;
    }

    public void setOldSellSerialNo(Long oldSellSerialNo) {
        this.oldSellSerialNo = oldSellSerialNo;
    }

    public BigDecimal getOldProdprcinsId() {
        return oldProdprcinsId;
    }

    public void setOldProdprcinsId(BigDecimal oldProdprcinsId) {
        this.oldProdprcinsId = oldProdprcinsId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public BigDecimal getGoodsInsId() {
        return goodsInsId;
    }

    public void setGoodsInsId(BigDecimal goodsInsId) {
        this.goodsInsId = goodsInsId;
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

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getResourceNo() {
        return resourceNo;
    }

    public void setResourceNo(String resourceNo) {
        this.resourceNo = resourceNo;
    }

    public Long getSellSerialNo() {
        return sellSerialNo;
    }

    public void setSellSerialNo(Long sellSerialNo) {
        this.sellSerialNo = sellSerialNo;
    }

    public String getBackFlag() {
        return backFlag;
    }

    public void setBackFlag(String backFlag) {
        this.backFlag = backFlag;
    }

    public Long getBackAccept() {
        return backAccept;
    }

    public void setBackAccept(Long backAccept) {
        this.backAccept = backAccept;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public Double getRealPay() {
        return realPay;
    }

    public void setRealPay(Double realPay) {
        this.realPay = realPay;
    }

    public Double getFavFee() {
        return favFee;
    }

    public void setFavFee(Double favFee) {
        this.favFee = favFee;
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
        return "UserGoodsSaleInfo{" +
                "loginAccept=" + loginAccept +
                ", goodsInsId=" + goodsInsId +
                ", idNo=" + idNo +
                ", goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", resourceNo='" + resourceNo + '\'' +
                ", sellSerialNo=" + sellSerialNo +
                ", backFlag='" + backFlag + '\'' +
                ", backAccept=" + backAccept +
                ", shouldPay=" + shouldPay +
                ", realPay=" + realPay +
                ", favFee=" + favFee +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", oupAccept=" + oupAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", finishFlag='" + finishFlag + '\'' +
                ", opType='" + opType + '\'' +
                ", oldProdprcinsId=" + oldProdprcinsId +
                ", oldSellSerialNo=" + oldSellSerialNo +
                ", oldGoodsId='" + oldGoodsId + '\'' +
                ", oldPrcId='" + oldPrcId + '\'' +
                ", oldSkuId='" + oldSkuId + '\'' +
                ", oldResourceNo='" + oldResourceNo + '\'' +
                ", developLogin='" + developLogin + '\'' +
                ", buyName='" + buyName + '\'' +
                ", buyIccid='" + buyIccid + '\'' +
                ", contactId='" + contactId + '\'' +
                ", subOrderId='" + subOrderId + '\'' +
                ", subOrderAccept=" + subOrderAccept +
                ", ordlineId='" + ordlineId + '\'' +
                ", backAcceptId='" + backAcceptId + '\'' +
                ", chantypeId='" + chantypeId + '\'' +
                ", opSource='" + opSource + '\'' +
                ", outOrderId='" + outOrderId + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", resourceModel='" + resourceModel + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", sellType='" + sellType + '\'' +
                ", resCostPrice=" + resCostPrice +
                ", resSellPrice=" + resSellPrice +
                ", resActPrice=" + resActPrice +
                ", sellNum=" + sellNum +
                ", outterLoginNo='" + outterLoginNo + '\'' +
                ", outterTime=" + outterTime +
                ", orgGroup='" + orgGroup + '\'' +
                ", usePhone='" + usePhone + '\'' +
                ", sellSolutionId='" + sellSolutionId + '\'' +
                ", sellMeanId='" + sellMeanId + '\'' +
                '}';
    }
}
