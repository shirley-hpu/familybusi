package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * @author guanqp
 * @Description  验证码校验
 * @date 2019/1/21 16:48
 */
public class CheckCodeInDto {

    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    @JSONField(name = "ID_NO")
    public String  idNo;

    @NotBlank(message = "160013$认证类型不能为空")
    @JSONField(name = "PWD_TYPE")
    public String  pwdType;

    @NotBlank(message = "160014$验证码内容不能为空")
    @JSONField(name = "CHK_PWD")
    public String  chkPwd;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType;
    }

    public String getChkPwd() {
        return chkPwd;
    }

    public void setChkPwd(String chkPwd) {
        this.chkPwd = chkPwd;
    }

    @Override
    public String toString() {
        return "CheckCodeInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", idNo='" + idNo + '\'' +
                ", pwdType='" + pwdType + '\'' +
                ", chkPwd='" + chkPwd + '\'' +
                '}';
    }
}
