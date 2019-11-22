package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-24 09:48
 * @Version: 1.0
 */
public class FamilyPkgGoodsInfo implements Serializable {

    @JSONField(name = "GOODS_ID")
    @NotBlank(message = "GOODS_ID不能为空")
    private String goodsId;

    @JSONField(name = "PRC_ID")
    @NotBlank(message = "PRC_ID不能为空")
    private String prcId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    @Override
    public String toString() {
        return "FamilyPkgGoodsInfo{" +
                "goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                '}';
    }
}
