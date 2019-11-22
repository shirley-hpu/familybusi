package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
public class OpenUserCountNumBusiInfoOutDto implements Serializable {

    @JSONField(name = "OPEN_RESULTS")
    private String openResults;

    @JSONField(name = "ID_ICCID")
    private String idIccid;

    @JSONField(name = "ID_NAME")
    private String idName;

    public String getOpenResults() {
        return openResults;
    }

    public void setOpenResults(String openResults) {
        this.openResults = openResults;
    }

    public String getIdIccid() {
        return idIccid;
    }

    public void setIdIccid(String idIccid) {
        this.idIccid = idIccid;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    @Override
    public String toString() {
        return "OpenUserCountNumBusiInfoOutDto{" +
                "openResults='" + openResults + '\'' +
                ", idIccid='" + idIccid + '\'' +
                ", idName='" + idName + '\'' +
                '}';
    }
}
