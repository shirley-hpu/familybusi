package com.sitech.preservice.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/5/30 16:57
 */
public class ReturnOutDto implements Serializable {

    @JSONField(name = "RETURN_MSG")
    private String RtnMsg;

    @JSONField(name = "RETURN_CODE")
    private String RtnCode;


    public String getRtnMsg() {
        return RtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        RtnMsg = rtnMsg;
    }

    public String getRtnCode() {
        return RtnCode;
    }

    public void setRtnCode(String rtnCode) {
        RtnCode = rtnCode;
    }

    @Override
    public String toString() {
        return "ReturnOutDto{" +
                "RtnMsg='" + RtnMsg + '\'' +
                ", RtnCode='" + RtnCode + '\'' +
                '}';
    }
}
