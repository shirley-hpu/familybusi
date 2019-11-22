package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class FamilyMbrMngInDto implements Serializable {

    @JSONField(name = "GROUP_ID")
    @NotBlank(message = "GROUP_ID")
    private String groupId;

    @JSONField(name = "USERGROUPMBRINFOLIST")
    private List<UserGroupMbrInfo> userGroupMbrInfoList;

    public static class UserGroupMbrInfo implements Serializable {

        @JSONField(name = "ROLE_ID")
        @NotBlank(message = "ROLE_ID")
        private String roleId;

        @JSONField(name = "MEMBER_ROLE_ID")
        @NotBlank(message = "MEMBER_ROLE_ID")
        private String memberRoleId;

        @JSONField(name = "OBJECT_TYPE")
        @NotBlank(message = "OBJECT_TYPE")
        private String objectType;

        @JSONField(name = "OBJECT_ID")
        @NotBlank(message = "OBJECT_ID")
        private String objectId;

        @JSONField(name = "ID_NO")
        @NotBlank(message = "ID_NO")
        private String idNo;

        @JSONField(name = "MEMBER_DESC")
        @NotBlank(message = "MEMBER_DESC")
        private String memberDesc;

        @JSONField(name = "MEMBER_NAME")
        @NotBlank(message = "MEMBER_NAME")
        private String memberName;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE")
        private String expDate;

        @JSONField(name = "OPEN_FLAG")
        @NotBlank(message = "OPEN_FLAG")
        private String openFlag;

        @JSONField(name = "FINISH_FLAG")
        @NotBlank(message = "FINISH_FLAG")
        private String finishFlag;

        @JSONField(name = "PHONE_NO")
        @NotBlank(message = "PHONE_NO")
        private String phoneNo;

        @JSONField(name = "USERGROUPMBRATTRINFOLIST")
        private List<UserGroupMbrAttrInfo> userGroupMbrAttrInfoList;

        @JSONField(name = "USERGROUPMBRGOODSINFOLIST")
        private List<UserGroupMbrGoodsInfo> userGroupMbrGoodsInfoList;

        @JSONField(name = "CONUSRRELINFOLIST")
        private List<ConUsrRelInfo> conUsrRelInfoList;

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

        public String getOpenFlag() {
            return openFlag;
        }

        public void setOpenFlag(String openFlag) {
            this.openFlag = openFlag;
        }

        public String getFinishFlag() {
            return finishFlag;
        }

        public void setFinishFlag(String finishFlag) {
            this.finishFlag = finishFlag;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public List<UserGroupMbrAttrInfo> getUserGroupMbrAttrInfoList() {
            return userGroupMbrAttrInfoList;
        }

        public void setUserGroupMbrAttrInfoList(List<UserGroupMbrAttrInfo> userGroupMbrAttrInfoList) {
            this.userGroupMbrAttrInfoList = userGroupMbrAttrInfoList;
        }

        public List<UserGroupMbrGoodsInfo> getUserGroupMbrGoodsInfoList() {
            return userGroupMbrGoodsInfoList;
        }

        public void setUserGroupMbrGoodsInfoList(List<UserGroupMbrGoodsInfo> userGroupMbrGoodsInfoList) {
            this.userGroupMbrGoodsInfoList = userGroupMbrGoodsInfoList;
        }

        public List<ConUsrRelInfo> getConUsrRelInfoList() {
            return conUsrRelInfoList;
        }

        public void setConUsrRelInfoList(List<ConUsrRelInfo> conUsrRelInfoList) {
            this.conUsrRelInfoList = conUsrRelInfoList;
        }

        @Override
        public String toString() {
            return "UserGroupMbrInfo{" +
                    "roleId='" + roleId + '\'' +
                    ", memberRoleId='" + memberRoleId + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", idNo='" + idNo + '\'' +
                    ", memberDesc='" + memberDesc + '\'' +
                    ", memberName='" + memberName + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", openFlag='" + openFlag + '\'' +
                    ", finishFlag='" + finishFlag + '\'' +
                    ", phoneNo='" + phoneNo + '\'' +
                    ", userGroupMbrAttrInfoList=" + userGroupMbrAttrInfoList +
                    ", userGroupMbrGoodsInfoList=" + userGroupMbrGoodsInfoList +
                    ", conUsrRelInfoList=" + conUsrRelInfoList +
                    '}';
        }
    }

    public static class UserGroupMbrAttrInfo implements Serializable {

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE")
        private String expDate;

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "ATTR_ID")
        private String attrId;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "ATTR_VALUE")
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "GRP_NO")
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
            return "UserGroupMbrAttrInfo{" +
                    "effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", attrId='" + attrId + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public static class UserGroupMbrGoodsInfo implements Serializable {

        @JSONField(name = "GOODS_TYPE")
        @NotBlank(message = "GOODS_TYPE")
        private String goodsType;

        @JSONField(name = "MEMBER_FLAG")
        @NotBlank(message = "MEMBER_FLAG")
        private String memberFlag;

        @JSONField(name = "SVC_ID")
        @NotBlank(message = "SVC_ID")
        private String svcId;

        @JSONField(name = "PROD_ID")
        @NotBlank(message = "PROD_ID")
        private String prodId;

        @JSONField(name = "GOODS_ID")
        @NotBlank(message = "GOODS_ID")
        private String goodsId;

        @JSONField(name = "PRC_ID")
        @NotBlank(message = "PRC_ID")
        private String prcId;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE")
        private String expDate;

        @JSONField(name = "USERGROUPMBRGOODSATTRINFOLIST")
        private List<UserGroupMbrAttr> userGroupMbrGoodsAttrInfoList;

        @JSONField(name = "USERGROUPMBRSVCATTRINFOLIST")
        private List<UserGroupMbrAttr> userGroupMbrSvcAttrInfoList;

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public String getMemberFlag() {
            return memberFlag;
        }

        public void setMemberFlag(String memberFlag) {
            this.memberFlag = memberFlag;
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

        public String getExpDate() {
            return expDate;
        }

        public void setExpDate(String expDate) {
            this.expDate = expDate;
        }

        public List<UserGroupMbrAttr> getUserGroupMbrGoodsAttrInfoList() {
            return userGroupMbrGoodsAttrInfoList;
        }

        public void setUserGroupMbrGoodsAttrInfoList(List<UserGroupMbrAttr> userGroupMbrGoodsAttrInfoList) {
            this.userGroupMbrGoodsAttrInfoList = userGroupMbrGoodsAttrInfoList;
        }

        public List<UserGroupMbrAttr> getUserGroupMbrSvcAttrInfoList() {
            return userGroupMbrSvcAttrInfoList;
        }

        public void setUserGroupMbrSvcAttrInfoList(List<UserGroupMbrAttr> userGroupMbrSvcAttrInfoList) {
            this.userGroupMbrSvcAttrInfoList = userGroupMbrSvcAttrInfoList;
        }

        @Override
        public String toString() {
            return "UserGroupMbrGoodsInfo{" +
                    "goodsType='" + goodsType + '\'' +
                    ", memberFlag='" + memberFlag + '\'' +
                    ", svcId='" + svcId + '\'' +
                    ", prodId='" + prodId + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", prcId='" + prcId + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", userGroupMbrGoodsAttrInfoList=" + userGroupMbrGoodsAttrInfoList +
                    ", userGroupMbrSvcAttrInfoList=" + userGroupMbrSvcAttrInfoList +
                    '}';
        }
    }

    public static class UserGroupMbrAttr implements Serializable {

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "ATTR_ID")
        private String attrId;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "ATTR_VALUE")
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "GRP_NO")
        private String grpNo;

        public String getAttrId() {
            return attrId;
        }

        public void setAttrId(String attrId) {
            this.attrId = attrId;
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
            return "UserGroupMbrAttr{" +
                    "attrId='" + attrId + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public static class ConUsrRelInfo implements Serializable {

        @JSONField(name = "CONTRACT_NO")
        @NotBlank(message = "CONTRACT_NO")
        private String contractNo;

        @JSONField(name = "PAY_TYPE")
        @NotBlank(message = "PAY_TYPE")
        private String payType;

        @JSONField(name = "PAY_VALUE")
        @NotBlank(message = "PAY_VALUE")
        private String payValue;

        @JSONField(name = "CYCLE_TYPE")
        @NotBlank(message = "CYCLE_TYPE")
        private String cycleType;

        @JSONField(name = "DATE_CYCLE")
        @NotBlank(message = "DATE_CYCLE")
        private String dateCycle;

        @JSONField(name = "RATE_FLAG")
        @NotBlank(message = "RATE_FLAG")
        private String rateFlag;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE")
        private String expDate;

        @JSONField(name = "CONUSERRATEINFOLIST")
        private List<ConUserRateInfo> conUserRateInfoList;

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

        public List<ConUserRateInfo> getConUserRateInfoList() {
            return conUserRateInfoList;
        }

        public void setConUserRateInfoList(List<ConUserRateInfo> conUserRateInfoList) {
            this.conUserRateInfoList = conUserRateInfoList;
        }

        @Override
        public String toString() {
            return "ConUsrRelInfo{" +
                    "contractNo='" + contractNo + '\'' +
                    ", payType='" + payType + '\'' +
                    ", payValue='" + payValue + '\'' +
                    ", cycleType='" + cycleType + '\'' +
                    ", dateCycle='" + dateCycle + '\'' +
                    ", rateFlag='" + rateFlag + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", conUserRateInfoList=" + conUserRateInfoList +
                    '}';
        }
    }

    public static class ConUserRateInfo implements Serializable {

        @JSONField(name = "FEE_CODE")
        @NotBlank(message = "FEE_CODE")
        private String feeCode;

        @JSONField(name = "DETAIL_CODE")
        @NotBlank(message = "DETAIL_CODE")
        private String detailCode;

        @JSONField(name = "RATE_BILL_ORDER")
        @NotBlank(message = "RATE_BILL_ORDER")
        private String rateBillOrder;

        @JSONField(name = "FEE_RATE")
        @NotBlank(message = "FEE_RATE")
        private String feeRate;

        @JSONField(name = "FEE_VALUE")
        @NotBlank(message = "FEE_VALUE")
        private String feeValue;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE")
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
            return "ConUserRateInfo{" +
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<UserGroupMbrInfo> getUserGroupMbrInfoList() {
        return userGroupMbrInfoList;
    }

    public void setUserGroupMbrInfoList(List<UserGroupMbrInfo> userGroupMbrInfoList) {
        this.userGroupMbrInfoList = userGroupMbrInfoList;
    }

    @Override
    public String toString() {
        return "FamilyMbrMngInDto{" +
                "groupId='" + groupId + '\'' +
                ", userGroupMbrInfoList=" + userGroupMbrInfoList +
                '}';
    }
}
