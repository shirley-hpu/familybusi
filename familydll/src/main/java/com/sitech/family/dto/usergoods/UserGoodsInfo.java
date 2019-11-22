 package com.sitech.family.dto.usergoods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 10:45
 */
public class UserGoodsInfo implements Serializable {

    private Long idNo;
    private String insType;
    private BigDecimal insValue;
    private BigInteger parInsId;
    private BigInteger otherInsId;
    private String relopType;
    private String relationType;
    private Long relInsId;
    private String mainFlag;
    private String goodsId;
    private String prcId;
    private String svcId;
    private String prodId;
    private Date effDate;
    private Date expDate;
    private Date orderDate;
    private Date opTime;
    private String opCode;
    private String loginNo;
    private String oupAccept;
    private Long loginAccept;
    private String opNote;
    private String systemNote;
    private String state;
    private Date stateDate;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public BigDecimal getInsValue() {
        return insValue;
    }

    public void setInsValue(BigDecimal insValue) {
        this.insValue = insValue;
    }

    public BigInteger getParInsId() {
        return parInsId;
    }

    public void setParInsId(BigInteger parInsId) {
        this.parInsId = parInsId;
    }

    public BigInteger getOtherInsId() {
        return otherInsId;
    }

    public void setOtherInsId(BigInteger otherInsId) {
        this.otherInsId = otherInsId;
    }

    public String getRelopType() {
        return relopType;
    }

    public void setRelopType(String relopType) {
        this.relopType = relopType;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Long getRelInsId() {
        return relInsId;
    }

    public void setRelInsId(Long relInsId) {
        this.relInsId = relInsId;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
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

    public String getSvcId() {
        return svcId;
    }

    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    @Override
    public String toString() {
        return "UserGoodsInfo{" +
                "idNo=" + idNo +
                ", insType='" + insType + '\'' +
                ", insValue=" + insValue +
                ", parInsId=" + parInsId +
                ", otherInsId=" + otherInsId +
                ", relopType='" + relopType + '\'' +
                ", relationType='" + relationType + '\'' +
                ", relInsId=" + relInsId +
                ", mainFlag='" + mainFlag + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", svcId='" + svcId + '\'' +
                ", prodId='" + prodId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", orderDate=" + orderDate +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", oupAccept='" + oupAccept + '\'' +
                ", loginAccept=" + loginAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                '}';
    }
}
