package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2018/12/15.
 */
public class PhoneNoPreemptInDto {

    @NotBlank(message = "160005$操作号码不能为空")
    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    @NotBlank(message = "160006$操作类型不能为空")
    @JSONField(name = "OPR_TYPE")
    public String  oprType;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOprType() {
        return oprType;
    }

    public void setOprType(String oprType) {
        this.oprType = oprType;
    }

    @Override
    public String toString() {
        return "PhoneNoPreemptInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", oprType='" + oprType + '\'' +
                '}';
    }

}
