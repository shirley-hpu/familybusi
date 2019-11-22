package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xuwei on 2019/4/3.
 */

@ApiModel(value = "AttrInfo",description = "属性信息")
public class FamilyBaseAttrInfo {

    @ApiModelProperty(name = "ATTR_ID", value = "属性标识")
    @JSONField(name="ATTR_ID")
    public String attrId;

    @ApiModelProperty(name = "ATTR_VALUE", value = "属性值")
    @JSONField(name="ATTR_VALUE")
    public String attrValue;

    @ApiModelProperty(name = "GRP_NO", value = "组号")
    @JSONField(name="GRP_NO")
    public String grpNo;

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    @Override
    public String toString() {
        return "FamilyBaseAttrInfo{" +
                "attrId='" + attrId + '\'' +
                ", attrValue='" + attrValue + '\'' +
                ", grpNo='" + grpNo + '\'' +
                '}';
    }
}
