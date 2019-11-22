package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author shirley
 * @date created in 2019/1/11
 */
@ApiModel(value = "BUSI_INFO",description = "家庭套餐构成入参")
public class FamilyGoodsMbrQry {

    @ApiModelProperty(name = "ID_NO", value = "用户ID")
    @JSONField(name = "ID_NO")
    private String idNo;

    @ApiModelProperty(name = "PHONE_NO", value = "服务号码", required = true, example = "13912345678")
    @NotBlank(message = "手机号码[PHONE_NO]不能为空")
    @JSONField(name = "PHONE_NO")
    private String phoneNo;

    @ApiModelProperty(name = "GOODS_INFO", value = "GOODS_INFO节点", required = true)
    @NotNull(message = "节点[GOODS_INFO]不能为空")
    @JSONField(name = "GOODS_INFO")
    @Valid
    private MbrGoodsInfo familyGoodsInfo;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public MbrGoodsInfo getFamilyGoodsInfo() {
        return familyGoodsInfo;
    }

    public void setFamilyGoodsInfo(MbrGoodsInfo familyGoodsInfo) {
        this.familyGoodsInfo = familyGoodsInfo;
    }
}
