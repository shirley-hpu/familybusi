package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息
 *
 * @author
 * @date 2018/9/27 17:18
 **/
public class FamilyGoodsOutDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "GOODS_ID")
    private String goodsId;
    @JSONField(name = "GOODS_NAME")
    private String goodsName;
    @JSONField(name = "GOODS_DESC")
    private String goodsDesc;
    @JSONField(name = "GOODS_TYPE")
    private String goodsType;
    @JSONField(name = "MEMBER_FLAG")
    private String memberFlag;
    @JSONField(name = "MASTER_SERV_ID")
    private String masterServId;
    @JSONField(name = "SEL_FLAG")
    private String selFlag;
    @JSONField(name = "SVC_ID")
    private String svcId;
    @JSONField(name = "PROD_ID")
    private String prodId;

    //商品定价
    @JSONField(name = "PRCLIST")
    private List<FamilyGoodsPrc> familyGoodsPrcList;

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

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getSelFlag() {
        return selFlag;
    }

    public void setSelFlag(String selFlag) {
        this.selFlag = selFlag;
    }

    public String getMemberFlag() {
        return memberFlag;
    }

    public void setMemberFlag(String memberFlag) {
        this.memberFlag = memberFlag;
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

    public List<FamilyGoodsPrc> getFamilyGoodsPrcList() {
        return familyGoodsPrcList;
    }

    public void setFamilyGoodsPrcList(List<FamilyGoodsPrc> familyGoodsPrcList) {
        this.familyGoodsPrcList = familyGoodsPrcList;
    }

    @Override
    public String toString() {
        return "FamilyGoodsOutDto{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", memberFlag='" + memberFlag + '\'' +
                ", masterServId='" + masterServId + '\'' +
                ", selFlag='" + selFlag + '\'' +
                ", svcId='" + svcId + '\'' +
                ", prodId='" + prodId + '\'' +
                ", familyGoodsPrcList=" + familyGoodsPrcList +
                '}';
    }
}
