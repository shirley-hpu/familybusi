package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

public class GoodsInfoGoods implements Serializable {

    @JSONField(name ="GROUP_TYPE")
    @NotBlank(message = "入参GROUP_TYPE节点不能为空")
    private String groupType;

    @JSONField(name = "GOODSDETAILLIST")
    private List<GoodsDetailItem> goodsDetailItemList;

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public List<GoodsDetailItem> getGoodsDetailItemList() {
        return goodsDetailItemList;
    }

    public void setGoodsDetailItemList(List<GoodsDetailItem> goodsDetailItemList) {
        this.goodsDetailItemList = goodsDetailItemList;
    }

    @Override
    public String toString() {
        return "GoodsInfoGoods{" +
                "groupType='" + groupType + '\'' +
                ", goodsDetailItemList=" + goodsDetailItemList +
                '}';
    }
}
