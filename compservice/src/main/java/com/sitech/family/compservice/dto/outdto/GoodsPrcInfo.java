package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/1/18 11:28
 */
public class GoodsPrcInfo implements Serializable {

    @JSONField(name = "PRC_ID")
    private String prcId;

    @JSONField(name = "GOODS_ID")
    private String goodsId;

    @JSONField(name = "GOODS_NAME")
    private String goodsName;

    @JSONField(name = "GOODS_TYPE")
    private String goodsType;

    @JSONField(name = "PRC_NAME")
    private String prcName;

    @JSONField(name = "PRC_DESC")
    private String prcDesc;

    @JSONField(name = "SVC_ID")
    private String svcId;

    @JSONField(name = "PROD_ID")
    private String prodId;

    @JSONField(name = "EFF_DATE")
    private String effDate;

    @JSONField(name = "EXP_DATE")
    private String expDate;

    @JSONField(name = "MASTER_SERV_ID")
    private String masterServId;

    @JSONField(name = "FREE_SUM")
    private String freeSum;

    @JSONField(name = "USE_RANGE")
    private String useRange;

    @JSONField(name = "GROUP_TYPE")
    private String groupType;

    @JSONField(name = "PICTURE_URL")
    private String pictureUrl;

    @JSONField(name = "PRC_TYPE")
    private String prcType;

    @JSONField(name = "SEL_FLAG")
    private String selFlag;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(String freeSum) {
        this.freeSum = freeSum;
    }

    public String getUseRange() {
        return useRange;
    }

    public void setUseRange(String useRange) {
        this.useRange = useRange;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPrcType() {
        return prcType;
    }

    public void setPrcType(String prcType) {
        this.prcType = prcType;
    }

    public String getSelFlag() {
        return selFlag;
    }

    public void setSelFlag(String selFlag) {
        this.selFlag = selFlag;
    }

    @Override
    public String toString() {
        return "GoodsPrcInfo{" +
                "prcId='" + prcId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", prcName='" + prcName + '\'' +
                ", prcDesc='" + prcDesc + '\'' +
                ", svcId='" + svcId + '\'' +
                ", prodId='" + prodId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", masterServId='" + masterServId + '\'' +
                ", freeSum='" + freeSum + '\'' +
                ", useRange='" + useRange + '\'' +
                ", groupType='" + groupType + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", prcType='" + prcType + '\'' +
                ", selFlag='" + selFlag + '\'' +
                '}';
    }
}
