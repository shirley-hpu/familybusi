package com.sitech.family.common.pubdto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author wusm
 * @description
 * @date 2019/3/28 16:08
 */
public class FamilyMbrAdd implements Serializable {

    @JSONField(name = "MEMBER_ID")
    @NotBlank(message = "入参MEMBER_ID不能为空")
    @ApiModelProperty(value = "成员标识", name = "memberId")
    private String memberId;

    @JSONField(name = "REL_MEMBER_ID")
    @ApiModelProperty(value = "关联成员标识", name = "relMemberId")
    private String relMemberId;

    @JSONField(name = "GROUP_ID")
    @NotBlank(message = "入参GROUP_ID不能为空")
    @ApiModelProperty(value = "群实例标识", name = "groupId", required = true)
    private String groupId;

    @JSONField(name = "ROLE_ID")
    @NotBlank(message = "入参ROLE_ID不能为空")
    @ApiModelProperty(value = "成员角色大类", name = "roleId", required = true)
    private String roleId;

    @JSONField(name = "MEMBER_ROLE_ID")
    @NotBlank(message = "入参MEMBER_ROLE_ID不能为空")
    @ApiModelProperty(value = "群组成员类别角色标识", name = "memberRoleId", required = true)
    private String memberRoleId;

    @JSONField(name = "OBJECT_TYPE")
    @NotBlank(message = "入参OBJECT_TYPE不能为空")
    @ApiModelProperty(value = "成员类型", name = "objectType", required = true)
    private String objectType;

    @JSONField(name = "OBJECT_ID")
    @NotBlank(message = "入参OBJECT_ID不能为空")
    @ApiModelProperty(value = "成员号码", name = "objectId", required = true)
    private String objectId;

    @JSONField(name = "MEMBER_DESC")
    @NotBlank(message = "入参MEMBER_DESC不能为空")
    @ApiModelProperty(value = "群成员描述", name = "memberDesc", required = true)
    private String memberDesc;

    @JSONField(name = "MEMBER_NAME")
    @NotBlank(message = "入参MEMBER_NAME不能为空")
    @ApiModelProperty(value = "成员名称", name = "memberName", required = true)
    private String memberName;

    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "入参EFF_DATE不能为空")
    @ApiModelProperty(value = "生效日期", name = "effDate", required = true)
    private String effDate;

    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "入参EXP_DATE不能为空")
    @ApiModelProperty(value = "失效日期", name = "expDate", required = true)
    private String expDate;

    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "入参PHONE_NO不能为空")
    @ApiModelProperty(value = "成员服务号码", name = "phoneNo", required = true)
    private String phoneNo;

    @Valid
    @JSONField(name = "USERGROUPMBRGOODSINFOLIST")
    @ApiModelProperty(value = "订购实例与成员实例关系list节点", name = "familyUserPrcMbrInsList")
    private List<FamilyUserPrcMbrIns> familyUserPrcMbrInsList;

    @Valid
    @JSONField(name = "USERGROUPMBRATTRINFOLIST")
    @ApiModelProperty(value = "家庭群成员属性list节点", name = "familyUserGroupMbrAttrList")
    private List<FamilyUserGroupMbrAttr> familyUserGroupMbrAttrList;

    @Valid
    @JSONField(name = "CONUSRRELINFOLIST")
    @ApiModelProperty(value = "家庭付费关系list节点", name = "familyConUsrrelList")
    private List<FamilyConUserrel> familyConUsrrelList;

    public static class FamilyUserPrcMbrIns implements Serializable {

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        @ApiModelProperty(value = "失效日期", name = "expDate", required = true)
        private String expDate;

        @JSONField(name = "PRODPRCINS_ID")
        @NotBlank(message = "入参PRODPRCINS_ID不能为空")
        @ApiModelProperty(value = "资费实资费实例标识", name = "prodprcinsId", required = true)
        private String prodprcinsId;

        @JSONField(name = "MAIN_FLAG")
        @ApiModelProperty(value = "是否主体商品订购实例", name = "mainFlag", required = true)
        private String mainFlag;

        @JSONField(name = "SVC_ID")
        @ApiModelProperty(value = "服务标识", name = "svcId", required = true)
        private String svcId;

        @JSONField(name = "PROD_ID")
        @ApiModelProperty(value = "产品标识", name = "prodId", required = true)
        private String prodId;

        @JSONField(name = "GOODS_ID")
        @ApiModelProperty(value = "商品标识", name = "goodsId", required = true)
        private String goodsId;

        @JSONField(name = "PRC_ID")
        @ApiModelProperty(value = "定价标识", name = "prcId", required = true)
        private String prcId;

        @JSONField(name = "EFF_DATE")
        @ApiModelProperty(value = "生效时间", name = "effDate", required = true)
        private String effDate;

        @Valid
        @JSONField(name = "USERGROUPMBRGOODSATTRINFOLIST")
        @ApiModelProperty(value = "商品订购实例属性list节点", name = "familyMbrPrcAttrMidList")
        private List<FamilyMbrPrcAttrMid> familyMbrPrcAttrMidList;

        @Valid
        @JSONField(name = "USERGROUPMBRSVCATTRINFOLIST")
        @ApiModelProperty(value = "服务订购实例属性list节点", name = "familyMbrSvcAttrMidList")
        private List<FamilyMbrSvcAttrMid> familyMbrSvcAttrMidList;

        public String getExpDate() {
            return expDate;
        }

        public void setExpDate(String expDate) {
            this.expDate = expDate;
        }

        public String getProdprcinsId() {
            return prodprcinsId;
        }

        public void setProdprcinsId(String prodprcinsId) {
            this.prodprcinsId = prodprcinsId;
        }

        public String getMainFlag() {
            return mainFlag;
        }

        public void setMainFlag(String mainFlag) {
            this.mainFlag = mainFlag;
        }

        public String getSvcId() {
            return svcId;
        }

        public void setSvcId(String svcId) {
            this.svcId = svcId;
        }

        public String getProdId() {
            return prodId;
        }

        public void setProdId(String prodId) {
            this.prodId = prodId;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getPrcId() {
            return prcId;
        }

        public void setPrcId(String prcId) {
            this.prcId = prcId;
        }

        public String getEffDate() {
            return effDate;
        }

        public void setEffDate(String effDate) {
            this.effDate = effDate;
        }

        public List<FamilyMbrPrcAttrMid> getFamilyMbrPrcAttrMidList() {
            return familyMbrPrcAttrMidList;
        }

        public void setFamilyMbrPrcAttrMidList(List<FamilyMbrPrcAttrMid> familyMbrPrcAttrMidList) {
            this.familyMbrPrcAttrMidList = familyMbrPrcAttrMidList;
        }

        public List<FamilyMbrSvcAttrMid> getFamilyMbrSvcAttrMidList() {
            return familyMbrSvcAttrMidList;
        }

        public void setFamilyMbrSvcAttrMidList(List<FamilyMbrSvcAttrMid> familyMbrSvcAttrMidList) {
            this.familyMbrSvcAttrMidList = familyMbrSvcAttrMidList;
        }

        @Override
        public String toString() {
            return "FamilyUserPrcMbrIns{" +
                    "expDate='" + expDate + '\'' +
                    ", prodprcinsId='" + prodprcinsId + '\'' +
                    ", mainFlag='" + mainFlag + '\'' +
                    ", svcId='" + svcId + '\'' +
                    ", prodId='" + prodId + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", prcId='" + prcId + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", familyMbrPrcAttrMidList=" + familyMbrPrcAttrMidList +
                    ", familyMbrSvcAttrMidList=" + familyMbrSvcAttrMidList +
                    '}';
        }
    }

    public static class FamilyUserGroupMbrAttr implements Serializable {

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "入参EFF_DATE不能为空")
        @ApiModelProperty(value = "生效日期", name = "effDate", required = true)
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        @ApiModelProperty(value = "失效日期", name = "expDate", required = true)
        private String expDate;

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "入参ATTR_ID不能为空")
        @ApiModelProperty(value = "属性标识", name = "attrId", required = true)
        private String attrId;

        @JSONField(name = "ATTR_NO")
        @NotBlank(message = "入参ATTR_NO不能为空")
        @ApiModelProperty(value = "属性序号", name = "attrNo", required = true)
        private String attrNo;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "入参ATTR_VALUE不能为空")
        @ApiModelProperty(value = "属性取值", name = "attrValue", required = true)
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "入参GRP_NO不能为空")
        @ApiModelProperty(value = "组号", name = "grpNo", required = true)
        private String grpNo;

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

        public String getAttrId() {
            return attrId;
        }

        public void setAttrId(String attrId) {
            this.attrId = attrId;
        }

        public String getAttrNo() {
            return attrNo;
        }

        public void setAttrNo(String attrNo) {
            this.attrNo = attrNo;
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
            return "FamilyUserGroupMbrAttr{" +
                    "effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public static class FamilyConUserrel implements Serializable {

        @JSONField(name = "CONTRACT_NO")
        @NotBlank(message = "入参CONTRACT_NO不能为空")
        @ApiModelProperty(value = "账户标识", name = "contractNo", required = true)
        private String contractNo;

        @JSONField(name = "PAY_TYPE")
        @NotBlank(message = "入参PAY_TYPE不能为空")
        @ApiModelProperty(value = "付费类型", name = "payType", required = true)
        private String payType;

        @JSONField(name = "PAY_VALUE")
        @NotBlank(message = "入参PAY_VALUE不能为空")
        @ApiModelProperty(value = "付费数值", name = "payValue", required = true)
        private String payValue;

        @JSONField(name = "CYCLE_TYPE")
        @NotBlank(message = "入参CYCLE_TYPE不能为空")
        @ApiModelProperty(value = "周期类型", name = "cycleType", required = true)
        private String cycleType;

        @JSONField(name = "DATE_CYCLE")
        @NotBlank(message = "入参DATE_CYCLE不能为空")
        @ApiModelProperty(value = "有效周期", name = "attrValue", required = true)
        private String dateCycle;

        @JSONField(name = "RATE_FLAG")
        @NotBlank(message = "入参RATE_FLAG不能为空")
        @ApiModelProperty(value = "是否按明细付费", name = "rateFlag", required = true)
        private String rateFlag;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "入参EFF_DATE不能为空")
        @ApiModelProperty(value = "生效时间", name = "effDate", required = true)
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        @ApiModelProperty(value = "失效时间", name = "expDate", required = true)
        private String expDate;

        @Valid
        @JSONField(name = "CONUSERRATEINFOLIST")
        @ApiModelProperty(value = "家庭付费明细list节点", name = "familyConUserRateList")
        private List<FamilyConUserRate> familyConUserRateList;

        public String getContractNo() {
            return contractNo;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPayValue() {
            return payValue;
        }

        public void setPayValue(String payValue) {
            this.payValue = payValue;
        }

        public String getCycleType() {
            return cycleType;
        }

        public void setCycleType(String cycleType) {
            this.cycleType = cycleType;
        }

        public String getDateCycle() {
            return dateCycle;
        }

        public void setDateCycle(String dateCycle) {
            this.dateCycle = dateCycle;
        }

        public String getRateFlag() {
            return rateFlag;
        }

        public void setRateFlag(String rateFlag) {
            this.rateFlag = rateFlag;
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

        public List<FamilyConUserRate> getFamilyConUserRateList() {
            return familyConUserRateList;
        }

        public void setFamilyConUserRateList(List<FamilyConUserRate> familyConUserRateList) {
            this.familyConUserRateList = familyConUserRateList;
        }

        @Override
        public String toString() {
            return "FamilyConUserrel{" +
                    "contractNo='" + contractNo + '\'' +
                    ", payType='" + payType + '\'' +
                    ", payValue='" + payValue + '\'' +
                    ", cycleType='" + cycleType + '\'' +
                    ", dateCycle='" + dateCycle + '\'' +
                    ", rateFlag='" + rateFlag + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", familyConUserRateList=" + familyConUserRateList +
                    '}';
        }
    }

    public static class FamilyConUserRate implements Serializable {

        @JSONField(name = "FEE_CODE")
        @NotBlank(message = "入参FEE_CODE不能为空")
        @ApiModelProperty(value = "费用代码", name = "feeCode", required = true)
        private String feeCode;

        @JSONField(name = "DETAIL_CODE")
        @NotBlank(message = "入参DETAIL_CODE不能为空")
        @ApiModelProperty(value = "费用明细", name = "detailCode", required = true)
        private String detailCode;

        @JSONField(name = "RATE_BILL_ORDER")
        @NotBlank(message = "入参RATE_BILL_ORDER不能为空")
        @ApiModelProperty(value = "付费明细冲销顺序", name = "rateBillOrder", required = true)
        private String rateBillOrder;

        @JSONField(name = "FEE_RATE")
        @NotBlank(message = "入参FEE_RATE不能为空")
        @ApiModelProperty(value = "付费比例", name = "feeRate", required = true)
        private String feeRate;

        @JSONField(name = "FEE_VALUE")
        @NotBlank(message = "入参FEE_VALUE不能为空")
        @ApiModelProperty(value = "付费金额", name = "feeValue", required = true)
        private String feeValue;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "入参EFF_DATE不能为空")
        @ApiModelProperty(value = "生效时间", name = "effDate", required = true)
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        @ApiModelProperty(value = "失效时间", name = "expDate", required = true)
        private String expDate;

        public String getFeeCode() {
            return feeCode;
        }

        public void setFeeCode(String feeCode) {
            this.feeCode = feeCode;
        }

        public String getDetailCode() {
            return detailCode;
        }

        public void setDetailCode(String detailCode) {
            this.detailCode = detailCode;
        }

        public String getRateBillOrder() {
            return rateBillOrder;
        }

        public void setRateBillOrder(String rateBillOrder) {
            this.rateBillOrder = rateBillOrder;
        }

        public String getFeeRate() {
            return feeRate;
        }

        public void setFeeRate(String feeRate) {
            this.feeRate = feeRate;
        }

        public String getFeeValue() {
            return feeValue;
        }

        public void setFeeValue(String feeValue) {
            this.feeValue = feeValue;
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

        @Override
        public String toString() {
            return "FamilyConUserRate{" +
                    "feeCode='" + feeCode + '\'' +
                    ", detailCode='" + detailCode + '\'' +
                    ", rateBillOrder='" + rateBillOrder + '\'' +
                    ", feeRate='" + feeRate + '\'' +
                    ", feeValue='" + feeValue + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    '}';
        }
    }

    public static class FamilyMbrPrcAttrMid implements Serializable {

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "入参ATTR_ID不能为空")
        @ApiModelProperty(value = "属性标识", name = "attrId", required = true)
        private String attrId;

        @JSONField(name = "ATTR_NO")
        @NotBlank(message = "入参ATTR_NO不能为空")
        @ApiModelProperty(value = "属性序号", name = "attrNo", required = true)
        private String attrNo;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "入参ATTR_VALUE不能为空")
        @ApiModelProperty(value = "属性值", name = "attrValue", required = true)
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "入参GRP_NO不能为空")
        @ApiModelProperty(value = "组号", name = "grpNo", required = true)
        private String grpNo;

        public String getAttrId() {
            return attrId;
        }

        public void setAttrId(String attrId) {
            this.attrId = attrId;
        }

        public String getAttrNo() {
            return attrNo;
        }

        public void setAttrNo(String attrNo) {
            this.attrNo = attrNo;
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
            return "FamilyMbrPrcAttrMid{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public static class FamilyMbrSvcAttrMid implements Serializable {

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "入参ATTR_ID不能为空")
        @ApiModelProperty(value = "属性标识", name = "attrId", required = true)
        private String attrId;

        @JSONField(name = "ATTR_NO")
        @NotBlank(message = "入参ATTR_NO不能为空")
        @ApiModelProperty(value = "属性序号", name = "attrNo", required = true)
        private String attrNo;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "入参ATTR_VALUE不能为空")
        @ApiModelProperty(value = "属性值", name = "attrValue", required = true)
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "入参GRP_NO不能为空")
        @ApiModelProperty(value = "组号", name = "grpNo", required = true)
        private String grpNo;

        public String getAttrId() {
            return attrId;
        }

        public void setAttrId(String attrId) {
            this.attrId = attrId;
        }

        public String getAttrNo() {
            return attrNo;
        }

        public void setAttrNo(String attrNo) {
            this.attrNo = attrNo;
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
            return "FamilyMbrSvcAttrMid{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRelMemberId() {
        return relMemberId;
    }

    public void setRelMemberId(String relMemberId) {
        this.relMemberId = relMemberId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<FamilyUserPrcMbrIns> getFamilyUserPrcMbrInsList() {
        return familyUserPrcMbrInsList;
    }

    public void setFamilyUserPrcMbrInsList(List<FamilyUserPrcMbrIns> familyUserPrcMbrInsList) {
        this.familyUserPrcMbrInsList = familyUserPrcMbrInsList;
    }

    public List<FamilyUserGroupMbrAttr> getFamilyUserGroupMbrAttrList() {
        return familyUserGroupMbrAttrList;
    }

    public void setFamilyUserGroupMbrAttrList(List<FamilyUserGroupMbrAttr> familyUserGroupMbrAttrList) {
        this.familyUserGroupMbrAttrList = familyUserGroupMbrAttrList;
    }

    public List<FamilyConUserrel> getFamilyConUsrrelList() {
        return familyConUsrrelList;
    }

    public void setFamilyConUsrrelList(List<FamilyConUserrel> familyConUsrrelList) {
        this.familyConUsrrelList = familyConUsrrelList;
    }

    @Override
    public String toString() {
        return "FamilyMbrAdd{" +
                "memberId='" + memberId + '\'' +
                ", relMemberId='" + relMemberId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", memberRoleId='" + memberRoleId + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", memberDesc='" + memberDesc + '\'' +
                ", memberName='" + memberName + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", familyUserPrcMbrInsList=" + familyUserPrcMbrInsList +
                ", familyUserGroupMbrAttrList=" + familyUserGroupMbrAttrList +
                ", familyConUsrrelList=" + familyConUsrrelList +
                '}';
    }
}
