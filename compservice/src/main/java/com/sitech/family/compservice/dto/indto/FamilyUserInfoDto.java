package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

import java.util.List;

/**
 * Created by xuwei on 2019/4/8.
 */

@ApiModel(value = "FamilyUserInfo",description = "家庭群用户信息")
public class FamilyUserInfoDto {

    @ApiModelProperty(name = "MASTER_SERV_ID", value = "主体服务类型")
    @JSONField(name = "MASTER_SERV_ID")
    @NotBlank(message = "190010$主体服务类型不能为空")
    public String  masterServId;

    @ApiModelProperty(name = "EMP_ID", value = "发展人")
    @JSONField(name = "EMP_ID")
    public String  empId;

    @ApiModelProperty(name = "EMP_GROUP", value = "发展人归属")
    @JSONField(name = "EMP_GROUP")
    public String  empGroup;


    @ApiModelProperty(name = "USERGROUP_INFO", value = "家庭群组信息")
    @JSONField(name = "USERGROUP_INFO")
    public FamilyGroupInfoInDto userGroupInfo;

    @ApiModelProperty(name = "DELIVER_INFO", value = "物流配送信息")
    @JSONField(name = "DELIVER_INFO")
    public FamilyDeliverInfoDto deliverInfo;


    @ApiModelProperty(name = "USERGOODSINFOLIST", value = "家庭用户商品订购信息")
    @JSONField(name = "USERGOODSINFOLIST")
    public List<FamilyUserGoodsInfoDto>  userGoodsInfoList;

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpGroup() {
        return empGroup;
    }

    public void setEmpGroup(String empGroup) {
        this.empGroup = empGroup;
    }

    public FamilyGroupInfoInDto getUserGroupInfo() {
        return userGroupInfo;
    }

    public void setUserGroupInfo(FamilyGroupInfoInDto userGroupInfo) {
        this.userGroupInfo = userGroupInfo;
    }

    public FamilyDeliverInfoDto getDeliverInfo() {
        return deliverInfo;
    }

    public void setDeliverInfo(FamilyDeliverInfoDto deliverInfo) {
        this.deliverInfo = deliverInfo;
    }

    public List<FamilyUserGoodsInfoDto> getUserGoodsInfoList() {
        return userGoodsInfoList;
    }

    public void setUserGoodsInfoList(List<FamilyUserGoodsInfoDto> userGoodsInfoList) {
        this.userGoodsInfoList = userGoodsInfoList;
    }

    @Override
    public String toString() {
        return "FamilyUserInfoDto{" +
                "masterServId='" + masterServId + '\'' +
                ", empId='" + empId + '\'' +
                ", empGroup='" + empGroup + '\'' +
                ", userGroupInfo=" + userGroupInfo +
                ", deliverInfo=" + deliverInfo +
                ", userGoodsInfoList=" + userGoodsInfoList +
                '}';
    }
}
