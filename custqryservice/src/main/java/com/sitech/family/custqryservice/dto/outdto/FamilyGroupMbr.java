package com.sitech.family.custqryservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/1 14:01
 */
public class FamilyGroupMbr implements Serializable {
    @JSONField(name="MEMBER_ID")
    private BigDecimal memberId;
    @JSONField(name="GROUP_ID")
    private BigDecimal groupId;
    @JSONField(name="MBR_ROLE")
    private Long mbrRole;
    @JSONField(name = "MBR_TYPE")
    private String mbrType;
    @JSONField(name="ELEMENT_ID")
    private String elementId;

    public Long getMbrRole() {
        return mbrRole;
    }

    public void setMbrRole(Long mbrRole) {
        this.mbrRole = mbrRole;
    }

    public String getMbrType() {
        return mbrType;
    }

    public void setMbrType(String mbrType) {
        this.mbrType = mbrType;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    @JSONField(name="OBJECT_TYPE")

    private String objectType;
    @JSONField(name="PHONE_NO")
    private String phoneNo;
    @JSONField(name="STATE")
    private String state;
    @JSONField(name="MEMBER_DESC")
    private String memberDesc;
    @JSONField(name="MEMBER_NAME")
    private String memberName;
    @JSONField(name="EFF_DATE")
    private Date effDate;
    @JSONField(name="EXP_DATE")
    private Date expDate;
    @JSONField(name="IS_UNITE_PAY")
    private String isUnitePay;

    //added by shirley
    //成员角色大类
    @JSONField(name = "ROLE_ID_BAK")
    private Long roleId;
    //成员商品订购信息(主商品/附加商品 按goods_type=0/1区分)
    @JSONField(name = "GOODS_INFO")
    private List<GoodsPrcInfo> goodsPrcInfoList;
    //成员家庭共享信息()
    @JSONField(name = "SHARE_INFO")
    private List<GoodsPrcInfo> shareInfoList;


    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMemberDesc() {
        return memberDesc;
    }

    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getIsUnitePay() {
        return isUnitePay;
    }

    public void setIsUnitePay(String isUnitePay) {
        this.isUnitePay = isUnitePay;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<GoodsPrcInfo> getGoodsPrcInfoList() {
        return goodsPrcInfoList;
    }

    public void setGoodsPrcInfoList(List<GoodsPrcInfo> goodsPrcInfoList) {
        this.goodsPrcInfoList = goodsPrcInfoList;
    }

    public List<GoodsPrcInfo> getShareInfoList() {
        return shareInfoList;
    }

    public void setShareInfoList(List<GoodsPrcInfo> shareInfoList) {
        this.shareInfoList = shareInfoList;
    }
}
