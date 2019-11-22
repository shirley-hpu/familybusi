package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

import java.util.List;

/**
 * Created by xuwei on 2019/4/16.
 * 群成员信息
 */

@ApiModel(value = "FamilyMbrUserInfo",description = "群成员信息")
public class FamilyMbrUserInfoInDto {
    @ApiModelProperty(name = "ROLE_ID", value = "群成员角色大类")
    @JSONField(name = "ROLE_ID")
    @NotBlank(message = "180017$群成员角色大类不能为空")
    public String  roleId;

    @ApiModelProperty(name = "MEMBER_ROLE_ID", value = "群成员类别角色标识")
    @JSONField(name = "MEMBER_ROLE_ID")
    @NotBlank(message = "180018$群成员类别角色标识不能为空")
    public String  memberRoleId;

    @ApiModelProperty(name = "OBJECT_TYPE", value = "关联群成员号码类型")
    @JSONField(name = "OBJECT_TYPE")
    @NotBlank(message = "180019$群成员号码类型不能为空")
    public String  objectType;

    @ApiModelProperty(name = "OBJECT_ID", value = "关联成员号码")
    @JSONField(name = "OBJECT_ID")
    @NotBlank(message = "180020$关联成员号码不能为空")
    public String  objectId;

    @ApiModelProperty(name = "ID_NO", value = "用户ID")
    @JSONField(name = "ID_NO")
    public String  idNo;

    @ApiModelProperty(name = "MEMBER_DESC", value = "群成员描述")
    @JSONField(name = "MEMBER_DESC")
    @NotBlank(message = "180021$群成员描述不能为空")
    public String  memberDesc;

    @ApiModelProperty(name = "OPEN_FLAG", value = "新开户标识")
    @JSONField(name = "OPEN_FLAG")
    @NotBlank(message = "180022$新开户标识不能不能为空")
    public String  openFlag;


    @ApiModelProperty(name = "EFF_DATE", value = "群成员生效时间")
    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "180023$群成员生效时间不能为空")
    public String  effDate;

    @ApiModelProperty(name = "EXP_DATE", value = "群成员失效时间")
    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "180024$群成员失效时间不能为空")
    public String  expDate;

    @ApiModelProperty(name = "FINISH_FLAG", value = "长流程标识")
    @JSONField(name = "FINISH_FLAG")
    @NotBlank(message = "180025$长流程标识标识不能不能为空")
    public String  finishFlag;

    @ApiModelProperty(name = "PHONE_NO", value = "成员手机号")
    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "180050$成员手机号不能不能为空")
    public String  phoneNO;

    @ApiModelProperty(name = "USERGROUPMBRATTRINFOLIST", value = "成员属性")
    @JSONField(name = "USERGROUPMBRATTRINFOLIST")
    public List<FamilyMbrAttrInfoInDto> userGroupMbrAttrInfoList;


    @ApiModelProperty(name = "USERGROUPMBRGOODSINFOLIST", value = "成员商品列表")
    @JSONField(name = "USERGROUPMBRGOODSINFOLIST")
    public List<FamilyMbrGoodsInfoInDto>  userGroupMbrGoodsInfoList;

    @ApiModelProperty(name = "CONUSRRELINFOLIST", value = "成员付费关系列表")
    @JSONField(name = "CONUSRRELINFOLIST")
    public List<FamilyMbrConuserRelInfoInDto> conUsrRelInfoList;

    @ApiModelProperty(name = "PAY_ITEM_INFO", value = "付费模式")
    @JSONField(name = "PAY_ITEM_INFO")
    public FamilyMbrPayItemInfoInDto payItemInfo;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(String memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMemberDesc() {
        return memberDesc;
    }

    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public List<FamilyMbrAttrInfoInDto> getUserGroupMbrAttrInfoList() {
        return userGroupMbrAttrInfoList;
    }

    public void setUserGroupMbrAttrInfoList(List<FamilyMbrAttrInfoInDto> userGroupMbrAttrInfoList) {
        this.userGroupMbrAttrInfoList = userGroupMbrAttrInfoList;
    }

    public List<FamilyMbrGoodsInfoInDto> getUserGroupMbrGoodsInfoList() {
        return userGroupMbrGoodsInfoList;
    }

    public void setUserGroupMbrGoodsInfoList(List<FamilyMbrGoodsInfoInDto> userGroupMbrGoodsInfoList) {
        this.userGroupMbrGoodsInfoList = userGroupMbrGoodsInfoList;
    }

    public List<FamilyMbrConuserRelInfoInDto> getConUsrRelInfoList() {
        return conUsrRelInfoList;
    }

    public void setConUsrRelInfoList(List<FamilyMbrConuserRelInfoInDto> conUsrRelInfoList) {
        this.conUsrRelInfoList = conUsrRelInfoList;
    }

    public FamilyMbrPayItemInfoInDto getPayItemInfo() {
        return payItemInfo;
    }

    public void setPayItemInfo(FamilyMbrPayItemInfoInDto payItemInfo) {
        this.payItemInfo = payItemInfo;
    }

    @Override
    public String toString() {
        return "FamilyMbrUserInfoInDto{" +
                "roleId='" + roleId + '\'' +
                ", memberRoleId='" + memberRoleId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", idNo='" + idNo + '\'' +
                ", memberDesc='" + memberDesc + '\'' +
                ", openFlag='" + openFlag + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", phoneNO='" + phoneNO + '\'' +
                ", userGroupMbrAttrInfoList=" + userGroupMbrAttrInfoList +
                ", userGroupMbrGoodsInfoList=" + userGroupMbrGoodsInfoList +
                ", conUsrRelInfoList=" + conUsrRelInfoList +
                ", payItemInfo=" + payItemInfo +
                '}';
    }
}
