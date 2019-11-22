package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 成员资费信息
 *
 * @author shirley
 * @date created in 2019/3/28
 */
public class FamilyMbrPrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @JSONField(name = "MBR_PRC_ID")
    private String mbrPrcId;
    @JSONField(name = "MBR_PRC_NAME")
    private String mbrPrcName;
    @JSONField(name = "MBR_PRC_DESC")
    private String mbrPrcDesc;

    public String getMbrPrcId() {
        return mbrPrcId;
    }

    public void setMbrPrcId(String mbrPrcId) {
        this.mbrPrcId = mbrPrcId;
    }

    public String getMbrPrcName() {
        return mbrPrcName;
    }

    public void setMbrPrcName(String mbrPrcName) {
        this.mbrPrcName = mbrPrcName;
    }

    public String getMbrPrcDesc() {
        return mbrPrcDesc;
    }

    public void setMbrPrcDesc(String mbrPrcDesc) {
        this.mbrPrcDesc = mbrPrcDesc;
    }

    @Override
    public String toString() {
        return "FamilyMbrPrc{" +
                "mbrPrcId='" + mbrPrcId + '\'' +
                ", mbrPrcName='" + mbrPrcName + '\'' +
                ", mbrPrcDesc='" + mbrPrcDesc + '\'' +
                '}';
    }
}
