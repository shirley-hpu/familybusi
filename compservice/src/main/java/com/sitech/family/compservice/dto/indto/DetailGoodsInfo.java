package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by shirley on 2018/8/28.
 */
@ApiModel(value = "DETAIL_GOODS_INFO",description = "家庭套餐实体")
public class DetailGoodsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "GOODS_ID", value = "商品编码", required = true, example = "G10214")
    @NotBlank(message = "商品编码[GOODS_ID]不能为空")
    @JSONField(name = "GOODS_ID")
    private String goodsId;

    @ApiModelProperty(name = "PRC_ID", value = "资费编码", required = true, example = "M100220")
    @NotBlank(message = "资费编码[PRC_ID]不能为空")
    @JSONField(name = "PRC_ID")
    private String prcId;

    @ApiModelProperty(name = "MEMBER_ROLE_ID", value = "角色编码", required = true, example = "10240")
    //@NotBlank(message = "角色编码[MEMBER_ROLE_ID]不能为空")
    @JSONField(name = "MEMBER_ROLE_ID")
    private String memberRoleId;


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

    public String getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(String memberRoleId) {
        this.memberRoleId = memberRoleId;
    }
}
