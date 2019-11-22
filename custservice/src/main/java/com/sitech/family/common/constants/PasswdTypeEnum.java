package com.sitech.family.common.constants;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum PasswdTypeEnum {

    VAL_0("0", "系统自动生成"),
    VAL_1("1", "用户指定");

    private String value;
    private String label;

    PasswdTypeEnum(String value, String label) {
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
