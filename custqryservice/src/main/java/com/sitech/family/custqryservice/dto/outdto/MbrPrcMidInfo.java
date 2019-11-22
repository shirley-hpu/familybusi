package com.sitech.family.custqryservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description 成员订购实例中间表
 * @date 2019/4/17 16:02
 */
public class MbrPrcMidInfo implements Serializable {

    @JSONField(name = "ID_NO")
    private Long idNo;//群用户的ID_NO
    @JSONField(name = "MEMBER_ID")
    private BigDecimal memberId;
    @JSONField(name = "INS_TYPE")
    private String insType;
    @JSONField(name = "INS_VALUE")
    private BigDecimal insValue;
    @JSONField(name = "PARINS_ID")
    private BigDecimal parinsId;
    @JSONField(name = "OTHERINS_ID")
    private BigDecimal otherinsId;
    @JSONField(name = "RELOP_TYPE")
    private String relopType;
    @JSONField(name = "RELATION_TYPE")
    private String relationType;
    @JSONField(name = "RELINS_ID")
    private BigDecimal relinsId;
    @JSONField(name = "MAIN_FLAG")
    private String mainFlag;
    @JSONField(name = "GOODS_ID")
    private String goodsId;
    @JSONField(name = "PRC_ID")
    private String prcId;
    @JSONField(name = "SVC_ID")
    private String svcId;
    @JSONField(name = "PROD_ID")
    private String prodId;
    @JSONField(name = "EFF_DATE")
    private Date effDate;
    @JSONField(name = "EXP_DATE")
    private Date expDate;
    @JSONField(name = "ORDER_DATE")
    private Date orderDate;

    @JSONField(name = "MBRPRCATTRMIDINFOLIST")
    @ApiModelProperty(value = "商品订购实例属性", name = "mbrPrcAttrMidInfoList")
    private List<FamilyMbrPrcAttrMid> mbrPrcAttrMidInfoList;

    @JSONField(name = "MBRSVCATTRMIDINFOLIST")
    @ApiModelProperty(value = "服务订购实例属性", name = "mbrSvcAttrMidInfoList")
    private List<FamilyMbrSvcAttrMid> mbrSvcAttrMidInfoList;


    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public BigDecimal getInsValue() {
        return insValue;
    }

    public void setInsValue(BigDecimal insValue) {
        this.insValue = insValue;
    }

    public BigDecimal getParinsId() {
        return parinsId;
    }

    public void setParinsId(BigDecimal parinsId) {
        this.parinsId = parinsId;
    }

    public BigDecimal getOtherinsId() {
        return otherinsId;
    }

    public void setOtherinsId(BigDecimal otherinsId) {
        this.otherinsId = otherinsId;
    }

    public String getRelopType() {
        return relopType;
    }

    public void setRelopType(String relopType) {
        this.relopType = relopType;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public BigDecimal getRelinsId() {
        return relinsId;
    }

    public void setRelinsId(BigDecimal relinsId) {
        this.relinsId = relinsId;
    }

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<FamilyMbrPrcAttrMid> getMbrPrcAttrMidInfoList() {
        return mbrPrcAttrMidInfoList;
    }

    public void setMbrPrcAttrMidInfoList(List<FamilyMbrPrcAttrMid> mbrPrcAttrMidInfoList) {
        this.mbrPrcAttrMidInfoList = mbrPrcAttrMidInfoList;
    }

    public List<FamilyMbrSvcAttrMid> getMbrSvcAttrMidInfoList() {
        return mbrSvcAttrMidInfoList;
    }

    public void setMbrSvcAttrMidInfoList(List<FamilyMbrSvcAttrMid> mbrSvcAttrMidInfoList) {
        this.mbrSvcAttrMidInfoList = mbrSvcAttrMidInfoList;
    }

    //商品订购属性 && 资费订购属性
    public static class FamilyMbrPrcAttrMid implements Serializable {

        @JSONField(name = "ATTR_ID")
        @ApiModelProperty(value = "属性标识", name = "attrId")
        private String attrId;

        @JSONField(name = "ATTR_NO")
        @ApiModelProperty(value = "属性序号", name = "attrNo")
        private String attrNo;

        @JSONField(name = "ATTR_VALUE")
        @ApiModelProperty(value = "属性值", name = "attrValue")
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @ApiModelProperty(value = "组号", name = "grpNo")
        private String grpNo;

        @JSONField(name = "EFF_DATE")
        @ApiModelProperty(value = "生效时间", name = "effDate")
        private Date effDate;

        @JSONField(name = "EXP_DATE")
        @ApiModelProperty(value = "失效时间", name = "expDate")
        private Date expDate;

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

        @Override
        public String toString() {
            return "FamilyMbrPrcAttrMid{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    ", effDate=" + effDate +
                    ", expDate=" + expDate +
                    '}';
        }
    }

    //服务订购属性
    public static class FamilyMbrSvcAttrMid implements Serializable {

        @JSONField(name = "ATTR_ID")
        @ApiModelProperty(value = "属性标识", name = "attrId")
        private String attrId;

        @JSONField(name = "ATTR_NO")
        @ApiModelProperty(value = "属性序号", name = "attrNo")
        private String attrNo;

        @JSONField(name = "ATTR_VALUE")
        @ApiModelProperty(value = "属性值", name = "attrValue")
        private String attrValue;

        @JSONField(name = "GRP_NO")
        @ApiModelProperty(value = "组号", name = "grpNo")
        private String grpNo;

        @JSONField(name = "EFF_DATE")
        @ApiModelProperty(value = "生效时间", name = "effDate")
        private Date effDate;

        @JSONField(name = "EXP_DATE")
        @ApiModelProperty(value = "失效时间", name = "expDate")
        private Date expDate;

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

        @Override
        public String toString() {
            return "FamilyMbrSvcAttrMid{" +
                    "attrId='" + attrId + '\'' +
                    ", attrNo='" + attrNo + '\'' +
                    ", attrValue='" + attrValue + '\'' +
                    ", grpNo='" + grpNo + '\'' +
                    ", effDate=" + effDate +
                    ", expDate=" + expDate +
                    '}';
        }
    }


}
