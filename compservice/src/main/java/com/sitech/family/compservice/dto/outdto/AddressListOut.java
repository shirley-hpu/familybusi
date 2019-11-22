package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
/**
 * @author guanqp
 * @description 宽带地址查询AddressLis出参节点
 * @date 2018/12/19
 */
public class AddressListOut implements Serializable{

    @JSONField(name = "Address_Id")
    private String addressId;
    @JSONField(name = "StandardAddress_Id")
    private String standardAddressId;
    @JSONField(name = "StandardAddress_Name")
    private String standardAddressName;
    @JSONField(name = "UserInstallArea_Id")
    private String userInstallAreaId;
    @JSONField(name = "Access_Type")
    private String accessType;

    @Override
    public String toString() {
        return "AddressListOut{" +
                "addressId='" + addressId + '\'' +
                ", standardAddressId='" + standardAddressId + '\'' +
                ", standardAddressName='" + standardAddressName + '\'' +
                ", userInstallAreaId='" + userInstallAreaId + '\'' +
                ", accessType='" + accessType + '\'' +
                '}';
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStandardAddressId() {
        return standardAddressId;
    }

    public void setStandardAddressId(String standardAddressId) {
        this.standardAddressId = standardAddressId;
    }

    public String getStandardAddressName() {
        return standardAddressName;
    }

    public void setStandardAddressName(String standardAddressName) {
        this.standardAddressName = standardAddressName;
    }

    public String getUserInstallAreaId() {
        return userInstallAreaId;
    }

    public void setUserInstallAreaId(String userInstallAreaId) {
        this.userInstallAreaId = userInstallAreaId;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
