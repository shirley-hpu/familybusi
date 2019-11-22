package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 角色信息
 *
 * @author shirley
 * @date 2018/9/27 17:18
 **/
public class FamilyGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "SEL_FLAG")
    private String selFlag;
    @JSONField(name = "ROLE_NAME")
    private String roleName;
    @JSONField(name = "ROLE_ID")
    private String roleId;
    @JSONField(name = "REL_ROLE_ID")
    private String RelRoleId;
    @JSONField(name = "MAX_AMOUNT")
    private Long maxAmount;
    @JSONField(name = "MIN_AMOUNT")
    private Long minAmount;
    @JSONField(name = "MEMBER_ROLE_NAME")
    private String memberRoleName;
    @JSONField(name = "MEMBER_ROLE_ID")
    private String memberRoleId;
    @JSONField(name = "REL_MEMBER_ROLE_ID")
    private String relMemberRoleId;
    @JSONField(name = "OPEN_FLAG")
    private String openFlag;
    @JSONField(name = "MARKET_FLAG")
    private String marketFlag;
    @JSONField(name = "FINISH_FLAG")
    private String finishFlag;
    //商品信息
    @JSONField(name = "GOODSLIST")
    private List<FamilyGoodsOutDto> goodsList;
    //成员商品信息
    @JSONField(name = "MBRGOODSLIST")
    private List<FamilyMbrGoods> mbrGoodsList;
    //成员角色属性
    @JSONField(name = "MBRROLEATTRLIST")
    private List<FamilyMbrRoleAttr> mbrRoleAttrList;

    public String getSelFlag() {
        return selFlag;
    }

    public void setSelFlag(String selFlag) {
        this.selFlag = selFlag;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public String getMemberRoleName() {
        return memberRoleName;
    }

    public void setMemberRoleName(String memberRoleName) {
        this.memberRoleName = memberRoleName;
    }

    public String getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(String memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public String getMarketFlag() {
        return marketFlag;
    }

    public void setMarketFlag(String marketFlag) {
        this.marketFlag = marketFlag;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public List<FamilyGoodsOutDto> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<FamilyGoodsOutDto> goodsList) {
        this.goodsList = goodsList;
    }

    public List<FamilyMbrGoods> getMbrGoodsList() {
        return mbrGoodsList;
    }

    public void setMbrGoodsList(List<FamilyMbrGoods> mbrGoodsList) {
        this.mbrGoodsList = mbrGoodsList;
    }

    public List<FamilyMbrRoleAttr> getMbrRoleAttrList() {
        return mbrRoleAttrList;
    }

    public void setMbrRoleAttrList(List<FamilyMbrRoleAttr> mbrRoleAttrList) {
        this.mbrRoleAttrList = mbrRoleAttrList;
    }

    public String getRelRoleId() {
        return RelRoleId;
    }

    public void setRelRoleId(String relRoleId) {
        RelRoleId = relRoleId;
    }

    public String getRelMemberRoleId() {
        return relMemberRoleId;
    }

    public void setRelMemberRoleId(String relMemberRoleId) {
        this.relMemberRoleId = relMemberRoleId;
    }

    @Override
    public String toString() {
        return "FamilyGroupRole{" +
                "selFlag='" + selFlag + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", RelRoleId='" + RelRoleId + '\'' +
                ", maxAmount=" + maxAmount +
                ", minAmount=" + minAmount +
                ", memberRoleName='" + memberRoleName + '\'' +
                ", memberRoleId='" + memberRoleId + '\'' +
                ", relMemberRoleId='" + relMemberRoleId + '\'' +
                ", openFlag='" + openFlag + '\'' +
                ", marketFlag='" + marketFlag + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", goodsList=" + goodsList +
                ", mbrGoodsList=" + mbrGoodsList +
                ", mbrRoleAttrList=" + mbrRoleAttrList +
                '}';
    }
}
