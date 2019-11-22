package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description 用户商品实例关系
 * @date 2018/12/28 09:44
 */
public class UserGoodsRel implements Serializable {

    private BigDecimal goodsinsId;

    private BigDecimal relgoodsinsId;

    private Long loginAccept;

    private Long idNo;

    private Date effDate;

    private Date expDate;

    private String relopType;

    private String relationType;

    private String servOrderId;

    private String loginNo;

    private Date opTime;

    private String remark;

    private Long updateAccept;

    private String updateType;

    private Integer updateDate;

    private String updateCode;

    private Date updateTime;

    private String updateLogin;

    public BigDecimal getGoodsinsId() {
        return goodsinsId;
    }

    public void setGoodsinsId(BigDecimal goodsinsId) {
        this.goodsinsId = goodsinsId;
    }

    public BigDecimal getRelgoodsinsId() {
        return relgoodsinsId;
    }

    public void setRelgoodsinsId(BigDecimal relgoodsinsId) {
        this.relgoodsinsId = relgoodsinsId;
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

    public String getServOrderId() {
        return servOrderId;
    }

    public void setServOrderId(String servOrderId) {
        this.servOrderId = servOrderId;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
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

    @Override
    public String toString() {
        return "UserGoodsRel{" +
                "goodsinsId=" + goodsinsId +
                ", relgoodsinsId=" + relgoodsinsId +
                ", loginAccept=" + loginAccept +
                ", idNo=" + idNo +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", relopType='" + relopType + '\'' +
                ", relationType='" + relationType + '\'' +
                ", servOrderId='" + servOrderId + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", opTime=" + opTime +
                ", remark='" + remark + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateCode='" + updateCode + '\'' +
                ", updateTime=" + updateTime +
                ", updateLogin='" + updateLogin + '\'' +
                '}';
    }
}
