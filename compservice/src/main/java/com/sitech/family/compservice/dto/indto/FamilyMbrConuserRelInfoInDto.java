package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2019/4/16.
 * 家庭成员统付合账信息
 */

@ApiModel(value = "FamilyMbrConuserRelInfo",description = "家庭成员统付合账信息")
public class FamilyMbrConuserRelInfoInDto {

    @ApiModelProperty(name = "CONTRACT_NO", value = "付费账户")
    @JSONField(name = "CONTRACT_NO")
    @NotBlank(message = "180008$付费账户不能为空")
    public String contractNo;

    @ApiModelProperty(name = "PAY_TYPE", value = "付费比例")
    @JSONField(name = "PAY_TYPE")
    @NotBlank(message = "180009$付费比例不能为空")
    public String payType;

    @ApiModelProperty(name = "PAY_VALUE", value = "全额或限额数值")
    @JSONField(name = "PAY_VALUE")
    @NotBlank(message = "180010$全额或限额数值不能为空")
    public String payValue;

    @ApiModelProperty(name = "CYCLE_TYPE", value = "一次性无限付费模式")
    @JSONField(name = "CYCLE_TYPE")
    @NotBlank(message = "180011$一次性无限付费模式不能为空")
    public String cycleType;

    @ApiModelProperty(name = "DATE_CYCLE", value = "默认1个月为一个判断周期，即1个月内付费不允许超过限额")
    @JSONField(name = "DATE_CYCLE")
    @NotBlank(message = "180012$限额周期不能为空")
    public String dateCycle;

    @ApiModelProperty(name = "RATE_FLAG", value = "是否按明细付费,Y时会入付费明细表")
    @JSONField(name = "RATE_FLAG")
    @NotBlank(message = "180013$付费明细标志不能为空")
    public String rateFlag;

    @ApiModelProperty(name = "EFF_DATE", value = "生效时间")
    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "180014$生效时间不能为空")
    public String effDate;

    @ApiModelProperty(name = "EXP_DATE", value = "失效时间")
    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "180015$失效时间不能为空")
    public String expDate;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayValue() {
        return payValue;
    }

    public void setPayValue(String payValue) {
        this.payValue = payValue;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getDateCycle() {
        return dateCycle;
    }

    public void setDateCycle(String dateCycle) {
        this.dateCycle = dateCycle;
    }

    public String getRateFlag() {
        return rateFlag;
    }

    public void setRateFlag(String rateFlag) {
        this.rateFlag = rateFlag;
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

    @Override
    public String toString() {
        return "FamilyMbrConuserRelInfoInDto{" +
                "contractNo='" + contractNo + '\'' +
                ", payType='" + payType + '\'' +
                ", payValue='" + payValue + '\'' +
                ", cycleType='" + cycleType + '\'' +
                ", dateCycle='" + dateCycle + '\'' +
                ", rateFlag='" + rateFlag + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
