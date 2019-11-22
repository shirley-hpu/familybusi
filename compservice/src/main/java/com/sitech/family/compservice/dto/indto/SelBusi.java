package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  主资费校验indto
 * @date 2019/3/12 15:36
 */
public class SelBusi implements Serializable {

    @NotBlank(message = "160024$商品ID不能为空")
    @JSONField(name = "GOODS_ID")
    public String  goodId;

    @NotBlank(message = "160025$定价ID不能为空")
    @JSONField(name = "PRC_ID")
    public String  prcId;

    @NotBlank(message = "160026$生效时间不能为空")
    @JSONField(name = "EFF_DATE")
    public String  effDate;

    @NotBlank(message = "160027$失效时间不能为空")
    @JSONField(name = "EXP_DATE")
    public String  expDate;

    @NotBlank(message = "160028$操作类型不能为空")
    @JSONField(name = "OP_TYPE")
    public String opType;

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
        return "SelBusi{" +
                "goodId='" + goodId + '\'' +
                ", prcId='" + prcId + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", opType='" + opType + '\'' +
                '}';
    }
}
