package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GoodsDetailItem implements Serializable {

    @JSONField(name = "MASTER_SERV_ID")
    private String masterServId;
    @JSONField(name = "LABEL_ID")
    private String labelId;

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "GoodsDetailItem{" +
                "masterServId='" + masterServId + '\'' +
                ", labelId='" + labelId + '\'' +
                '}';
    }
}
