package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 家庭套餐构成查询 出参
 *
 * @author shirley
 * @date 2019/1/18 10:59
 **/
public class FamilyGoodsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "PKG_GOODS_ID")
    private String goodsId;
    @JSONField(name = "PKG_GOODS_NAME")
    private String goodsName;
    @JSONField(name = "PKG_GOODS_TYPE")
    private String goodsType;
    @JSONField(name = "PKG_PRC_ID")
    private String prcId;
    @JSONField(name = "PKG_PRC_NAME")
    private String prcName;
    @JSONField(name = "PKG_PRC_DESC")
    private String prcDesc;
    @JSONField(name = "PKG_FREE_SUM")
    private String freeSum;

    @JSONField(name = "MASTER_SERV_ID")
    private String masterServId;
    @JSONField(name = "EFF_DATE")
    private String effDate;
    @JSONField(name = "EXP_DATE")
    private String expDate;

    //服务属性
    @JSONField(name = "GOODSPRCATTRINFOLIST")
    private List<FamilyGoodsAttr> goodsPrcAttrList;

    //资费属性
    @JSONField(name = "GOODSSVCATTRINFOLIST")
    private List<FamilyGoodsAttr> goodsSvcAttrList;

    //角色
    @JSONField(name = "GROUPROLELIST")
    private List<FamilyGroupRole> groupRoleList;

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

    public String getFreeSum() {
        return freeSum;
    }

    public void setFreeSum(String freeSum) {
        this.freeSum = freeSum;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
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

    public List<FamilyGoodsAttr> getGoodsPrcAttrList() {
        return goodsPrcAttrList;
    }

    public void setGoodsPrcAttrList(List<FamilyGoodsAttr> goodsPrcAttrList) {
        this.goodsPrcAttrList = goodsPrcAttrList;
    }

    public List<FamilyGoodsAttr> getGoodsSvcAttrList() {
        return goodsSvcAttrList;
    }

    public void setGoodsSvcAttrList(List<FamilyGoodsAttr> goodsSvcAttrList) {
        this.goodsSvcAttrList = goodsSvcAttrList;
    }

    public List<FamilyGroupRole> getGroupRoleList() {
        return groupRoleList;
    }

    public void setGroupRoleList(List<FamilyGroupRole> groupRoleList) {
        this.groupRoleList = groupRoleList;
    }

    @Override
    public String toString() {
        return "FamilyGoodsDetail{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", prcId='" + prcId + '\'' +
                ", prcName='" + prcName + '\'' +
                ", prcDesc='" + prcDesc + '\'' +
                ", freeSum=" + freeSum +
                ", masterServId='" + masterServId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", goodsPrcAttrList=" + goodsPrcAttrList +
                ", goodsSvcAttrList=" + goodsSvcAttrList +
                ", groupRoleList=" + groupRoleList +
                '}';
    }
}
