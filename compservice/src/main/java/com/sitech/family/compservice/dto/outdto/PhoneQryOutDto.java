package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xuwei on 2018/12/13.
 */
public class PhoneQryOutDto {

    @JSONField(name="PHONE_NO")
    private String phoneNO;

    @JSONField(name="RES_CODE")
    private String resCode;

    @JSONField(name="BIND_FLAG")
    private String bindFlag;

    @JSONField(name="HLR_CODE")
    private String hlrCode;


    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getBindFlag() {
        return bindFlag;
    }

    public void setBindFlag(String bindFlag) {
        this.bindFlag = bindFlag;
    }

    public String getHlrCode() {
        return hlrCode;
    }

    public void setHlrCode(String hlrCode) {
        this.hlrCode = hlrCode;
    }

    @Override
    public String toString() {
        return "PhoneQryOutDto{" +
                "phoneNO='" + phoneNO + '\'' +
                ", resCode='" + resCode + '\'' +
                ", bindFlag='" + bindFlag + '\'' +
                ", hlrCode='" + hlrCode + '\'' +
                '}';
    }
}
