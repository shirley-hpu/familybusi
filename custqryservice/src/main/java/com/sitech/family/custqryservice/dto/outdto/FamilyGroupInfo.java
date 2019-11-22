package com.sitech.family.custqryservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 主号家庭信息
 * @description
 * @date 2019/1/18 11:28
 */
public class FamilyGroupInfo implements Serializable {

    @JSONField(name = "ID_NO")
    private String idNo;

    @JSONField(name = "PHONE_NO")
    private String phoneNo;
    // 帐户标识
    @JSONField(name = "CONTRACT_NO")
    private String contractNo;
    // 客户标识
    @JSONField(name = "CUST_ID")
    private String custId;
    // 用户状态
    @JSONField(name = "RUN_CODE")
    private String runCode;
    // 创建时间
    @JSONField(name = "OPEN_TIME")
    private Date openTime;
    // 群id
    @JSONField(name = "GROUP_ID")
    private BigDecimal groupId;
    // 群code
    @JSONField(name = "GROUP_CODE")
    private String groupCode;
    // 群类型
    @JSONField(name = "GROUP_TYPE")
    private String groupType;
    // 群名称
    @JSONField(name = "GROUP_NAME")
    private String groupName;
    // 群描述
    @JSONField(name = "GROUP_DESC")
    private String groupDesc;
    // 商品名称
    @JSONField(name = "GOODS_NAME")
    private String goodsName;
    // 商品类型
    @JSONField(name = "GOODS_TYPE")
    private String goodsType;
    // 商品描述
    @JSONField(name = "GOODS_DESC")
    private String goodsDesc;
    // 商品编码
    @JSONField(name = "GOODS_ID")
    private String goodsId;
    // 资费编码
    @JSONField(name = "GOODS_PRC_ID")
    private String goodsPrcId;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
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

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrcId() {
        return goodsPrcId;
    }

    public void setGoodsPrcId(String goodsPrcId) {
        this.goodsPrcId = goodsPrcId;
    }

    @Override
    public String toString() {
        return "FamilyGroupInfo{" +
                "idNo='" + idNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", custId='" + custId + '\'' +
                ", runCode='" + runCode + '\'' +
                ", openTime=" + openTime +
                ", groupId=" + groupId +
                ", groupCode='" + groupCode + '\'' +
                ", groupType='" + groupType + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsPrcId='" + goodsPrcId + '\'' +
                '}';
    }
}
