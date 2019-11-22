package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * @author guanqp
 * @Description 密码校验服务
 * @date 2019/1/22 13:39
 */
public class CheckPassWordInDto {
    @NotBlank(message = "160015$家长手机号码不能为空")
    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    @NotBlank(message = "160016$用户密码不能为空")
    @JSONField(name = "USER_PASSWD")
    public String  userPasswd;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public String toString() {
        return "CheckPassWordInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }
}
