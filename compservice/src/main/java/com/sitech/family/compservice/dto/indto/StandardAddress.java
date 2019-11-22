package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitech.family.common.dto.OprInfo;

import java.io.Serializable;

public class StandardAddress implements Serializable {

    @JsonProperty("OPR_INFO")
    @JSONField(name = "OPR_INFO")
    private OprInfo oprInfo;

    @JsonProperty("BUSI_INFO")
    @JSONField(name = "BUSI_INFO")
    private BusiInfoAddress busiInfoAddress;

    public OprInfo getOprInfo() {
        return oprInfo;
    }

    public void setOprInfo(OprInfo oprInfo) {
        this.oprInfo = oprInfo;
    }

    public BusiInfoAddress getBusiInfoAddress() {
        return busiInfoAddress;
    }

    public void setBusiInfoAddress(BusiInfoAddress busiInfoAddress) {
        this.busiInfoAddress = busiInfoAddress;
    }

    @Override
    public String toString() {
        return "StandardAddress{"
                +"oprInfo"+oprInfo
                +", busiInfoAddress"+busiInfoAddress;
    }
}
