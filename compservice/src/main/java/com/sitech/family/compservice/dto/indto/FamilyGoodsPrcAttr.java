package com.sitech.family.compservice.dto.indto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wusm
 * @description 商品定价属性查询
 * @date 2019/04/01 10:23
 */
public class FamilyGoodsPrcAttr implements Serializable {

    @JsonProperty("PRC_ID")
    private String prcId;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    @Override
    public String toString() {
        return "FamilyGoodsPrcAttr{" +
                "prcId='" + prcId + '\'' +
                '}';
    }
}
