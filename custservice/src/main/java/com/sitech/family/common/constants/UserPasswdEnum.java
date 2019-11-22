package com.sitech.family.common.constants;

/**
 * 用户密码
 *
 * @author shirley
 * @date created in 2019/5/29
 */
public enum UserPasswdEnum {

    VAL_PASSWD("111111", "0");//密码类型-系统自动生成

    private String value;//用户密码
    private String type;//密码类型

    UserPasswdEnum(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

}
