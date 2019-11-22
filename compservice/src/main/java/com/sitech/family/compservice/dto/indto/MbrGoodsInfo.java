package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by shirley on 2018/8/28.
 */
@ApiModel(value = "MBR_GOODS_INFO",description = "家庭套餐实体")
public class MbrGoodsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "GOODS_ID", value = "商品编码", required = true, example = "G10214")
    @NotBlank(message = "商品编码[GOODS_ID]不能为空")
    @JSONField(name = "GOODS_ID")
    private String goodsId;

    @ApiModelProperty(name = "MEMBER_ROLE_TYPE", value = "角色大类代码", required = true, example = "0")
    @NotBlank(message = "角色大类代码[MEMBER_ROLE_TYPE]不能为空")
    @JSONField(name = "MEMBER_ROLE_TYPE")
    private String memberRoleType;

    @ApiModelProperty(name = "MASTER_SERV_ID", value = "主体服务类型", required = true, example = "A")
    @NotBlank(message = "主体服务类型[MASTER_SERV_ID]不能为空")
    @JSONField(name = "MASTER_SERV_ID")
    private String masterServId;

    @ApiModelProperty(name = "PRC_ID", value = "资费编码", required = true, example = "M100220")
    //@NotBlank(message = "资费编码[PRC_ID]不能为空")
    @JSONField(name = "PRC_ID")
    private String prcId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getMemberRoleType() {
        return memberRoleType;
    }

    public void setMemberRoleType(String memberRoleType) {
        this.memberRoleType = memberRoleType;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }
}
