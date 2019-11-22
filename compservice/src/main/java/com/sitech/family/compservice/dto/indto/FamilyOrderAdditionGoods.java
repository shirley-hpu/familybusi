package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-20 10:09
 * @Version: 1.0
 */
public class FamilyOrderAdditionGoods implements Serializable {

    @JSONField(name = "ID_NO")
    @NotBlank(message = "ID_NO不能为空")
    private String idNo;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Override
    public String toString() {
        return "FamilyOrderAdditionGoods{" +
                "idNo='" + idNo + '\'' +
                '}';
    }
}
