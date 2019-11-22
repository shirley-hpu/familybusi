package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2019/4/16.
 * 家庭成员订单支付信息。
 */

@ApiModel(value = "FamilyMbrPayItemInfo",description = "家庭成员订单支付信息")
public class FamilyMbrPayItemInfoInDto {

    @ApiModelProperty(name = "PAY_TYPE", value = "支付单类型")
    @JSONField(name = "PAY_TYPE")
    @NotBlank(message = "180001$支付单类型不能为空")
    public String  payType;

    @ApiModelProperty(name = "PAY_WAY", value = "支付方式")
    @JSONField(name = "PAY_WAY")
    @NotBlank(message = "180002$支付方式不能为空")
    public String  payWay;

    @ApiModelProperty(name = "SERVICE_CHARGE", value = "手续费金额")
    @JSONField(name = "SERVICE_CHARGE")
    @NotBlank(message = "180003$手续费金额不能为空")
    public String  serviceCharge;

    @ApiModelProperty(name = "FAVOURABLE_CHARGE", value = "优惠金额")
    @JSONField(name = "FAVOURABLE_CHARGE")
    @NotBlank(message = "180004$优惠金额不能为空")
    public String  favourableCharge;

    @ApiModelProperty(name = "SHOULD_PAY_CHARGE", value = "应收金额")
    @JSONField(name = "SHOULD_PAY_CHARGE")
    @NotBlank(message = "180005$应收金额不能为空")
    public String  shouldPayCharge;

    @ApiModelProperty(name = "ACTUAL_PAY_CHARGE", value = "实收金额")
    @JSONField(name = "ACTUAL_PAY_CHARGE")
    @NotBlank(message = "180006$实收金额不能为空")
    public String  actualPayCharge;

    @ApiModelProperty(name = "CURRENCY_TYPE", value = "实收金额币种")
    @JSONField(name = "CURRENCY_TYPE")
    @NotBlank(message = "180007$实收金额币种不能为空")
    public String  currencyType;


    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getFavourableCharge() {
        return favourableCharge;
    }

    public void setFavourableCharge(String favourableCharge) {
        this.favourableCharge = favourableCharge;
    }

    public String getShouldPayCharge() {
        return shouldPayCharge;
    }

    public void setShouldPayCharge(String shouldPayCharge) {
        this.shouldPayCharge = shouldPayCharge;
    }

    public String getActualPayCharge() {
        return actualPayCharge;
    }

    public void setActualPayCharge(String actualPayCharge) {
        this.actualPayCharge = actualPayCharge;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "FamilyMbrPayItemInfoInDto{" +
                "payType='" + payType + '\'' +
                ", payWay='" + payWay + '\'' +
                ", serviceCharge='" + serviceCharge + '\'' +
                ", favourableCharge='" + favourableCharge + '\'' +
                ", shouldPayCharge='" + shouldPayCharge + '\'' +
                ", actualPayCharge='" + actualPayCharge + '\'' +
                ", currencyType='" + currencyType + '\'' +
                '}';
    }
}
