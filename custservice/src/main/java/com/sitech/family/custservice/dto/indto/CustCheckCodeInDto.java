package com.sitech.family.custservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author guanqp
 * @Description  验证码入参
 * @date 2019/3/28 10:41
 */
public class CustCheckCodeInDto implements Serializable {

    @JSONField(name = "CHECK_CODE")
    @NotBlank(message = "入参CHECK_CODE不能为空")
    private String checkCode;

    @JSONField(name = "EFFECTIVE_TIME")
    private String effectiveTime;

    @JSONField(name = "PHONE_NO")
    @NotBlank(message = "入参PHONE_NO不能为空")
    private String phoneNo;

    @JSONField(name = "OP_TIME")
    @NotBlank(message = "入参OP_TIME不能为空")
    private String opTime;

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    @Override
    public String toString() {
        return "CustCheckCodeInDto{" +
                "checkCode='" + checkCode + '\'' +
                ", effectiveTime='" + effectiveTime + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", opTime='" + opTime + '\'' +
                '}';
    }
}
