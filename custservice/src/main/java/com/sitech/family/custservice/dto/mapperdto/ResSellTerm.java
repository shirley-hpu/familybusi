package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: familybusi
 * @description: 终端资源销售记录信息
 * @author: yang xing
 * @create: 2018-12-20 16:40
 */
public class ResSellTerm implements Serializable {

    private Date opTime;
    private String resourceNo;
    private Long sellSerialNo;
    private Long loginAccept;
    private Long idNo;
    private String resourceType;
    private String resourceCode;
    private String skuId;
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
    private String backFlag;
    private Long backAccept;
    private String orgGroup;
    private String usePhone;
    private String sellSolutionId;
    private String sellMeanId;
    private String loginNo;
    private String opCode;
    private String opNote;
    private String bak1;
    private String bak2;
    private String bak3;
    private BigDecimal goodsinsId;
    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
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

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getResourceModel() {
        return resourceModel;
    }

    public void setResourceModel(String resourceModel) {
        this.resourceModel = resourceModel;
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

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public Long getResCostPrice() {
        return resCostPrice;
    }

    public void setResCostPrice(Long resCostPrice) {
        this.resCostPrice = resCostPrice;
    }

    public Long getResSellPrice() {
        return resSellPrice;
    }

    public void setResSellPrice(Long resSellPrice) {
        this.resSellPrice = resSellPrice;
    }

    public Long getResActPrice() {
        return resActPrice;
    }

    public void setResActPrice(Long resActPrice) {
        this.resActPrice = resActPrice;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public String getOutterLoginNo() {
        return outterLoginNo;
    }

    public void setOutterLoginNo(String outterLoginNo) {
        this.outterLoginNo = outterLoginNo;
    }

    public Date getOutterTime() {
        return outterTime;
    }

    public void setOutterTime(Date outterTime) {
        this.outterTime = outterTime;
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

    public String getOrgGroup() {
        return orgGroup;
    }

    public void setOrgGroup(String orgGroup) {
        this.orgGroup = orgGroup;
    }

    public String getUsePhone() {
        return usePhone;
    }

    public void setUsePhone(String usePhone) {
        this.usePhone = usePhone;
    }

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

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
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

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public BigDecimal getGoodsinsId() {
        return goodsinsId;
    }

    public void setGoodsinsId(BigDecimal goodsinsId) {
        this.goodsinsId = goodsinsId;
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
        return "ResSellTerm{" +
                "opTime=" + opTime +
                ", resourceNo='" + resourceNo + '\'' +
                ", sellSerialNo=" + sellSerialNo +
                ", loginAccept=" + loginAccept +
                ", idNo=" + idNo +
                ", resourceType='" + resourceType + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", skuId='" + skuId + '\'' +
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
                ", backFlag='" + backFlag + '\'' +
                ", backAccept=" + backAccept +
                ", orgGroup='" + orgGroup + '\'' +
                ", usePhone='" + usePhone + '\'' +
                ", sellSolutionId='" + sellSolutionId + '\'' +
                ", sellMeanId='" + sellMeanId + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opNote='" + opNote + '\'' +
                ", bak1='" + bak1 + '\'' +
                ", bak2='" + bak2 + '\'' +
                ", bak3='" + bak3 + '\'' +
                ", goodsinsId=" + goodsinsId +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}
