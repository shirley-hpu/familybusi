package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  主资费校验outdto
 * @date 2019/3/12 16:45
 */
public class PrcList implements Serializable {

    @JSONField(name = "EFF_DATE")//生效时间
    private String effDate;

    @JSONField(name = "EXP_DATE")//失效时间
    private String expDate;

    @JSONField(name = "LIMIT_FLAG")//校验标识
    private String limitFlag;

    @JSONField(name = "GOODS_ID")//商品ID
    private String goodId;

    @JSONField(name = "PRC_ID")//定价Id
    private String prcId;

    @JSONField(name = "NOTE")//校验信息
    private String note;

    @JSONField(name = "OP_TYPE")//操作类型
    private String opType;

    @JSONField(name = "RELATION_TYPE")//定价关系
    private String relationType;

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

    public String getLimitFlag() {
        return limitFlag;
    }

    public void setLimitFlag(String limitFlag) {
        this.limitFlag = limitFlag;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    @Override
    public String toString() {
        return "PrcList{" +
                "effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", limitFlag='" + limitFlag + '\'' +
                ", goodId='" + goodId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", note='" + note + '\'' +
                ", opType='" + opType + '\'' +
                ", relationType='" + relationType + '\'' +
                '}';
    }
}
