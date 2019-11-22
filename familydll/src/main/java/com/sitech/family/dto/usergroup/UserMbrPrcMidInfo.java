package com.sitech.family.dto.usergroup;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:26
 */
public class UserMbrPrcMidInfo implements Serializable {

    private Long idNo;
    private BigDecimal memberId;
    private String insType;
    private BigDecimal insValue;
    private BigDecimal parinsId;
    private BigDecimal otherinsId;
    private String relopType;
    private String relationType;
    private BigDecimal relinsId;
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
    private String outAccept;
    private Long loginAccept;
    private String opNote;
    private String systemNote;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
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

    public BigDecimal getParinsId() {
        return parinsId;
    }

    public void setParinsId(BigDecimal parinsId) {
        this.parinsId = parinsId;
    }

    public BigDecimal getOtherinsId() {
        return otherinsId;
    }

    public void setOtherinsId(BigDecimal otherinsId) {
        this.otherinsId = otherinsId;
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

    public BigDecimal getRelinsId() {
        return relinsId;
    }

    public void setRelinsId(BigDecimal relinsId) {
        this.relinsId = relinsId;
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

    public String getOutAccept() {
        return outAccept;
    }

    public void setOutAccept(String outAccept) {
        this.outAccept = outAccept;
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
        return "UserMbrPrcMidInfo{" +
                "idNo=" + idNo +
                "memberId=" + memberId +
                ", insType='" + insType + '\'' +
                ", insValue=" + insValue +
                ", parinsId=" + parinsId +
                ", otherinsId=" + otherinsId +
                ", relopType='" + relopType + '\'' +
                ", relationType='" + relationType + '\'' +
                ", relinsId=" + relinsId +
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
                ", outAccept='" + outAccept + '\'' +
                ", loginAccept=" + loginAccept +
                ", opNote='" + opNote + '\'' +
                ", systemNote='" + systemNote + '\'' +
                '}';
    }
}
