package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class BusiInfoAddress implements Serializable {

    @JSONField(name="REGION_ID")
    @NotBlank(message = "15000$地市不能为空")
    private String regionId;

    @JSONField(name="Community_Name")
    @NotBlank(message = "15000$小区名称不能为空")
    private String communityName;

    @JSONField(name="Work_Type")
    @NotBlank(message = "15000$网络类型不能为空")
    private String workType;

    @JSONField(name="Building_Number")
    @NotBlank(message = "15000$门牌号不能为空")
    private String buildingNumber;

    @JSONField(name="StandardAddress_Id")
    private String standardAddressId;

    @JSONField(name="Amount")
    @NotBlank(message = "15000$最大地址返回条数不能为空")
    private String amount;

    @JSONField(name="Prod_Type")
    private String prodType;

    @JSONField(name="Access_Type")
    @NotBlank(message = "15000$接入类型不能为空")
    private String accessType;

    @Override
    public String toString() {
        return "BusiInfoAddress{" +
                "regionId='" + regionId + '\'' +
                ", communityName='" + communityName + '\'' +
                ", workType='" + workType + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", standardAddressId='" + standardAddressId + '\'' +
                ", amount='" + amount + '\'' +
                ", prodType='" + prodType + '\'' +
                ", accessType='" + accessType + '\'' +
                '}';
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStandardAddressId() {
        return standardAddressId;
    }

    public void setStandardAddressId(String standardAddressId) {
        this.standardAddressId = standardAddressId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}