package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/2 13:35
 */
@ApiModel(value = "FamilyGroupMbrInDto", description = "家庭群成员信息查询入参")
public class FamilyGroupMbrInDto {
    @ApiModelProperty(name = "MEMBER_ID", value = "成员编号")
    @JSONField(name = "MEMBER_ID")
    private String memberId;
    @ApiModelProperty(name = "GROUP_ID", value = "群编号")
    @JSONField(name = "GROUP_ID")
    private String groupId;
    @ApiModelProperty(name = "PHONE_NO", value = "成员号码")
    @JSONField(name = "PHONE_NO")
    private String phoneNo;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
