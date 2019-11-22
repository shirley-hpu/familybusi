package com.sitech.family.common.pubdto;
import java.io.Serializable;
import java.util.Map;



/**
 * Created by xuwei on 2018/7/23.
 * @Description: 担保人节点
 */
public class AssurePubInfo implements Serializable {
    private static final long serialVersionUID = 94668976L;

    private String idType;
    private String idIccid;
    private String assureNo;
    private String assureName;
    private String assurePhone;
    private String assureZip;
    private String assureAddress;
    private String assureCustId;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdIccid() {
        return idIccid;
    }

    public void setIdIccid(String idIccid) {
        this.idIccid = idIccid;
    }

    public String getAssureNo() {
        return assureNo;
    }

    public void setAssureNo(String assureNo) {
        this.assureNo = assureNo;
    }

    public String getAssureName() {
        return assureName;
    }

    public void setAssureName(String assureName) {
        this.assureName = assureName;
    }

    public String getAssurePhone() {
        return assurePhone;
    }

    public void setAssurePhone(String assurePhone) {
        this.assurePhone = assurePhone;
    }

    public String getAssureZip() {
        return assureZip;
    }

    public void setAssureZip(String assureZip) {
        this.assureZip = assureZip;
    }

    public String getAssureAddress() {
        return assureAddress;
    }

    public void setAssureAddress(String assureAddress) {
        this.assureAddress = assureAddress;
    }

    public String getAssureCustId() {
        return assureCustId;
    }

    public void setAssureCustId(String assureCustId) {
        this.assureCustId = assureCustId;
    }


}

