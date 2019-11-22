package com.sitech.family.common.constants;

/**
 * 群组实例标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum GroupFlagEnum {

    VAL_N("N", "非群组用户"),
    VAL_Y("Y", "群组用户");

    private String value;
    private String label;

    GroupFlagEnum(String value, String label) {
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
