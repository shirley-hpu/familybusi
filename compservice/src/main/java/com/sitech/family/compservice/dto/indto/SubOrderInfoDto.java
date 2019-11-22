package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2019/4/25.
 * 小订单入参参数。
 *
 */
public class SubOrderInfoDto {

    public static class OrderLineFee<K , V0, V1>{
        @ApiModelProperty(name = "RECEIVE_FEE_TYPE", value = "费用标识")
        @JSONField(name = "RECEIVE_FEE_TYPE")
        public String  receiveFeeType;

        @ApiModelProperty(name = "FEE_TYPE", value = "费用标识")
        @JSONField(name = "FEE_TYPE")
        public String  feeType;

        @ApiModelProperty(name = "FEE_CODE", value = "费用标识")
        @JSONField(name = "FEE_CODE")
        public String  feeCode;

        @ApiModelProperty(name = "FEE_CODE_SEQ", value = "费用标识")
        @JSONField(name = "FEE_CODE_SEQ")
        public String  feecodeSeq;

        @ApiModelProperty(name = "BUSI_SHOULD", value = "费用标识")
        @JSONField(name = "BUSI_SHOULD")
        public String  busiShould;

        @ApiModelProperty(name = "POWER_FAV_RULE", value = "费用标识")
        @JSONField(name = "POWER_FAV_RULE")
        public String  powerFavRule;

        @ApiModelProperty(name = "POWER_FAV", value = "费用标识")
        @JSONField(name = "POWER_FAV")
        public String  powerFav;

        @ApiModelProperty(name = "PROD_FAV_RULE", value = "费用标识")
        @JSONField(name = "PROD_FAV_RULE")
        public String  prodFavRule;

        @ApiModelProperty(name = "PROD_FAV", value = "费用标识")
        @JSONField(name = "PROD_FAV")
        public String  prodFav;

        @ApiModelProperty(name = "IS_PRINT", value = "费用标识")
        @JSONField(name = "IS_PRINT")
        public String  isPrint;

        @ApiModelProperty(name = "PAY_MODE", value = "费用标识")
        @JSONField(name = "PAY_MODE")
        public String  payMode;

        @ApiModelProperty(name = "PAY_STATE", value = "费用标识")
        @JSONField(name = "PAY_STATE")
        public String  payState;

        @ApiModelProperty(name = "CONTRACT_NO", value = "费用标识")
        @JSONField(name = "CONTRACT_NO")
        public String  contractNO;

        @ApiModelProperty(name = "TAX_SHOULD", value = "费用标识")
        @JSONField(name = "TAX_SHOULD")
        public String  taxShould;

        @ApiModelProperty(name = "BUY_PRICE", value = "费用标识")
        @JSONField(name = "BUY_PRICE")
        public String  buyPrice;

        @ApiModelProperty(name = "MADE_PRICE", value = "费用标识")
        @JSONField(name = "MADE_PRICE")
        public String  madePrice;

        @ApiModelProperty(name = "TAX_RATE", value = "费用标识")
        @JSONField(name = "TAX_RATE")
        public String  taxRate;

        @ApiModelProperty(name = "RESOURCE_NAME", value = "费用标识")
        @JSONField(name = "RESOURCE_NAME")
        public String  resourceName;


        @ApiModelProperty(name = "RESOURCE_MODEL", value = "费用标识")
        @JSONField(name = "RESOURCE_MODEL")
        public String  resourceModel;

        @ApiModelProperty(name = "RESOURCE_UNIT", value = "费用标识")
        @JSONField(name = "RESOURCE_UNIT")
        public String  resourceUnit;

        @ApiModelProperty(name = "RESOURCE_NUM", value = "资源")
        @JSONField(name = "RESOURCE_NUM")
        public String  resourceNum;

        @ApiModelProperty(name = "BUSI_FEE_TYPE", value = "费用业务类型。给BOSS费用工单使用")
        @JSONField(name = "BUSI_FEE_TYPE")
        public String  busiFeeType;

        @ApiModelProperty(name = "BUSI_FEE_INFO", value = "给BOSS的费用工单的具体内容")
        @JSONField(name = "BUSI_FEE_INFO")
        public Map<K, V0> busiFeeInfoMap;

        @ApiModelProperty(name = "DEPOSIT_QRY_ID", value = "押金对应的查询ID，一般为接入号，如宽带号码")
        @JSONField(name = "DEPOSIT_QRY_ID")
        public String  depositQryId;

        @ApiModelProperty(name = "DEPOSIT_EXTEND1", value = "押金扩展字段,目前存放光猫、魔百盒后置标识")
        @JSONField(name = "DEPOSIT_EXTEND1")
        public String  depositExtend1;

        @ApiModelProperty(name = "INVOICE_EXT", value = "提供发票打印额外信息")
        @JSONField(name = "INVOICE_EXT")
        public Map<K, V1>  invoiceExtMap;

    }

    public static class  FreeBillInfo<T>{
        @ApiModelProperty(name = "PUB_INFO", value = "费用公共信息")
        @JSONField(name = "PUB_INFO")
        private FeePubInfo  pubInfo;

        @ApiModelProperty(name = "BUSI_INFO", value = "自定义业务信息")
        @JSONField(name = "BUSI_INFO")
        private  T busiInfo;

        @ApiModelProperty(name = "INVOICE_INFO", value = "子订单物流信息")
        @JSONField(name = "INVOICE_INFO")
        private FeeInvoiceInfo  feeInvoiceInfo;

        @ApiModelProperty(name = "BILLCTRL_INFO", value = "子订单物流信息")
        @JSONField(name = "BILLCTRL_INFO")
        private BillCtrlInfo  billCtrlInfo;

        @ApiModelProperty(name = "BILLPEOPLE_MESSAGE", value = "子订单物流信息")
        @JSONField(name = "BILLPEOPLE_MESSAGE")
        private BillpeopleMessage  billpeopleMessage;

        public FeePubInfo getPubInfo() {
            return pubInfo;
        }

        public void setPubInfo(FeePubInfo pubInfo) {
            this.pubInfo = pubInfo;
        }

        public T getBusiInfo() {
            return busiInfo;
        }

        public void setBusiInfo(T busiInfo) {
            this.busiInfo = busiInfo;
        }

        public FeeInvoiceInfo getFeeInvoiceInfo() {
            return feeInvoiceInfo;
        }

        public void setFeeInvoiceInfo(FeeInvoiceInfo feeInvoiceInfo) {
            this.feeInvoiceInfo = feeInvoiceInfo;
        }

        public BillCtrlInfo getBillCtrlInfo() {
            return billCtrlInfo;
        }

        public void setBillCtrlInfo(BillCtrlInfo billCtrlInfo) {
            this.billCtrlInfo = billCtrlInfo;
        }

        public BillpeopleMessage getBillpeopleMessage() {
            return billpeopleMessage;
        }

        public void setBillpeopleMessage(BillpeopleMessage billpeopleMessage) {
            this.billpeopleMessage = billpeopleMessage;
        }

        @Override
        public String toString() {
            return "FreeBillInfo{" +
                    "pubInfo=" + pubInfo +
                    ", busiInfo=" + busiInfo +
                    ", feeInvoiceInfo=" + feeInvoiceInfo +
                    ", billCtrlInfo=" + billCtrlInfo +
                    ", billpeopleMessage=" + billpeopleMessage +
                    '}';
        }
    }

    public static class FeePubInfo{
        @ApiModelProperty(name = "CUST_NAME", value = "费用标识")
        @JSONField(name = "CUST_NAME")
        public String  custName;

        @ApiModelProperty(name = "PHONE_NO", value = "费用标识")
        @JSONField(name = "PHONE_NO")
        public String  phoneNo;

        @ApiModelProperty(name = "FEE_FLAG", value = "费用标识")
        @JSONField(name = "FEE_FLAG")
        public String  feeFlag;

        @ApiModelProperty(name = "LOGIN_NO", value = "费用标识")
        @JSONField(name = "LOGIN_NO")
        public String  loginNo;

        @ApiModelProperty(name = "OP_TIME", value = "费用标识")
        @JSONField(name = "OP_TIME")
        public String  opTime;

        @ApiModelProperty(name = "BRAND_NAME", value = "费用标识")
        @JSONField(name = "BRAND_NAME")
        public String  brandName;

        @ApiModelProperty(name = "MAIN_PRODUCT", value = "费用标识")
        @JSONField(name = "MAIN_PRODUCT")
        public String  mainProduct;

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getFeeFlag() {
            return feeFlag;
        }

        public void setFeeFlag(String feeFlag) {
            this.feeFlag = feeFlag;
        }

        public String getLoginNo() {
            return loginNo;
        }

        public void setLoginNo(String loginNo) {
            this.loginNo = loginNo;
        }

        public String getOpTime() {
            return opTime;
        }

        public void setOpTime(String opTime) {
            this.opTime = opTime;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getMainProduct() {
            return mainProduct;
        }

        public void setMainProduct(String mainProduct) {
            this.mainProduct = mainProduct;
        }

        @Override
        public String toString() {
            return "FeePubInfo{" +
                    "custName='" + custName + '\'' +
                    ", phoneNo='" + phoneNo + '\'' +
                    ", feeFlag='" + feeFlag + '\'' +
                    ", loginNo='" + loginNo + '\'' +
                    ", opTime='" + opTime + '\'' +
                    ", brandName='" + brandName + '\'' +
                    ", mainProduct='" + mainProduct + '\'' +
                    '}';
        }
    }

    public static class FeeInvoiceInfo{
        @ApiModelProperty(name = "FEE_FLAG", value = "费用标识")
        @JSONField(name = "FEE_FLAG")
        public String  feeFlag;

        @ApiModelProperty(name = "FEE_PAY", value = "总金额(元)")
        @JSONField(name = "FEE_PAY")
        public String  feePay;

        @ApiModelProperty(name = "SUM_SHOULD_PAY", value = "总金额(分)")
        @JSONField(name = "SUM_SHOULD_PAY")
        public String  sumShouldPay;

        @ApiModelProperty(name = "FEE_PAY_CAPITAL", value = "总金额大写")
        @JSONField(name = "FEE_PAY_CAPITAL")
        public String  feePayCapital;

        @ApiModelProperty(name = "PAY_TYPE", value = "支付方式")
        @JSONField(name = "PAY_TYPE")
        public String  payType;

        @ApiModelProperty(name = "PRINT_TIME", value = "打印时间")
        @JSONField(name = "PRINT_TIME")
        public String  printTime;

        @ApiModelProperty(name = "FEE_LIST", value = "费用项节点")
        @JSONField(name = "FEE_LIST")
        private List<FeeList> feeList;

        public String getFeeFlag() {
            return feeFlag;
        }

        public void setFeeFlag(String feeFlag) {
            this.feeFlag = feeFlag;
        }

        public String getFeePay() {
            return feePay;
        }

        public void setFeePay(String feePay) {
            this.feePay = feePay;
        }

        public String getSumShouldPay() {
            return sumShouldPay;
        }

        public void setSumShouldPay(String sumShouldPay) {
            this.sumShouldPay = sumShouldPay;
        }

        public String getFeePayCapital() {
            return feePayCapital;
        }

        public void setFeePayCapital(String feePayCapital) {
            this.feePayCapital = feePayCapital;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPrintTime() {
            return printTime;
        }

        public void setPrintTime(String printTime) {
            this.printTime = printTime;
        }

        public List<FeeList> getFeeList() {
            return feeList;
        }

        public void setFeeList(List<FeeList> feeList) {
            this.feeList = feeList;
        }

        @Override
        public String toString() {
            return "FeeInvoiceInfo{" +
                    "feeFlag='" + feeFlag + '\'' +
                    ", feePay='" + feePay + '\'' +
                    ", sumShouldPay='" + sumShouldPay + '\'' +
                    ", feePayCapital='" + feePayCapital + '\'' +
                    ", payType='" + payType + '\'' +
                    ", printTime='" + printTime + '\'' +
                    ", feeList=" + feeList +
                    '}';
        }
    }

    public static class FeeList{
        @ApiModelProperty(name = "CURR_PAY", value = "展示费用(元)")
        @JSONField(name = "CURR_PAY")
        public String  currPay;

        @ApiModelProperty(name = "FEE_CODE", value = "费用代码")
        @JSONField(name = "FEE_CODE")
        public String  feeCode;

        @ApiModelProperty(name = "FEE_NAME", value = "费用描述")
        @JSONField(name = "FEE_NAME")
        public String  feeName;

        @ApiModelProperty(name = "TAX_FEE", value = "税额")
        @JSONField(name = "TAX_FEE")
        public String  taxFee;

        @ApiModelProperty(name = "TAX_RATE", value = "税率")
        @JSONField(name = "TAX_RATE")
        public String  taxRate;

        @ApiModelProperty(name = "TAX_SHOULD", value = "应收(分)")
        @JSONField(name = "TAX_SHOULD")
        public String  taxShould;

        @ApiModelProperty(name = "EXTEND_NODE", value = "扩展节点")
        @JSONField(name = "EXTEND_NODE")
        public String  extendNode;

        public String getCurrPay() {
            return currPay;
        }

        public void setCurrPay(String currPay) {
            this.currPay = currPay;
        }

        public String getFeeCode() {
            return feeCode;
        }

        public void setFeeCode(String feeCode) {
            this.feeCode = feeCode;
        }

        public String getFeeName() {
            return feeName;
        }

        public void setFeeName(String feeName) {
            this.feeName = feeName;
        }

        public String getTaxFee() {
            return taxFee;
        }

        public void setTaxFee(String taxFee) {
            this.taxFee = taxFee;
        }

        public String getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(String taxRate) {
            this.taxRate = taxRate;
        }

        public String getTaxShould() {
            return taxShould;
        }

        public void setTaxShould(String taxShould) {
            this.taxShould = taxShould;
        }

        public String getExtendNode() {
            return extendNode;
        }

        public void setExtendNode(String extendNode) {
            this.extendNode = extendNode;
        }

        @Override
        public String toString() {
            return "FeeList{" +
                    "currPay='" + currPay + '\'' +
                    ", feeCode='" + feeCode + '\'' +
                    ", feeName='" + feeName + '\'' +
                    ", taxFee='" + taxFee + '\'' +
                    ", taxRate='" + taxRate + '\'' +
                    ", taxShould='" + taxShould + '\'' +
                    ", extendNode='" + extendNode + '\'' +
                    '}';
        }
    }

    public static class BillCtrlInfo{
        @ApiModelProperty(name = "BACK_FLAG", value = "退费标识【B冲正，R撤单】")
        @JSONField(name = "BACK_FLAG")
        public String  backFlag;

        @ApiModelProperty(name = "INVOICE_INFO", value = "正向已打印流程relase节点")
        @JSONField(name = "INVOICE_INFO")
        private SubOrderInfoDto.InvoiceInfo invoiceInfo;

        public String getBackFlag() {
            return backFlag;
        }

        public void setBackFlag(String backFlag) {
            this.backFlag = backFlag;
        }

        public InvoiceInfo getInvoiceInfo() {
            return invoiceInfo;
        }

        public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
            this.invoiceInfo = invoiceInfo;
        }

        @Override
        public String toString() {
            return "BillCtrl{" +
                    "backFlag='" + backFlag + '\'' +
                    ", invoiceInfo=" + invoiceInfo +
                    '}';
        }
    }

    public static class InvoiceInfo{
        @ApiModelProperty(name = "PROC_ID", value = "正向已打印流程procId，默认流程为X")
        @JSONField(name = "PROC_ID")
        public String  procId;

        @ApiModelProperty(name = "RELEASE_INFO", value = "正向已打印流程relase节点")
        @JSONField(name = "RELEASE_INFO")
        private SubOrderInfoDto.SubOrderInvoiceReleaseInfo subOrderInvoiceReleaseInfo;

        public String getProcId() {
            return procId;
        }

        public void setProcId(String procId) {
            this.procId = procId;
        }

        public SubOrderInvoiceReleaseInfo getSubOrderInvoiceReleaseInfo() {
            return subOrderInvoiceReleaseInfo;
        }

        public void setSubOrderInvoiceReleaseInfo(SubOrderInvoiceReleaseInfo subOrderInvoiceReleaseInfo) {
            this.subOrderInvoiceReleaseInfo = subOrderInvoiceReleaseInfo;
        }

        @Override
        public String toString() {
            return "InvoiceInfo{" +
                    "procId='" + procId + '\'' +
                    ", subOrderInvoiceReleaseInfo=" + subOrderInvoiceReleaseInfo +
                    '}';
        }
    }

    public static class  SubOrderInvoiceReleaseInfo{

        @ApiModelProperty(name = "BILL_TYPE", value = "单据类型")
        @JSONField(name = "BILL_TYPE")
        public String  billType;

        @ApiModelProperty(name = "NOPAPERFLAG", value = "无纸化标识")
        @JSONField(name = "NOPAPERFLAG")
        public String  noPaperFlag;

        @ApiModelProperty(name = "RELEASE_ID", value = "正向已打印流程relaseid，默认流程为opCode")
        @JSONField(name = "RELEASE_ID")
        public String  releaseId;

        @ApiModelProperty(name = "INVOICE_INFO", value = "正向已打印流程relase节点")
        @JSONField(name = "INVOICE_INFO")
        private SubOrderInfoDto.SubOrderInvoiceInfo subOrderInvoiceInfo;

        public String getBillType() {
            return billType;
        }

        public void setBillType(String billType) {
            this.billType = billType;
        }

        public String getNoPaperFlag() {
            return noPaperFlag;
        }

        public void setNoPaperFlag(String noPaperFlag) {
            this.noPaperFlag = noPaperFlag;
        }

        public String getReleaseId() {
            return releaseId;
        }

        public void setReleaseId(String releaseId) {
            this.releaseId = releaseId;
        }

        public SubOrderInvoiceInfo getSubOrderInvoiceInfo() {
            return subOrderInvoiceInfo;
        }

        public void setSubOrderInvoiceInfo(SubOrderInvoiceInfo subOrderInvoiceInfo) {
            this.subOrderInvoiceInfo = subOrderInvoiceInfo;
        }

        @Override
        public String toString() {
            return "SubOrderInvoiceReleaseInfo{" +
                    "billType='" + billType + '\'' +
                    ", noPaperFlag='" + noPaperFlag + '\'' +
                    ", releaseId='" + releaseId + '\'' +
                    ", subOrderInvoiceInfo=" + subOrderInvoiceInfo +
                    '}';
        }
    }

    public static class  SubOrderInvoiceInfo{
        @ApiModelProperty(name = "INVC_CODE", value = "发票代码")
        @JSONField(name = "INVC_CODE")
        public String  invcCode;

        @ApiModelProperty(name = "PRINT_YM", value = "发票打印年月")
        @JSONField(name = "PRINT_YM")
        public String  printYm;

        @ApiModelProperty(name = "INVOICE_ID", value = "发票号码")
        @JSONField(name = "INVOICE_ID")
        public String  invoiceId;

        public String getInvcCode() {
            return invcCode;
        }

        public void setInvcCode(String invcCode) {
            this.invcCode = invcCode;
        }

        public String getPrintYm() {
            return printYm;
        }

        public void setPrintYm(String printYm) {
            this.printYm = printYm;
        }

        public String getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
        }

        @Override
        public String toString() {
            return "SubOrderInvoiceInfo{" +
                    "invcCode='" + invcCode + '\'' +
                    ", printYm='" + printYm + '\'' +
                    ", invoiceId='" + invoiceId + '\'' +
                    '}';
        }
    }

    public static class  BillpeopleMessage{

        @ApiModelProperty(name = "TAXPAYER_ID", value = "纳税人识别号")
        @JSONField(name = "TAXPAYER_ID")
        public String  taxPayerId;

        @ApiModelProperty(name = "TAXPAYER_NAME", value = "纳税人名称")
        @JSONField(name = "TAXPAYER_NAME")
        public String  taxPayerName;

        @ApiModelProperty(name = "ADDRESS", value = "地址")
        @JSONField(name = "ADDRESS")
        public String  address;

        @ApiModelProperty(name = "PHONE", value = "电话")
        @JSONField(name = "PHONE")
        public String  phone;

        @ApiModelProperty(name = "BANK_NAME", value = "开户行")
        @JSONField(name = "BANK_NAME")
        public String  bankName;

        @ApiModelProperty(name = "BANK_ACCOUNT", value = "银行账号")
        @JSONField(name = "BANK_ACCOUNT")
        public String  bankAccount;

        public String getTaxPayerId() {
            return taxPayerId;
        }

        public void setTaxPayerId(String taxPayerId) {
            this.taxPayerId = taxPayerId;
        }

        public String getTaxPayerName() {
            return taxPayerName;
        }

        public void setTaxPayerName(String taxPayerName) {
            this.taxPayerName = taxPayerName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
        }

        @Override
        public String toString() {
            return "BillpeopleMessage{" +
                    "taxPayerId='" + taxPayerId + '\'' +
                    ", taxPayerName='" + taxPayerName + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", bankName='" + bankName + '\'' +
                    ", bankAccount='" + bankAccount + '\'' +
                    '}';
        }
    }

}
