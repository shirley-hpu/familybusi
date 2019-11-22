package com.sitech.family.common.constants;

/**
 * 是否主体标识
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum MainFlagEnum {

    VAL_0("0", "主"),
    VAL_1("1", "附");

    private String value;
    private String label;

    MainFlagEnum(String value, String label) {
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
