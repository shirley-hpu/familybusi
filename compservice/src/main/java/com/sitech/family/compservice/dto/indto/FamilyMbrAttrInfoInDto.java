package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2019/4/16.
 */

@ApiModel(value = "FamilyMbrAttrInfo",description = "群成员附加属性信息")
public class FamilyMbrAttrInfoInDto extends FamilyBaseAttrInfo {
    @ApiModelProperty(name = "EFF_DATE", value = "群成员附加属性生效时间")
    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "180025$群成员附加属性生效时间")
    public String  effDate;

    @ApiModelProperty(name = "EXP_DATE", value = "群成员附加属性失效时间")
    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "180026$群成员附加属性时间不能为空")
    public String  expDate;

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "FamilyMbrAttrInfoInDto{" +
                "attrId='" + attrId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", attrValue='" + attrValue + '\'' +
                ", expDate='" + expDate + '\'' +
                ", grpNo='" + grpNo + '\'' +
                '}';
    }
}
