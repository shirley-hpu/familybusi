package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/9/17 21:15
 */
public class FamilyBillInDto implements Serializable {

    @JSONField(name="ID_NO")
    private String idNo;
    @JSONField(name="CONTRACT_NO")
    private String contractNo;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Override
    public String toString() {
        return "FamilyBillInDto{" +
                "idNo='" + idNo + '\'' +
                ", contractNo='" + contractNo + '\'' +
                '}';
    }
}
