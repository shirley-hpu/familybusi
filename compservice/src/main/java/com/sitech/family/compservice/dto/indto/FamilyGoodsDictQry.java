package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "BUSI_INFO", description = "商品信息查询入参")
public class FamilyGoodsDictQry {

    @ApiModelProperty(name = "GOODS_ID", value = "GOODS_ID")
    @NotBlank(message = "商品ID不能为空")
    @JSONField(name = "GOODS_ID")
    private String goodsId;

    @ApiModelProperty(name = "PRC_ID", value = "PRC_ID")
    @NotBlank(message = "资费ID不能为空")
    @JSONField(name = "PRC_ID")
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
}
