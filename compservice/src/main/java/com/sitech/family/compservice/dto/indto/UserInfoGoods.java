package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserInfoGoods implements Serializable {

    @JSONField(name = "PHONE_NO")
    private String phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "UserInfoGoods{" +
                "phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
