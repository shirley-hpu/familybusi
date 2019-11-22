package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户商品订购实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
public class UserGoods implements Serializable {

    private BigDecimal goodsinsId;
    private Long idNo;
    private BigDecimal relgoodsinsId;
    private BigDecimal trangoodsinsId;
    private String prcId;
    private String parprcId;
    private String goodsId;
    private Date effDate;
    private Date expDate;
    private String state;
    private Date stateDate;
    private String developLogin;
    private String goodsMainFlag;
    private String finishFlag;
    private Date orderDate;
    private String remark;
    private String servOrderId;
    private String opCode;
    private Date opTime;
    private String loginNo;
    private Long loginAccept;
    private String dataOpsource;
    private String orderSource;
    private String cancleSource;
    private String orderLoginno;
    private Date updateTime;
    private Long updateAccept;
    private String updateType;
    private Integer updateDate;
    private String updateLogin;
    private String updateCode;
    private static final long serialVersionUID = 1L;

    public BigDecimal getGoodsinsId() {
        return goodsinsId;
    }

    public void setGoodsinsId(BigDecimal goodsinsId) {
        this.goodsinsId = goodsinsId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public BigDecimal getRelgoodsinsId() {
        return relgoodsinsId;
    }

    public void setRelgoodsinsId(BigDecimal relgoodsinsId) {
        this.relgoodsinsId = relgoodsinsId;
    }

    public BigDecimal getTrangoodsinsId() {
        return trangoodsinsId;
    }

    public void setTrangoodsinsId(BigDecimal trangoodsinsId) {
        this.trangoodsinsId = trangoodsinsId;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getParprcId() {
        return parprcId;
    }

    public void setParprcId(String parprcId) {
        this.parprcId = parprcId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public String getDevelopLogin() {
        return developLogin;
    }

    public void setDevelopLogin(String developLogin) {
        this.developLogin = developLogin;
    }

    public String getGoodsMainFlag() {
        return goodsMainFlag;
    }

    public void setGoodsMainFlag(String goodsMainFlag) {
        this.goodsMainFlag = goodsMainFlag;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public String getDataOpsource() {
        return dataOpsource;
    }

    public void setDataOpsource(String dataOpsource) {
        this.dataOpsource = dataOpsource;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getCancleSource() {
        return cancleSource;
    }

    public void setCancleSource(String cancleSource) {
        this.cancleSource = cancleSource;
    }

    public String getOrderLoginno() {
        return orderLoginno;
    }

    public void setOrderLoginno(String orderLoginno) {
        this.orderLoginno = orderLoginno;
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
        return "UserGoodsDto{" +
                "goodsinsId=" + goodsinsId +
                ", idNo=" + idNo +
                ", relgoodsinsId=" + relgoodsinsId +
                ", trangoodsinsId=" + trangoodsinsId +
                ", prcId='" + prcId + '\'' +
                ", parprcId='" + parprcId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                ", developLogin='" + developLogin + '\'' +
                ", goodsMainFlag='" + goodsMainFlag + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", orderDate=" + orderDate +
                ", remark='" + remark + '\'' +
                ", servOrderId='" + servOrderId + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", loginAccept=" + loginAccept +
                ", dataOpsource='" + dataOpsource + '\'' +
                ", orderSource='" + orderSource + '\'' +
                ", cancleSource='" + cancleSource + '\'' +
                ", orderLoginno='" + orderLoginno + '\'' +
                ", updateTime=" + updateTime +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", updateDate=" + updateDate +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateCode='" + updateCode + '\'' +
                '}';
    }
}
