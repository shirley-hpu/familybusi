package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by xuwei on 2019/4/16.
 * 家庭开户提交报文入口
 */

@ApiModel(value = "FamilyOpenCfm",description = "家庭开户提交")
public class FamilyOpenCfmInDto {
    @ApiModelProperty(name = "USER_INFO", value = "家庭群用户信息")
    @JSONField(name = "USER_INFO")
    public FamilyUserInfoDto userInfo;

    @ApiModelProperty(name = "USERGROUPMBRINFOLIST", value = "家庭群成员信息")
    @JSONField(name = "USERGROUPMBRINFOLIST")
    public List<FamilyMbrUserInfoInDto> userGroupMbrInfoList;

    public FamilyUserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(FamilyUserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    public List<FamilyMbrUserInfoInDto> getUserGroupMbrInfoList() {
        return userGroupMbrInfoList;
    }

    public void setUserGroupMbrInfoList(List<FamilyMbrUserInfoInDto> userGroupMbrInfoList) {
        this.userGroupMbrInfoList = userGroupMbrInfoList;
    }

    @Override
    public String toString() {
        return "FamilyOpenCfmInDto{" +
                "userInfo=" + userInfo +
                ", userGroupMbrInfoList=" + userGroupMbrInfoList +
                '}';
    }
}
