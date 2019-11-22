package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: familybusi
 * @description: 服务请求费用计算配置信息
 * @author: yang xing
 * @create: 2018-12-19 16:14
 */
public class FeePrice implements Serializable {

    private Long feeId;
    private String groupId;
    private String svcId;
    private String actionId;
    private String busiMode;
    private String feeCode;
    private String feeType;
    private Date effDate;
    private Date expDate;
    private String dataType;
    private Long feeValue;
    private String feeUnit;
    private String calType;
    private String printFlag;
    private String payType;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSvcId() {
        return svcId;
    }

    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getBusiMode() {
        return busiMode;
    }

    public void setBusiMode(String busiMode) {
        this.busiMode = busiMode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Long feeValue) {
        this.feeValue = feeValue;
    }

    public String getFeeUnit() {
        return feeUnit;
    }

    public void setFeeUnit(String feeUnit) {
        this.feeUnit = feeUnit;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(String printFlag) {
        this.printFlag = printFlag;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "FeePrice{" +
                "feeId=" + feeId +
                ", groupId='" + groupId + '\'' +
                ", svcId='" + svcId + '\'' +
                ", actionId='" + actionId + '\'' +
                ", busiMode='" + busiMode + '\'' +
                ", feeCode='" + feeCode + '\'' +
                ", feeType='" + feeType + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", dataType='" + dataType + '\'' +
                ", feeValue=" + feeValue +
                ", feeUnit='" + feeUnit + '\'' +
                ", calType='" + calType + '\'' +
                ", printFlag='" + printFlag + '\'' +
                ", payType='" + payType + '\'' +
                '}';
    }
}
