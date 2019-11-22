package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
public class OpenUserInDto {

    @NotBlank(message = "160007$家长手机号码不能为空")
    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "OpenUserInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
