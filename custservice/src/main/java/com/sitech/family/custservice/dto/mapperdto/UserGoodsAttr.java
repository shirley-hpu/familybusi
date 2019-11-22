package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description 商品定价属性
 * @date 2018/12/6 16:09
 */
public class UserGoodsAttr implements Serializable {

    private BigDecimal goodsinsId;

    private String attrId;

    private String attrNo;

    private String grpNo;

    private String attrValue;

    private String prcId;

    private Long idNo;

    private Date effDate;

    private Date expDate;

    private String loginNo;

    private Long loginAccept;

    private Date opTime;

    private String opCode;

    private String finishFlag;

    private String servOrderId;

    private Date updateTime;

    private String updateType;

    private String updateCode;

    private String updateLogin;

    private Long updateAccept;

    private Integer updateDate;

    public BigDecimal getGoodsinsId() {
        return goodsinsId;
    }

    public void setGoodsinsId(BigDecimal goodsinsId) {
        this.goodsinsId = goodsinsId;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrNo() {
        return attrNo;
    }

    public void setAttrNo(String attrNo) {
        this.attrNo = attrNo;
    }

    public String getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public String getServOrderId() {
        return servOrderId;
    }

    public void setServOrderId(String servOrderId) {
        this.servOrderId = servOrderId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    public Long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(Long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserGoodsAttr{" +
                "goodsinsId=" + goodsinsId +
                ", attrId='" + attrId + '\'' +
                ", attrNo='" + attrNo + '\'' +
                ", grpNo='" + grpNo + '\'' +
                ", attrValue='" + attrValue + '\'' +
                ", prcId='" + prcId + '\'' +
                ", idNo=" + idNo +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", servOrderId='" + servOrderId + '\'' +
                ", updateTime=" + updateTime +
                ", updateType='" + updateType + '\'' +
                ", updateCode='" + updateCode + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateDate=" + updateDate +
                '}';
    }
}
