package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2019/4/4.
 * 全网订单物流信息
 */

@ApiModel(value = "DeliverInfo",description = "物流配送信息")
public class FamilyDeliverInfoDto {

    @ApiModelProperty(name = "IS_DELIVER", value = "是否需要物流配送。Y:需要N:不需要")
    @JSONField(name = "SIS_DELIVER")
    @NotBlank(message = "190001$物流配送标识不能为空")
    public String  isDeliver;

    @ApiModelProperty(name = "ORDER_TYPE_CODE", value = "订单类型B2C_B2B")
    @JSONField(name="ORDER_TYPE_CODE")
    public  String  orderTypeCode;

    @ApiModelProperty(name = "ORDER_TYPE_NAME", value = "订单类型名称B2C业务")
    @JSONField(name="ORDER_TYPE_NAME")
    public  String  orderTypeName;

    @ApiModelProperty(name = "LOGISTICS_ID", value = "物流商ID\t和具体配送商有关系，暂时可以给一个默认值2")
    @JSONField(name="LOGISTICS_ID")
    public  String  logisticsId;

    @ApiModelProperty(name = "EXPRESS_TYPE", value = "配送方式")
    @JSONField(name="EXPRESS_TYPE")
    public  String  expressType;

    @ApiModelProperty(name = "PAY_STYLE", value = "物流费用付款方式")
    @JSONField(name="PAY_STYLE")
    public  String  payStyle;

    @ApiModelProperty(name = "PAY_TOTAL", value = "物流费用付款金额")
    @JSONField(name="PAY_TOTAL")
    public  String  payTotal;

    @ApiModelProperty(name = "R_COMPANY", value = "收货人公司")
    @JSONField(name="R_COMPANY")
    public  String  rCompany;

    @ApiModelProperty(name = "R_NAME", value = "收货人姓名")
    @JSONField(name="R_NAME")
    public  String  rName;

    @ApiModelProperty(name = "R_POST", value = "收货人邮政编码")
    @JSONField(name="R_POST")
    public  String  rPost;

    @ApiModelProperty(name = "R_PROVINCE", value = "收货人省份")
    @JSONField(name="R_PROVINCE")
    public  String  rProvince;

    @ApiModelProperty(name = "R_CITY", value = "收货人城市")
    @JSONField(name="R_CITY")
    public  String  rCity;

    @ApiModelProperty(name = "R_DISTRICT", value = "收货人区县")
    @JSONField(name="R_DISTRICT")
    public  String  rDistrict;

    @ApiModelProperty(name = "R_DETAIL", value = "收货人详细地址")
    @JSONField(name="R_DETAIL")
    public  String  rDetail;

    @ApiModelProperty(name = "R_TEL", value = "收货人联系电话")
    @JSONField(name="R_TEL")
    public  String  rTel;

    @ApiModelProperty(name = "R_MOBILE", value = "收货人手机号码")
    @JSONField(name="R_MOBILE")
    public  String  rMobile;

    @ApiModelProperty(name = "SERVICE_TIME", value = "配送时间段")
    @JSONField(name="SERVICE_TIME")
    public  String  serviceTime;

    @ApiModelProperty(name = "NEED_BACK", value = "是否需要回单，Y代表需要，N代表不需要,可选，取决于物流商")
    @JSONField(name="NEED_BACK")
    public  String   needBack;

    @ApiModelProperty(name = "REMARK", value = "配送备注")
    @JSONField(name="REMARK")
    public  String  remark;

    public String getIsDeliver() {
        return isDeliver;
    }

    public void setIsDeliver(String isDeliver) {
        this.isDeliver = isDeliver;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle;
    }

    public String getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(String payTotal) {
        this.payTotal = payTotal;
    }

    public String getrCompany() {
        return rCompany;
    }

    public void setrCompany(String rCompany) {
        this.rCompany = rCompany;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrPost() {
        return rPost;
    }

    public void setrPost(String rPost) {
        this.rPost = rPost;
    }

    public String getrProvince() {
        return rProvince;
    }

    public void setrProvince(String rProvince) {
        this.rProvince = rProvince;
    }

    public String getrCity() {
        return rCity;
    }

    public void setrCity(String rCity) {
        this.rCity = rCity;
    }

    public String getrDistrict() {
        return rDistrict;
    }

    public void setrDistrict(String rDistrict) {
        this.rDistrict = rDistrict;
    }

    public String getrDetail() {
        return rDetail;
    }

    public void setrDetail(String rDetail) {
        this.rDetail = rDetail;
    }

    public String getrTel() {
        return rTel;
    }

    public void setrTel(String rTel) {
        this.rTel = rTel;
    }

    public String getrMobile() {
        return rMobile;
    }

    public void setrMobile(String rMobile) {
        this.rMobile = rMobile;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getNeedBack() {
        return needBack;
    }

    public void setNeedBack(String needBack) {
        this.needBack = needBack;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FamilyDeliverInfoDto{" +
                "isDeliver='" + isDeliver + '\'' +
                ", orderTypeCode='" + orderTypeCode + '\'' +
                ", orderTypeName='" + orderTypeName + '\'' +
                ", logisticsId='" + logisticsId + '\'' +
                ", expressType='" + expressType + '\'' +
                ", payStyle='" + payStyle + '\'' +
                ", payTotal='" + payTotal + '\'' +
                ", rCompany='" + rCompany + '\'' +
                ", rName='" + rName + '\'' +
                ", rPost='" + rPost + '\'' +
                ", rProvince='" + rProvince + '\'' +
                ", rCity='" + rCity + '\'' +
                ", rDistrict='" + rDistrict + '\'' +
                ", rDetail='" + rDetail + '\'' +
                ", rTel='" + rTel + '\'' +
                ", rMobile='" + rMobile + '\'' +
                ", serviceTime='" + serviceTime + '\'' +
                ", needBack='" + needBack + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
