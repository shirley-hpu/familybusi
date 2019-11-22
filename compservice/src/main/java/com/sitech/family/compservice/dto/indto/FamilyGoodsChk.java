package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * @author wusm
 * @description 关系校验入参
 * @date 2018/9/28 16:01
 */
public class FamilyGoodsChk implements Serializable {

    @JSONField(name = "ID_NO")
    private String idNo;

    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "入参PHONE_NO不能为空")
    private String phoneNo;

    @JSONField(name = "GOODS_ID")
    @NotBlank(message = "入参GOODS_ID不能为空")
    private String goodsId;

    @JSONField(name = "PRC_ID")
    @NotBlank(message = "入参PRC_ID不能为空")
    private String prcId;

    @JSONField(name = "EFF_DATE")
    @NotBlank(message = "入参EFF_DATE不能为空")
    private String effDate;

    @JSONField(name = "EXP_DATE")
    @NotBlank(message = "入参EXP_DATE不能为空")
    private String expDate;

    @JSONField(name = "OP_TYPE")
    @NotBlank(message = "入参OP_TYPE不能为空")
    private String opType;

    @JSONField(name = "ACTION")
    @NotBlank(message = "入参ACTION不能为空")
    private String action;

    @Valid
    @JSONField(name = "SELINFOLIST")
    private List<FamilySelGoods> familySelGoodsList;

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

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<FamilySelGoods> getFamilySelGoodsList() {
        return familySelGoodsList;
    }

    public void setFamilySelGoodsList(List<FamilySelGoods> familySelGoodsList) {
        this.familySelGoodsList = familySelGoodsList;
    }

    @Override
    public String toString() {
        return "FamilyGoodsChk{" +
                "idNo='" + idNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", opType='" + opType + '\'' +
                ", action='" + action + '\'' +
                ", familySelGoodsList=" + familySelGoodsList +
                '}';
    }

    public static class FamilySelGoods implements Serializable{

        @JSONField(name = "GOODS_ID")
        @NotBlank(message = "入参GOODS_ID不能为空")
        private String goodsId;

        @JSONField(name = "PRC_ID")
        @NotBlank(message = "入参PRC_ID不能为空")
        private String prcId;

        @JSONField(name = "EFF_DATE")
        @NotBlank(message = "入参EFF_DATE不能为空")
        private String effDate;

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        private String expDate;

        @JSONField(name = "OP_TYPE")
        @NotBlank(message = "入参OP_TYPE不能为空")
        private String opType;

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

        public String getOpType() {
            return opType;
        }

        public void setOpType(String opType) {
            this.opType = opType;
        }

        @Override
        public String toString() {
            return "FamilySelGoods{" +
                    "goodsId='" + goodsId + '\'' +
                    ", prcId='" + prcId + '\'' +
                    ", effDate='" + effDate + '\'' +
                    ", expDate='" + expDate + '\'' +
                    ", opType='" + opType + '\'' +
                    '}';
        }
    }
}
