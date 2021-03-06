package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.sql.rowset.serial.SerialArray;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * Created by xuwei on 2019/4/16.
 */

@ApiModel(value = "FamilyMbrGoodsInfo",description = "群成员商品信息")
public class FamilyMbrGoodsInfoInDto implements Serializable {
    @ApiModelProperty(name = "MEMBER_FLAG", value = "成员商品标志")
    @JSONField(name = "MEMBER_FLAG")
    @NotBlank(message = "180016$成员商品标识不能为空")
    public String  memberFlag;

    @ApiModelProperty(name = "GOODS_TYPE", value = "是否主体商品订购实例")
    @JSONField(name = "GOODS_TYPE")
    @NotBlank(message = "190002$主体商品订购实例标识不能为空")
    public String  goodsType;

    @ApiModelProperty(name = "SVC_ID", value = "服务标识")
    @JSONField(name = "SVC_ID")
    @NotBlank(message = "190003$服务标识不能为空")
    public String  svcId;

    @ApiModelProperty(name = "PROD_ID", value = "产品标识")
    @JSONField(name = "PROD_ID")
    @NotBlank(message = "190004$产品标识不能为空")
    public String  prodId;

    @ApiModelProperty(name = "GOODS_ID", value = "商品标识")
    @JSONField(name = "GOODS_ID")
    @NotBlank(message = "190005$商品标识不能为空")
    public String  goodsId;

    @ApiModelProperty(name = "PRC_ID", value = "定价标识")
    @JSONField(name = "PRC_ID")
    @NotBlank(message = "190006$定价标识不能为空")
    public String  prcId;

    @ApiModelProperty(name = "EFF_DATE", value = "套餐生效时间")
    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "190007$套餐生效时间不能为空")
    public String  effDate;

    @ApiModelProperty(name = "EXP_DATE", value = "套餐失效时间")
    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "190008$套餐失效时间不能空")
    public String  expDate;

    @ApiModelProperty(name = "USERGROUPMBRGOODSATTRINFOLIST", value = "商品属性")
    @JSONField(name = "USERGROUPMBRGOODSATTRINFOLIST")
    public List<FamilyBaseAttrInfo> userGroupMbrGoodsAttrInfoList;

    @ApiModelProperty(name = "USERGROUPMBRSVCATTRINFOLIST", value = "服务属性")
    @JSONField(name = "USERGROUPMBRSVCATTRINFOLIST")
    public List<FamilyBaseAttrInfo> userGroupMbrSvcAttrInfoList;

    public String getMemberFlag() {
        return memberFlag;
    }

    public void setMemberFlag(String memberFlag) {
        this.memberFlag = memberFlag;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public List<FamilyBaseAttrInfo> getUserGroupMbrGoodsAttrInfoList() {
        return userGroupMbrGoodsAttrInfoList;
    }

    public void setUserGroupMbrGoodsAttrInfoList(List<FamilyBaseAttrInfo> userGroupMbrGoodsAttrInfoList) {
        this.userGroupMbrGoodsAttrInfoList = userGroupMbrGoodsAttrInfoList;
    }

    public List<FamilyBaseAttrInfo> getUserGroupMbrSvcAttrInfoList() {
        return userGroupMbrSvcAttrInfoList;
    }

    public void setUserGroupMbrSvcAttrInfoList(List<FamilyBaseAttrInfo> userGroupMbrSvcAttrInfoList) {
        this.userGroupMbrSvcAttrInfoList = userGroupMbrSvcAttrInfoList;
    }

    @Override
    public String toString() {
        return "FamilyMbrGoodsInfoInDto{" +
                "memberFlag='" + memberFlag + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", svcId='" + svcId + '\'' +
                ", prodId='" + prodId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", userGroupMbrGoodsAttrInfoList=" + userGroupMbrGoodsAttrInfoList +
                ", userGroupMbrSvcAttrInfoList=" + userGroupMbrSvcAttrInfoList +
                '}';
    }
}
