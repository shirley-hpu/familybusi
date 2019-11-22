package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.*;

/**
 * Created by xuwei on 2019/4/19.
 *全网订单参数拼接DTO
 */
public class UniOrderInfoDto{

    public static class  FamilyOrderBodyInfoDto{

        @ApiModelProperty(name = "OPR_INFO", value = "操作信息")
        @JSONField(name = "OPR_INFO")
        private FamilyOrderOprInfoDto familyOrderOprInfoDto;

        @ApiModelProperty(name = "PAY_INFO", value = "电子支付信息")
        @JSONField(name = "PAY_INFO")
        private FamilyOrderPayInfoDto familyOrderPayInfoDto;

        @ApiModelProperty(name = "ORDERITEM_LIST", value = "全网订单业务信息")
        @JSONField(name = "ORDERITEM_LIST")
        private List<FamilyOrderItemInfoDto> familyOrderItemInfoDtoList;

        public FamilyOrderOprInfoDto getFamilyOrderOprInfoDto() {
            return familyOrderOprInfoDto;
        }

        public void setFamilyOrderOprInfoDto(FamilyOrderOprInfoDto familyOrderOprInfoDto) {
            this.familyOrderOprInfoDto = familyOrderOprInfoDto;
        }

        public FamilyOrderPayInfoDto getFamilyOrderPayInfoDto() {
            return familyOrderPayInfoDto;
        }

        public void setFamilyOrderPayInfoDto(FamilyOrderPayInfoDto familyOrderPayInfoDto) {
            this.familyOrderPayInfoDto = familyOrderPayInfoDto;
        }

        public List<FamilyOrderItemInfoDto> getFamilyOrderItemInfoDtoList() {
            return familyOrderItemInfoDtoList;
        }

        public void setFamilyOrderItemInfoDtoList(List<FamilyOrderItemInfoDto> familyOrderItemInfoDtoList) {
            this.familyOrderItemInfoDtoList = familyOrderItemInfoDtoList;
        }

        @Override
        public String toString() {
            return "FamilyOrderBodyInfoDto{" +
                    "familyOrderOprInfoDto=" + familyOrderOprInfoDto +
                    ", familyOrderPayInfoDto=" + familyOrderPayInfoDto +
                    ", familyOrderItemInfoDtoList=" + familyOrderItemInfoDtoList +
                    '}';
        }
    }

    public static class  FamilyOrderOprInfoDto{
        @ApiModelProperty(name = "REGION_ID", value = "地市代码")
        @JSONField(name = "REGION_ID")
        public String  regionId;

        @ApiModelProperty(name = "LOGIN_NO", value = "工号")
        @JSONField(name = "LOGIN_NO")
        public String  loginNo;

        @ApiModelProperty(name = "GROUP_ID", value = "营业厅代码")
        @JSONField(name = "GROUP_ID")
        public String  groupId;

        @ApiModelProperty(name = "CONTACT_ID", value = "接触ID")
        @JSONField(name = "CONTACT_ID")
        public String  contactId;

        @ApiModelProperty(name = "REMARK", value = "操作备注")
        @JSONField(name = "REMARK")
        public String  remark;

        @ApiModelProperty(name = "CHANNEL_TYPE", value = "渠道类型")
        @JSONField(name = "CHANNEL_TYPE")
        public String  channelType;

        @ApiModelProperty(name = "CUST_ID_TYPE", value = "业务对象类型")
        @JSONField(name = "CUST_ID_TYPE")
        public String  custIdType;

        @ApiModelProperty(name = "CUST_ID_VALUE", value = "业务对象类值")
        @JSONField(name = "CUST_ID_VALUE")
        public String  custIdValue;

        @ApiModelProperty(name = "SERVICE_NO", value = "服务号码")
        @JSONField(name = "SERVICE_NO")
        public String  servcieNO;

        @ApiModelProperty(name = "OUT_ORDER_ID", value = "外部订单编号")
        @JSONField(name = "OUT_ORDER_ID")
        public String  outOrderId;

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getLoginNo() {
            return loginNo;
        }

        public void setLoginNo(String loginNo) {
            this.loginNo = loginNo;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public String getCustIdType() {
            return custIdType;
        }

        public void setCustIdType(String custIdType) {
            this.custIdType = custIdType;
        }

        public String getCustIdValue() {
            return custIdValue;
        }

        public void setCustIdValue(String custIdValue) {
            this.custIdValue = custIdValue;
        }

        public String getServcieNO() {
            return servcieNO;
        }

        public void setServcieNO(String servcieNO) {
            this.servcieNO = servcieNO;
        }

        public String getOutOrderId() {
            return outOrderId;
        }

        public void setOutOrderId(String outOrderId) {
            this.outOrderId = outOrderId;
        }

        @Override
        public String toString() {
            return "FamilyOrderOprInfoDto{" +
                    "regionId='" + regionId + '\'' +
                    ", loginNo='" + loginNo + '\'' +
                    ", groupId='" + groupId + '\'' +
                    ", contactId='" + contactId + '\'' +
                    ", remark='" + remark + '\'' +
                    ", channelType='" + channelType + '\'' +
                    ", custIdType='" + custIdType + '\'' +
                    ", custIdValue='" + custIdValue + '\'' +
                    ", servcieNO='" + servcieNO + '\'' +
                    ", outOrderId='" + outOrderId + '\'' +
                    '}';
        }
    }

    public static class  FamilyOrderPayInfoDto{
        @ApiModelProperty(name = "OPT_CODE", value = "传电子渠道对应的渠道代码")
        @JSONField(name = "OPT_CODE")
        public String  optCode;

        @ApiModelProperty(name = "PAY_CHANNEL", value = "支付渠道")
        @JSONField(name = "PAY_CHANNEL")
        public String  payChannel;

        @ApiModelProperty(name = "VIP_ID", value = "交易的商城会员id")
        @JSONField(name = "VIP_ID")
        public String  vipId;

        @ApiModelProperty(name = "FAVOURABLE_RULE_ID", value = "购物车级优惠规则编码")
        @JSONField(name = "FAVOURABLE_RULE_ID")
        public String  favourableRuleId;

        @ApiModelProperty(name = "FAVOURABLE_SHARE_MODE", value = "购物车级优惠分摊规则")
        @JSONField(name = "FAVOURABLE_SHARE_MODE")
        public String  favourableShareMode;

        public String getOptCode() {
            return optCode;
        }

        public void setOptCode(String optCode) {
            this.optCode = optCode;
        }

        public String getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(String payChannel) {
            this.payChannel = payChannel;
        }

        public String getVipId() {
            return vipId;
        }

        public void setVipId(String vipId) {
            this.vipId = vipId;
        }

        public String getFavourableRuleId() {
            return favourableRuleId;
        }

        public void setFavourableRuleId(String favourableRuleId) {
            this.favourableRuleId = favourableRuleId;
        }

        public String getFavourableShareMode() {
            return favourableShareMode;
        }

        public void setFavourableShareMode(String favourableShareMode) {
            this.favourableShareMode = favourableShareMode;
        }

        @Override
        public String toString() {
            return "FamilyOrderPayInfoDto{" +
                    "optCode='" + optCode + '\'' +
                    ", payChannel='" + payChannel + '\'' +
                    ", vipId='" + vipId + '\'' +
                    ", favourableRuleId='" + favourableRuleId + '\'' +
                    ", favourableShareMode='" + favourableShareMode + '\'' +
                    '}';
        }
    }

    public static class  FamilyOrderItemInfoDto<T> {

        @ApiModelProperty(name = "CHANNEL_TYPE", value = "传电子渠道对应的渠道代码")
        @JSONField(name = "CHANNEL_TYPE")
        @NotBlank(message = "180040$传电子渠道对应的渠道代码")
        public String  channelType;

        @ApiModelProperty(name = "BUSI_TYPE", value = "业务类型")
        @JSONField(name = "BUSI_TYPE")
        @NotBlank(message = "180041$业务类型")
        public  String  busiType;

        @ApiModelProperty(name = "CUST_ID_TYPE", value = "业务对象类型")
        @JSONField(name = "CUST_ID_TYPE")
        @NotBlank(message = "180042$业务对象类型不能为空")
        public  static String  custIdType ;

        @ApiModelProperty(name = "CUST_ID_VALUE", value = "业务对象值")
        @JSONField(name = "CUST_ID_VALUE")
        @NotBlank(message = "180043$业务对象值不能为空")
        public String  custIdValue;

        @ApiModelProperty(name = "GOODS_INFO", value = "业务信息节点")
        @JSONField(name = "GOODS_INFO")
        private T goodsInfo;

        @ApiModelProperty(name = "PAY_ITEM_INFO", value = "子订单支付信息")
        @JSONField(name = "PAY_ITEM_INFO")
        private FamilyMbrPayItemInfoDto familyMbrPayItemInfoDto;

        @ApiModelProperty(name = "DELIVER_INFO", value = "子订单物流信息")
        @JSONField(name = "DELIVER_INFO")
        private FamilyDeliverInfoDto familyDeliverInfoDto;

        public String getChannelType() {
            return channelType;
        }

        public void setChannelType(String channelType) {
            this.channelType = channelType;
        }

        public String getBusiType() {
            return busiType;
        }

        public void setBusiType(String busiType) {
            this.busiType = busiType;
        }

        public static String getCustIdType() {
            return custIdType;
        }

        public static void setCustIdType(String custIdType) {
            FamilyOrderItemInfoDto.custIdType = custIdType;
        }

        public String getCustIdValue() {
            return custIdValue;
        }

        public void setCustIdValue(String custIdValue) {
            this.custIdValue = custIdValue;
        }

        public T getGoodsInfo() {
            return goodsInfo;
        }

        public void setGoodsInfo(T goodsInfo) {
            this.goodsInfo = goodsInfo;
        }

        public FamilyMbrPayItemInfoDto getFamilyMbrPayItemInfoDto() {
            return familyMbrPayItemInfoDto;
        }

        public void setFamilyMbrPayItemInfoDto(FamilyMbrPayItemInfoDto familyMbrPayItemInfoDto) {
            this.familyMbrPayItemInfoDto = familyMbrPayItemInfoDto;
        }

        public FamilyDeliverInfoDto getFamilyDeliverInfoDto() {
            return familyDeliverInfoDto;
        }

        public void setFamilyDeliverInfoDto(FamilyDeliverInfoDto familyDeliverInfoDto) {
            this.familyDeliverInfoDto = familyDeliverInfoDto;
        }

        @Override
        public String toString() {
            return "FamilyOrderItemInfoDto{" +
                    "channelType='" + channelType + '\'' +
                    ", busiType='" + busiType + '\'' +
                    ", custIdValue='" + custIdValue + '\'' +
                    ", goodsInfo=" + goodsInfo +
                    ", familyMbrPayItemInfoDto=" + familyMbrPayItemInfoDto +
                    ", familyDeliverInfoDto=" + familyDeliverInfoDto +
                    '}';
        }
    }

    public static class  FamilyMbrPayItemInfoDto {
        @ApiModelProperty(name = "PAY_TYPE", value = "支付单类型")
        @JSONField(name = "PAY_TYPE")
        @NotBlank(message = "180030$支付单类型不能为空")
        public String  payType;

        @ApiModelProperty(name = "PAY_WAY", value = "支付方式")
        @JSONField(name = "PAY_WAY")
        @NotBlank(message = "180031$支付方式不能为空")
        public String  payWay;

        @ApiModelProperty(name = "SERVICE_CHARGE", value = "手续费金额")
        @JSONField(name = "SERVICE_CHARGE")
        @NotBlank(message = "180032$手续费金额不能为空")
        public String  serviceCharge;

        @ApiModelProperty(name = "FAVOURABLE_CHARGE", value = "优惠金额")
        @JSONField(name = "FAVOURABLE_CHARGE")
        @NotBlank(message = "180033$优惠金额不能为空")
        public String  favourableCharge;

        @ApiModelProperty(name = "SHOULD_PAY_CHARGE", value = "应收金额")
        @JSONField(name = "SHOULD_PAY_CHARGE")
        @NotBlank(message = "180034$应收金额不能为空")
        public String  shouldPayCharge;

        @ApiModelProperty(name = "ACTUAL_PAY_CHARGE", value = "实收金额")
        @JSONField(name = "ACTUAL_PAY_CHARGE")
        @NotBlank(message = "180035$实收金额不能为空")
        public String  actualPayCharge;

        @ApiModelProperty(name = "SERVICE_CHARGE_TYPE", value = "手续费币种")
        @JSONField(name = "SERVICE_CHARGE_TYPE")
        @NotBlank(message = "180036$手续费币种不能为空")
        public String  serviceChargeType;

        @ApiModelProperty(name = "FAVOURABLE_CHARGE_TYPE", value = "优惠金额币种")
        @JSONField(name = "FAVOURABLE_CHARGE_TYPE")
        @NotBlank(message = "180037$优惠金额币种不能为空")
        public String  favourableChargeType;

        @ApiModelProperty(name = "SHOULD_PAY_CHARGE_TYPE", value = "应收金额币种")
        @JSONField(name = "SHOULD_PAY_CHARGE_TYPE")
        @NotBlank(message = "180038$应收金额币种不能为空")
        public String  shouldPayChargeType;

        @ApiModelProperty(name = "ACTUAL_PAY_CHARGE_TYPE", value = "实收金额币种")
        @JSONField(name = "ACTUAL_PAY_CHARGE_TYPE")
        @NotBlank(message = "180039$实收金额币种不能为空")
        public String  actualPayChargeType;

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

        public String getServiceChargeType() {
            return serviceChargeType;
        }

        public void setServiceChargeType(String serviceChargeType) {
            this.serviceChargeType = serviceChargeType;
        }

        public String getFavourableChargeType() {
            return favourableChargeType;
        }

        public void setFavourableChargeType(String favourableChargeType) {
            this.favourableChargeType = favourableChargeType;
        }

        public String getShouldPayChargeType() {
            return shouldPayChargeType;
        }

        public void setShouldPayChargeType(String shouldPayChargeType) {
            this.shouldPayChargeType = shouldPayChargeType;
        }

        public String getActualPayChargeType() {
            return actualPayChargeType;
        }

        public void setActualPayChargeType(String actualPayChargeType) {
            this.actualPayChargeType = actualPayChargeType;
        }

        @Override
        public String toString() {
            return "FamilyMbrPayItemInfoDto{" +
                    "payType='" + payType + '\'' +
                    ", payWay='" + payWay + '\'' +
                    ", serviceCharge='" + serviceCharge + '\'' +
                    ", favourableCharge='" + favourableCharge + '\'' +
                    ", shouldPayCharge='" + shouldPayCharge + '\'' +
                    ", actualPayCharge='" + actualPayCharge + '\'' +
                    ", serviceChargeType='" + serviceChargeType + '\'' +
                    ", favourableChargeType='" + favourableChargeType + '\'' +
                    ", shouldPayChargeType='" + shouldPayChargeType + '\'' +
                    ", actualPayChargeType='" + actualPayChargeType + '\'' +
                    '}';
        }
    }


}
