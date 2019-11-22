package com.sitech.preservice.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 预受理
 */
public class FmPreOrderMid implements Serializable {

    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "服务号码不能为空")
    private String phoneNo;

    @JSONField(name = "GOODS_NAME")
    private String goodsName;

    @JSONField(name = "GOODS_DESC")
    private String goodsDesc;

    @JSONField(name = "FREE_SUM")
    private String freeSum;

    @JSONField(name = "USE_ADDRESS")
    private String userAddress;

    @JSONField(name = "INSTALL_TIME")
    private Date installTime;

    @JSONField(name = "OP_TIME")
    private Date opTime;

    private static final long serialVersionUID = 1L;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(String freeSum) {
        this.freeSum = freeSum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    @Override
    public String toString() {
        return "FmPreOrderMid{" +
                "phoneNo='" + phoneNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", freeSum='" + freeSum + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", installTime=" + installTime +
                ", opTime=" + opTime +
                '}';
    }
}