package com.sitech.preservice.dto;

import java.io.Serializable;
import java.util.Date;

public class FmPreOrderRdOutDto implements Serializable {

    private String phoneNo;

    private String opDate;

    private Date opTime;

    private String preOpCode;

    private String preOpName;

    private String preNote;

    private String prePrcId;

    private String preRelId;

    private String preRelName;

    private String prePrcName;

    private String prePrcDesc;

    private String prePrcPrice;

    private String preAddressId;

    private String preAddressInfo;

    private String preInstallTime;

    @Override
    public String toString() {
        return "FmPreOrderRdOutDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", opDate='" + opDate + '\'' +
                ", opTime='" + opTime + '\'' +
                ", preOpCode='" + preOpCode + '\'' +
                ", preOpName='" + preOpName + '\'' +
                ", preNote='" + preNote + '\'' +
                ", prePrcId='" + prePrcId + '\'' +
                ", preRelId='" + preRelId + '\'' +
                ", preRelName='" + preRelName + '\'' +
                ", prePrcName='" + prePrcName + '\'' +
                ", prePrcDesc='" + prePrcDesc + '\'' +
                ", prePrcPrice='" + prePrcPrice + '\'' +
                ", preAddressId='" + preAddressId + '\'' +
                ", preAddressInfo='" + preAddressInfo + '\'' +
                ", preInstallTime='" + preInstallTime + '\'' +
                '}';
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getPreOpCode() {
        return preOpCode;
    }

    public void setPreOpCode(String preOpCode) {
        this.preOpCode = preOpCode;
    }

    public String getPreOpName() {
        return preOpName;
    }

    public void setPreOpName(String preOpName) {
        this.preOpName = preOpName;
    }

    public String getPreNote() {
        return preNote;
    }

    public void setPreNote(String preNote) {
        this.preNote = preNote;
    }

    public String getPrePrcId() {
        return prePrcId;
    }

    public void setPrePrcId(String prePrcId) {
        this.prePrcId = prePrcId;
    }

    public String getPreRelId() {
        return preRelId;
    }

    public void setPreRelId(String preRelId) {
        this.preRelId = preRelId;
    }

    public String getPreRelName() {
        return preRelName;
    }

    public void setPreRelName(String preRelName) {
        this.preRelName = preRelName;
    }

    public String getPrePrcName() {
        return prePrcName;
    }

    public void setPrePrcName(String prePrcName) {
        this.prePrcName = prePrcName;
    }

    public String getPrePrcDesc() {
        return prePrcDesc;
    }

    public void setPrePrcDesc(String prePrcDesc) {
        this.prePrcDesc = prePrcDesc;
    }

    public String getPrePrcPrice() {
        return prePrcPrice;
    }

    public void setPrePrcPrice(String prePrcPrice) {
        this.prePrcPrice = prePrcPrice;
    }

    public String getPreAddressId() {
        return preAddressId;
    }

    public void setPreAddressId(String preAddressId) {
        this.preAddressId = preAddressId;
    }

    public String getPreAddressInfo() {
        return preAddressInfo;
    }

    public void setPreAddressInfo(String preAddressInfo) {
        this.preAddressInfo = preAddressInfo;
    }

    public String getPreInstallTime() {
        return preInstallTime;
    }

    public void setPreInstallTime(String preInstallTime) {
        this.preInstallTime = preInstallTime;
    }
}
