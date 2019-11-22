package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-25 15:06
 * @Version: 1.0
 */
public class FamilyOrderPrcAttr implements Serializable {

    @JSONField(name = "ID_NO")
    @NotBlank(message = "ID_NO不能为空")
    private String idNo;

    @JSONField(name = "PRC_ID")
    @NotBlank(message = "PRC_ID不能为空")
    private String prcId;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    @Override
    public String toString() {
        return "FamilyOrderPrcAttr{" +
                "idNo='" + idNo + '\'' +
                ", prcId='" + prcId + '\'' +
                '}';
    }
}
