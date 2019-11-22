package com.sitech.family.common.pubdto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户资料落地 入参实体
 *
 * @author shirley
 * @String created in 2019/3/21
 */
public class FamilyUserApplyInfo implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JSONField(name = "ID_NO")
    @NotBlank(message = "15000$用户ID不能为空")
    @ApiModelProperty(name = "ID_NO", value = "用户ID", required = true, example = "10086")
    private String idNo;
    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "15000$服务号码不能为空")
    @ApiModelProperty(name = "PHONE_NO", value = "服务号码", required = true, example = "10086")
    private String phoneNo;
    @JSONField(name = "CONTRACT_NO")
    @NotBlank(message = "15000$默认帐户标识不能为空")
    @ApiModelProperty(name = "CONTRACT_NO", value = "默认帐户标识", required = true, example = "10086")
    private String contractNo;
    @JSONField(name = "CUST_ID")
    @NotBlank(message = "15000$客户标识不能为空")
    @ApiModelProperty(name = "CUST_ID", value = "客户标识", required = true, example = "10086")
    private String custId;
    @JSONField(name = "EMP_ID")
    @ApiModelProperty(name = "EMP_ID", value = "推荐人", example = "10086")
    private String empId;
    @JSONField(name = "EMP_GROUP")
    @ApiModelProperty(name = "PHONE_NO", value = "推荐人归属", example = "10086")
    private String empGroup;
    @Valid
    @JSONField(name = "USERGROUPINFO")
    @NotNull(message = "15000$用户群信息节点不能为空")
    @ApiModelProperty(name = "compx", value = "用户群信息节点", required = true)
    private FamilyUserGroupInfo familyUserGroupInfo;
    @Valid
    @JSONField(name = "USERGOODSINFOLIST")
    @NotNull(message = "15000$商品订购信息节点不能为空")
    @ApiModelProperty(name = "compx", value = "商品订购信息节点", required = true)
    private List<FamilyUserGoodsInfo> familyUserGoodsInfo;
    @Valid
    @JSONField(name = "USERFAVINFOLIST")
    @NotNull(message = "15000$优惠订购实例信息节点不能为空")
    @ApiModelProperty(name = "compx", value = "优惠订购实例节点", required = true)
    private List<FamilyUserFavInfo> familyUserFavInfo;

    /**
     * 用户优惠订购实例
     */
    public static class FamilyUserFavInfo {
        @JSONField(name = "FAV_ID")
        @NotBlank(message = "15000$优惠标识不能为空")
        @ApiModelProperty(name = "FAV_ID", value = "优惠标识", required = true, example = "1")
        private String favId;

        @JSONField(name = "FAV_TYPE")
        @NotBlank(message = "15000$优惠类型不能为空")
        @ApiModelProperty(name = "FAV_TYPE", value = "优惠类型", required = true, example = "1")
        private String favType;

        @JSONField(name = "FAV_TEMPID")
        @NotBlank(message = "15000$优惠模板ID不能为空")
        @ApiModelProperty(name = "FAV_TEMPID", value = "优惠模板ID", required = true, example = "1")
        private String favtempId;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "15000$生效日期不能为空")
        @ApiModelProperty(name = "EFF_DATE", value = "生效日期", required = true, example = "10086")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "15000$失效日期不能为空")
        @ApiModelProperty(name = "EXP_DATE", value = "失效日期", required = true, example = "10086")
        private String expDate;

        @Valid
        @JSONField(name = "USERFAVATTRINFOLIST")
        @NotNull(message = "15000$优惠参数实例信息节点不能为空")
        @ApiModelProperty(name = "compx", value = "优惠参数实例信息节点", required = true)
        private List<FamilyUserFavAttrInfo> familyUserFavAttrInfoList;

        public String getFavId() {
            return favId;
        }

        public void setFavId(String favId) {
            this.favId = favId;
        }

        public String getFavType() {
            return favType;
        }

        public void setFavType(String favType) {
            this.favType = favType;
        }

        public String getFavtempId() {
            return favtempId;
        }

        public void setFavtempId(String favtempId) {
            this.favtempId = favtempId;
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

        public List<FamilyUserFavAttrInfo> getFamilyUserFavAttrInfoList() {
            return familyUserFavAttrInfoList;
        }

        public void setFamilyUserFavAttrInfoList(List<FamilyUserFavAttrInfo> familyUserFavAttrInfoList) {
            this.familyUserFavAttrInfoList = familyUserFavAttrInfoList;
        }

        @Override
        public String toString() {
            return "FamilyUserFavInfo{" +
                    "favId='" + favId + '\'' +
                    ", favType='" + favType + '\'' +
                    ", favtempId='" + favtempId + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", familyUserFavAttrInfoList=" + familyUserFavAttrInfoList +
                    '}';
        }
    }

    /**
     * 用户优惠参数实例
     */
    public static class FamilyUserFavAttrInfo {
        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "15000$优惠参数不能为空")
        @ApiModelProperty(name = "ATTR_ID", value = "优惠参数", required = true, example = "param")
        private String attrId;

        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "15000$优惠参数值不能为空")
        @ApiModelProperty(name = "ATTR_VALUE", value = "优惠参数值", required = true, example = "10086")
        private String attrValue;

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

        @Override
        public String toString() {
            return "FamilyUserFavAttrInfo{" +
                    "attrId='" + attrId + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    '}';
        }
    }

    public static class FamilyUserGroupInfo {
        @JSONField(name = "GROUP_ID")
        @NotBlank(message = "15000$群实例标识不能为空")
        @ApiModelProperty(name = "GROUP_ID", value = "群实例标识", required = true, example = "10086")
        private String groupId;
        @JSONField(name = "GROUP_CODE")
        @NotBlank(message = "15000$群编号不能为空")
        @ApiModelProperty(name = "GROUP_CODE", value = "群编号", required = true, example = "10086")
        private String groupCode;
        @JSONField(name = "GROUP_TYPE")
        @NotBlank(message = "15000$群类型不能为空")
        @ApiModelProperty(name = "GROUP_TYPE", value = "群类型", required = true, example = "10086")
        private String groupType;
        @JSONField(name = "GROUP_NAME")
        @NotBlank(message = "15000$群名称不能为空")
        @ApiModelProperty(name = "GROUP_NAME", value = "群名称", required = true, example = "10086")
        private String groupName;
        @JSONField(name = "GROUP_DESC")
        @NotBlank(message = "15000$群描述不能为空")
        @ApiModelProperty(name = "GROUP_DESC", value = "群描述", required = true, example = "10086")
        private String groupDesc;
        @JSONField(name = "USE_ADDRESS")
        @ApiModelProperty(name = "USE_ADDRESS", value = "使用地址", example = "10086")
        private String userAddress;

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getGroupCode() {
            return groupCode;
        }

        public void setGroupCode(String groupCode) {
            this.groupCode = groupCode;
        }

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

        public String getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        @Override
        public String toString() {
            return "FamilyUserGroupInfo{" +
                    "groupId='" + groupId + '\'' +
                    ", groupCode='" + groupCode + '\'' +
                    ", groupType='" + groupType + '\'' +
                    ", groupName='" + groupName + '\'' +
                    ", groupDesc='" + groupDesc + '\'' +
                    ", userAddress='" + userAddress + '\'' +
                    '}';
        }
    }

    public static class FamilyUserGoodsInfo {
        @JSONField(name = "MAIN_FLAG")
        @NotBlank(message = "15000$是否主体标识不能为空")
        @ApiModelProperty(name = "MAIN_FLAG", value = "是否主体标识", required = true, example = "Y")
        private String mainFlag;
        @JSONField(name = "GOODS_ID")
        //@NotBlank(message = "15000$商品标识不能为空")
        @ApiModelProperty(name = "GOODS_ID", value = "商品标识", required = true, example = "10086")
        private String goodsId;
        @JSONField(name = "PRC_ID")
        //@NotBlank(message = "15000$定价标识不能为空")
        @ApiModelProperty(name = "PRC_ID", value = "定价标识", required = true, example = "10086")
        private String prcId;
        @JSONField(name = "SVC_ID")
        //@NotBlank(message = "15000$服务标识不能为空")
        @ApiModelProperty(name = "SVC_ID", value = "服务标识", required = true, example = "10086")
        private String svcId;
        @JSONField(name = "PROD_ID")
        @NotBlank(message = "15000$产品标识不能为空")
        @ApiModelProperty(name = "PROD_ID", value = "产品标识", required = true, example = "10086")
        private String prodId;
        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "15000$生效日期不能为空")
        @ApiModelProperty(name = "EFF_DATE", value = "生效日期", required = true, example = "10086")
        private String effDate;
        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "15000$失效日期不能为空")
        @ApiModelProperty(name = "EXP_DATE", value = "失效日期", required = true, example = "10086")
        private String expDate;
        @Valid
        @JSONField(name = "USERGOODSATTRINFOLIST")
        @NotNull(message = "15000$商品订购属性信息节点不能为空")
        @ApiModelProperty(name = "compx", value = "商品订购属性信息节点", required = true)
        private List<FamilyUserGoodsAttrInfo> familyUserGoodsAttrInfoList;
        @Valid
        @JSONField(name = "USERSVCATTRINFOLIST")
        @NotNull(message = "15000$服务订购属性信息节点不能为空")
        @ApiModelProperty(name = "compx", value = "服务订购属性信息节点", required = true)
        private List<FamilyUserSvcAttrInfo> familyUserSvcAttrInfoList;

        public String getMainFlag() {
            return mainFlag;
        }

        public void setMainFlag(String mainFlag) {
            this.mainFlag = mainFlag;
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

        public List<FamilyUserGoodsAttrInfo> getFamilyUserGoodsAttrInfoList() {
            return familyUserGoodsAttrInfoList;
        }

        public void setFamilyUserGoodsAttrInfoList(List<FamilyUserGoodsAttrInfo> familyUserGoodsAttrInfoList) {
            this.familyUserGoodsAttrInfoList = familyUserGoodsAttrInfoList;
        }

        public List<FamilyUserSvcAttrInfo> getFamilyUserSvcAttrInfoList() {
            return familyUserSvcAttrInfoList;
        }

        public void setFamilyUserSvcAttrInfoList(List<FamilyUserSvcAttrInfo> familyUserSvcAttrInfoList) {
            this.familyUserSvcAttrInfoList = familyUserSvcAttrInfoList;
        }

        @Override
        public String toString() {
            return "FamilyUserGoodsInfo{" +
                    "mainFlag='" + mainFlag + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", prcId='" + prcId + '\'' +
                    ", svcId='" + svcId + '\'' +
                    ", prodId='" + prodId + '\'' +
                    ", effDate=" + effDate +
                    ", expDate=" + expDate +
                    ", familyUserGoodsAttrInfoList=" + familyUserGoodsAttrInfoList +
                    ", familyUserSvcAttrInfoList=" + familyUserSvcAttrInfoList +
                    '}';
        }
    }

    public static class FamilyUserGoodsAttrInfo {
        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "15000$属性标识不能为空")
        @ApiModelProperty(name = "ATTR_ID", value = "属性标识", required = true, example = "10086")
        private String attrId;
        @JSONField(name = "ATTR_NO")
        @NotBlank(message = "15000$属性序号不能为空")
        @ApiModelProperty(name = "ATTR_NO", value = "属性序号", required = true, example = "10086")
        private String attrNo;
        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "15000$属性值不能为空")
        @ApiModelProperty(name = "ATTR_VALUE", value = "属性值", required = true, example = "10086")
        private String attrValue;
        @JSONField(name = "GRP_NO")
        @NotBlank(message = "15000$组号不能为空")
        @ApiModelProperty(name = "GRP_NO", value = "组号", required = true, example = "10086")
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
            return "FamilyUserGoodsAttrInfo{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public static class FamilyUserSvcAttrInfo {
        @JSONField(name = "ATTR_ID")
        @NotBlank(message = "15000$属性标识不能为空")
        @ApiModelProperty(name = "ATTR_ID", value = "属性标识", required = true, example = "10086")
        private String attrId;
        @JSONField(name = "ATTR_NO")
        @NotBlank(message = "15000$属性序号不能为空")
        @ApiModelProperty(name = "ATTR_NO", value = "属性序号", required = true, example = "10086")
        private String attrNo;
        @JSONField(name = "ATTR_VALUE")
        @NotBlank(message = "15000$属性值不能为空")
        @ApiModelProperty(name = "ATTR_VALUE", value = "属性值", required = true, example = "10086")
        private String attrValue;
        @JSONField(name = "GRP_NO")
        @NotBlank(message = "15000$组号不能为空")
        @ApiModelProperty(name = "GRP_NO", value = "组号", required = true, example = "10086")
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
            return "FamilyUserSvcAttrInfo{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    '}';
        }
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
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

    public FamilyUserGroupInfo getFamilyUserGroupInfo() {
        return familyUserGroupInfo;
    }

    public void setFamilyUserGroupInfo(FamilyUserGroupInfo familyUserGroupInfo) {
        this.familyUserGroupInfo = familyUserGroupInfo;
    }

    public List<FamilyUserGoodsInfo> getFamilyUserGoodsInfo() {
        return familyUserGoodsInfo;
    }

    public void setFamilyUserGoodsInfo(List<FamilyUserGoodsInfo> familyUserGoodsInfo) {
        this.familyUserGoodsInfo = familyUserGoodsInfo;
    }

    public List<FamilyUserFavInfo> getFamilyUserFavInfo() {
        return familyUserFavInfo;
    }

    public void setFamilyUserFavInfo(List<FamilyUserFavInfo> familyUserFavInfo) {
        this.familyUserFavInfo = familyUserFavInfo;
    }

    @Override
    public String toString() {
        return "FamilyUserApplyInfo{" +
                "idNo='" + idNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", custId='" + custId + '\'' +
                ", empId='" + empId + '\'' +
                ", empGroup='" + empGroup + '\'' +
                ", familyUserGroupInfo=" + familyUserGroupInfo +
                ", familyUserGoodsInfo=" + familyUserGoodsInfo +
                ", familyUserFavInfo=" + familyUserFavInfo +
                '}';
    }
}
