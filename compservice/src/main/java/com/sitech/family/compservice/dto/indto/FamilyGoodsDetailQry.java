package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author shirley
 * @date created in 2019/1/11
 */
@ApiModel(value = "BUSI_INFO",description = "家庭套餐构成入参")
public class FamilyGoodsDetailQry {

    @ApiModelProperty(name = "GOODS_INFO", value = "GOODS_INFO节点", required = true)
    @NotNull(message = "节点[GOODS_INFO]不能为空")
    @JSONField(name = "GOODS_INFO")
    @Valid
    private DetailGoodsInfo detailGoodsInfo;

    public DetailGoodsInfo getDetailGoodsInfo() {
        return detailGoodsInfo;
    }

    public void setDetailGoodsInfo(DetailGoodsInfo detailGoodsInfo) {
        this.detailGoodsInfo = detailGoodsInfo;
    }
}
