package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 商品定价
 *
 * @author shirley
 * @date created in 2019/3/28
 */
public class FamilyGoodsPrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @JSONField(name = "PRC_ID")
    private String prcId;
    @JSONField(name = "PRC_NAME")
    private String prcName;
    @JSONField(name = "PRC_DESC")
    private String prcDesc;
    @JSONField(name = "EFF_DATE")
    private String effDate;
    @JSONField(name = "EXP_DATE")
    private String expDate;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getPrcName() {
        return prcName;
    }

    public void setPrcName(String prcName) {
        this.prcName = prcName;
    }

    public String getPrcDesc() {
        return prcDesc;
    }

    public void setPrcDesc(String prcDesc) {
        this.prcDesc = prcDesc;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "FamilyGoodsPrc{" +
                "prcId='" + prcId + '\'' +
                ", prcName='" + prcName + '\'' +
                ", prcDesc='" + prcDesc + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
