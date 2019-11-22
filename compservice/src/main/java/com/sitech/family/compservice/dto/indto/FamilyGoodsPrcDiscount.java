package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-03 10:37
 * @Version: 1.0
 */
public class FamilyGoodsPrcDiscount implements Serializable {

    @JSONField(name = "PKG_PRC_ID")
    private String pkgPrcId;

    @JSONField(name = "MBR_PRC_ID")
    private String mbrPrcId;

    public String getPkgPrcId() {
        return pkgPrcId;
    }

    public void setPkgPrcId(String pkgPrcId) {
        this.pkgPrcId = pkgPrcId;
    }

    public String getMbrPrcId() {
        return mbrPrcId;
    }

    public void setMbrPrcId(String mbrPrcId) {
        this.mbrPrcId = mbrPrcId;
    }

    @Override
    public String toString() {
        return "FamilyGoodsPrcDiscount{" +
                "pkgPrcId='" + pkgPrcId + '\'' +
                ", mbrPrcId='" + mbrPrcId + '\'' +
                '}';
    }
}
