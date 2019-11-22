package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class FamilyMemPrcChg {

    @JSONField(name = "GROUP_ID")
    @NotBlank(message = "GROUP_ID不能为空")
    private String groupId;

    @JSONField(name = "MBRPRCINSCHGLIST")
    private List<MbrPrcInsChgInfo> mbrPrcInsChgInfoList;

    public static class MbrPrcInsChgInfo implements Serializable {

        @JSONField(name = "ID_NO")
        @NotBlank(message = "ID_NO不能为空")
        private String idNo;

        @JSONField(name = "MEMBER_ID")
        @NotBlank(message = "MEMBER_ID不能为空")
        private String memberId;

        @JSONField(name = "MBRPRCINSLIST")
        private List<MbrPrcInsInfo> mbrPrcInsInfoList;

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public List<MbrPrcInsInfo> getMbrPrcInsInfoList() {
            return mbrPrcInsInfoList;
        }

        public void setMbrPrcInsInfoList(List<MbrPrcInsInfo> mbrPrcInsInfoList) {
            this.mbrPrcInsInfoList = mbrPrcInsInfoList;
        }

        @Override
        public String toString() {
            return "MbrPrcInsChgInfo{" +
                    "idNo='" + idNo + '\'' +
                    ", memberId='" + memberId + '\'' +
                    ", mbrPrcInsInfoList=" + mbrPrcInsInfoList +
                    '}';
        }
    }

    public static class MbrPrcInsInfo implements Serializable {

        @JSONField(name = "OPERATE_TYPE")
        @NotBlank(message = "OPERATE_TYPE不能为空")
        private String operateType;

        @JSONField(name = "MAIN_FLAG")
        private String mainFlag;

        @JSONField(name = "MEMBER_FLAG")
        private String memberFlag;

        @JSONField(name = "SVC_ID")
        private String svcId;

        @JSONField(name = "PROD_ID")
        private String prodId;

        @JSONField(name = "GOODS_ID")
        private String goodsId;

        @JSONField(name = "PRC_ID")
        private String prcId;

        @JSONField(name = "EFF_DATE")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "EXP_DATE不能为空")
        private String expDate;

        @JSONField(name = "PRODPRCINS_ID")
        private String prodprcinsId;

        @JSONField(name = "MBRGOODSATTRLIST")
        private List<MbrAttrInfo> mbrGoodsAttrInfoList;

        @JSONField(name = "MBRSVCATTRLIST")
        private List<MbrAttrInfo> mbrSvcAttrInfoList;

        public String getOperateType() {
            return operateType;
        }

        public void setOperateType(String operateType) {
            this.operateType = operateType;
        }

        public String getMainFlag() {
            return mainFlag;
        }

        public void setMainFlag(String mainFlag) {
            this.mainFlag = mainFlag;
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

        public String getProdprcinsId() {
            return prodprcinsId;
        }

        public void setProdprcinsId(String prodprcinsId) {
            this.prodprcinsId = prodprcinsId;
        }

        public List<MbrAttrInfo> getMbrGoodsAttrInfoList() {
            return mbrGoodsAttrInfoList;
        }

        public void setMbrGoodsAttrInfoList(List<MbrAttrInfo> mbrGoodsAttrInfoList) {
            this.mbrGoodsAttrInfoList = mbrGoodsAttrInfoList;
        }

        public List<MbrAttrInfo> getMbrSvcAttrInfoList() {
            return mbrSvcAttrInfoList;
        }

        public void setMbrSvcAttrInfoList(List<MbrAttrInfo> mbrSvcAttrInfoList) {
            this.mbrSvcAttrInfoList = mbrSvcAttrInfoList;
        }

        @Override
        public String toString() {
            return "MbrPrcInsInfo{" +
                    "operateType='" + operateType + '\'' +
                    ", mainFlag='" + mainFlag + '\'' +
                    ", memberFlag='" + memberFlag + '\'' +
                    ", svcId='" + svcId + '\'' +
                    ", prodId='" + prodId + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", prcId='" + prcId + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", prodprcinsId='" + prodprcinsId + '\'' +
                    ", mbrGoodsAttrInfoList=" + mbrGoodsAttrInfoList +
                    ", mbrSvcAttrInfoList=" + mbrSvcAttrInfoList +
                    '}';
        }
    }

    public static class MbrAttrInfo implements Serializable {

        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "ATTR_ID不能为空")
        private String attrId;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "ATTR_VALUE不能为空")
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @NotBlank(message = "GRP_NO不能为空")
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
            return "MbrAttrInfo{" +
                    "attrId='" + attrId + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<MbrPrcInsChgInfo> getMbrPrcInsChgInfoList() {
        return mbrPrcInsChgInfoList;
    }

    public void setMbrPrcInsChgInfoList(List<MbrPrcInsChgInfo> mbrPrcInsChgInfoList) {
        this.mbrPrcInsChgInfoList = mbrPrcInsChgInfoList;
    }

    @Override
    public String toString() {
        return "FamilyMemPrcChg{" +
                "groupId='" + groupId + '\'' +
                ", mbrPrcInsChgInfoList=" + mbrPrcInsChgInfoList +
                '}';
    }
}
