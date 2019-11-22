package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  主资费校验indto
 * @date 2019/3/12 15:39
 */
public class BuyBusi implements Serializable {

    @NotBlank(message = "160029$商品ID不能为空")
    @JSONField(name = "GOODS_ID")
    public String  goodId;

    @NotBlank(message = "160030$生效时间不能为空")
    @JSONField(name = "EFF_DATE")
    public String  effDate;

    @NotBlank(message = "160031$失效时间不能为空")
    @JSONField(name = "EXP_DATE")
    public String  expDate;

    @NotBlank(message = "160032$父级定价ID不能为空")
    @JSONField(name = "PARPRC_ID")
    public String  parPrcId;

    @NotBlank(message = "160033$操作类型不能为空")
    @JSONField(name = "OP_TYPE")
    public String opType;

    @NotBlank(message = "160034$定价ID不能为空")
    @JSONField(name = "PRC_ID")
    public String  prcId;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
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

    public String getParPrcId() {
        return parPrcId;
    }

    public void setParPrcId(String parPrcId) {
        this.parPrcId = parPrcId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    @Override
    public String toString() {
        return "BuyBusi{" +
                "goodId='" + goodId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", parPrcId='" + parPrcId + '\'' +
                ", opType='" + opType + '\'' +
                ", prcId='" + prcId + '\'' +
                '}';
    }
}
