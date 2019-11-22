package com.sitech.family.dto;

import java.io.Serializable;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2018/12/10
 */
public class ReturnDto implements Serializable {

    /**
     * 返回编码
     * 0-成功，其他-失败
     */
    private String code;

    /**
     * 返回信息描述
     * 错误信息
     */
    private String message;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnDto{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
