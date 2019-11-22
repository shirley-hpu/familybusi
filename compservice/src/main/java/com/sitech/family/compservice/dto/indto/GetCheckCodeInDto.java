package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * @author stan
 * @Description  获取验证码
 * @date 2019/01/21
 */
public class GetCheckCodeInDto {


    @NotBlank(message = "160008$服务号码不能为空")
    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    @NotBlank(message = "160010$认证类型不能为空")
    @JSONField(name = "PWD_TYPE")
    public String  pwdType;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType;
    }

    @Override
    public String toString() {
        return "GetCheckCodeInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", pwdType='" + pwdType + '\'' +
                '}';
    }
}
