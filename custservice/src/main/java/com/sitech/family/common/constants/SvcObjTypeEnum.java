package com.sitech.family.common.constants;

/**
 * 服务对象类型
 */
public enum SvcObjTypeEnum {

    VAL_1("1", "用户"),
    VAL_2("2", "账户"),
    VAL_3("3", "客户");

    private String value;
    private String label;

    SvcObjTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
