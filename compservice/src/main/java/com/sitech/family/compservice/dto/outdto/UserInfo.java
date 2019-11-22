package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  用户基本信息查询
 * @date 2019/01/15
 */
public class UserInfo implements Serializable{

    @JSONField(name = "ID_NO")//用户标识
    private String idNo;

    @JSONField(name = "PHONE_NO")//服务号码
    private String phoneNo;

    @JSONField(name = "OWNER_TYPE")//用户类型
    private String ownerType;

    @JSONField(name = "CUST_ID")//客户类型
    private String custId;

    @JSONField(name = "GROUP_ID")//用户归属切点
    private String groupId;

    @JSONField(name = "CONTRACT_NO")//账户标识
    private String contraceNo;

    @JSONField(name = "MASTER_SERV_ID")//主体服务类型
    private String masterServId;

    @JSONField(name = "OPEN_TIME") //入网时间
    private String openTime;

    @JSONField(name = "BILL_END_TIME") //计费结束时间
    private String billEndTime;

    @JSONField(name = "BRAND_ID")//用户品牌标识
    private String brandId;

    @JSONField(name = "BRAND_NAME")//品牌名称
    private String brandName;

    @JSONField(name = "BILL_DAY") //结账日
    private String billDay;

    @JSONField(name = "BILLING_MODE") //付费模式
    private String billingMode;

    @JSONField(name = "RUN_CODE")//运行状态
    private String runCode;

    @JSONField(name = "CARD_TYPE")//客户级别
    private String cadeType;

    @JSONField(name = "RUN_TIME") //状态变化时间
    private String runTime;

    @JSONField(name = "RUN_NAME") //状态名称
    private String runName;

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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getContraceNo() {
        return contraceNo;
    }

    public void setContraceNo(String contraceNo) {
        this.contraceNo = contraceNo;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getBillEndTime() {
        return billEndTime;
    }

    public void setBillEndTime(String billEndTime) {
        this.billEndTime = billEndTime;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBillDay() {
        return billDay;
    }

    public void setBillDay(String billDay) {
        this.billDay = billDay;
    }

    public String getBillingMode() {
        return billingMode;
    }

    public void setBillingMode(String billingMode) {
        this.billingMode = billingMode;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }

    public String getCadeType() {
        return cadeType;
    }

    public void setCadeType(String cadeType) {
        this.cadeType = cadeType;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getRunName() {
        return runName;
    }

    public void setRunName(String runName) {
        this.runName = runName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "idNo='" + idNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", custId='" + custId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", contraceNo='" + contraceNo + '\'' +
                ", masterServId='" + masterServId + '\'' +
                ", openTime='" + openTime + '\'' +
                ", billEndTime='" + billEndTime + '\'' +
                ", brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", billDay='" + billDay + '\'' +
                ", billingMode='" + billingMode + '\'' +
                ", runCode='" + runCode + '\'' +
                ", cadeType='" + cadeType + '\'' +
                ", runTime='" + runTime + '\'' +
                ", runName='" + runName + '\'' +
                '}';
    }
}
