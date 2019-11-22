package com.sitech.family.custservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sitech.family.common.pubdto.FamilyUserApplyInfo;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户资料落地 入参实体
 *
 * @author shirley
 * @date created in 2019/3/22
 */
//@ApiModel(value = "USER_INFO",description = "用户资料落地入参")
public class FamilyUserApplyInDto implements Serializable {

    /**
     * @see FamilyUserApplyInfo
     */
    @Valid
    @JSONField(name = "USER_INFO")
    @JsonProperty("USER_INFO")
    @NotNull(message = "15000$用户资料落地信息节点不能为空")
    @ApiModelProperty(name = "compx", value = "用户资料落地信息节点", required = true)
    private FamilyUserApplyInfo familyUserApplyInfo;

    public FamilyUserApplyInfo getFamilyUserApplyInfo() {
        return familyUserApplyInfo;
    }

    public void setFamilyUserApplyInfo(FamilyUserApplyInfo familyUserApplyInfo) {
        this.familyUserApplyInfo = familyUserApplyInfo;
    }

    @Override
    public String toString() {
        return "FamilyUserApplyInDto{" +
                "familyUserApplyInfo=" + familyUserApplyInfo +
                '}';
    }
}
