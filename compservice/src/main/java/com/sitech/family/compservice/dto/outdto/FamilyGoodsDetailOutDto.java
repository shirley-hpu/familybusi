package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 家庭套餐构成查询出参
 *
 * @author shirley
 * @date created in 2019/4/15
 */
public class FamilyGoodsDetailOutDto implements Serializable {

    @JSONField(name = "PKG_GOODS_INFO")
    private FamilyGoodsDetail familyGoodsDetail;

    public FamilyGoodsDetail getFamilyGoodsDetail() {
        return familyGoodsDetail;
    }

    public void setFamilyGoodsDetail(FamilyGoodsDetail familyGoodsDetail) {
        this.familyGoodsDetail = familyGoodsDetail;
    }

    @Override
    public String toString() {
        return "FamilyGoodsDetailOutDto{" +
                "familyGoodsDetail=" + familyGoodsDetail +
                '}';
    }
}
