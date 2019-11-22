package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2019/4/8.
 */

@ApiModel(value = "FamilyGroupInfo",description = "家庭群信息")
public class FamilyGroupInfoInDto {

    @ApiModelProperty(name = "GROUP_TYPE", value = "群类型")
    @JSONField(name = "GROUP_TYPE")
    @NotBlank(message = "190009$群类型不能为空")
    public String  groupType;

    @ApiModelProperty(name = "GROUP_NAME", value = "群名称")
    @JSONField(name = "GROUP_NAME")
    @NotBlank(message = "190009$群名称不能为空")
    public String  groupName;

    @ApiModelProperty(name = "GROUP_DESC", value = "群描述")
    @JSONField(name = "GROUP_DESC")
    public String  groupDesc;

    @ApiModelProperty(name = "USE_ADDRESS", value = "使用地址")
    @JSONField(name = "USE_ADDRESS")
    public String  useAddress;

    @ApiModelProperty(name = "GROUP_CODE", value = "群编码")
    @JSONField(name = "GROUP_CODE")
    public String  groupCode;

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getUseAddress() {
        return useAddress;
    }

    public void setUseAddress(String useAddress) {
        this.useAddress = useAddress;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    public String toString() {
        return "FamilyGroupInfoInDto{" +
                "groupType='" + groupType + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", useAddress='" + useAddress + '\'' +
                ", groupCode='" + groupCode + '\'' +
                '}';
    }
}
