package com.sitech.preservice.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐套餐
 */
public class PreGoods implements Serializable {

    private static final long serialVersionUID = 1L;
    @JSONField(name = "PRC_ID")
    private String prcId;
    @JSONField(name = "PRC_NAME")
    private String prcName;
    @JSONField(name = "PRC_DESC")
    private String prcDesc;
    @JSONField(name = "GOODS_ID")
    private String goodsId;
    @JSONField(name = "GOODS_NAME")
    private String goodsName;
    @JSONField(name = "FREE_SUM")
    private String freeSum;
    @JSONField(name = "EFF_DATE")
    private Date effDate;
    @JSONField(name = "EXP_DATE")
    private Date expDate;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getPrcName() {
        return prcName;
    }

    public void setPrcName(String prcName) {
        this.prcName = prcName;
    }

    public String getPrcDesc() {
        return prcDesc;
    }

    public void setPrcDesc(String prcDesc) {
        this.prcDesc = prcDesc;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(String freeSum) {
        this.freeSum = freeSum;
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

    @Override
    public String toString() {
        return "PreGoods{" +
                "prcId='" + prcId + '\'' +
                ", prcName='" + prcName + '\'' +
                ", prcDesc='" + prcDesc + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", freeSum='" + freeSum + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                '}';
    }
}
