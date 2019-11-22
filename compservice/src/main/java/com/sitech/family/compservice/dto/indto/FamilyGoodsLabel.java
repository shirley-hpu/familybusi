package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/4/1 17:47
 */
public class FamilyGoodsLabel implements Serializable {

    @JSONField(name = "LABEL_ID")
    @NotBlank(message = "LABEL_ID不能为空")
    private String labelId;

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "FamilyGoodsLabel{" +
                "labelId='" + labelId + '\'' +
                '}';
    }
}
