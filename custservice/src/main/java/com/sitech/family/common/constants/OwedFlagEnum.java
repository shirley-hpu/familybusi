package com.sitech.family.common.constants;

/**
 * 	催欠标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum OwedFlagEnum {

    VAL_Y("Y", "可催"),
    VAL_N("N", "不可催");

    private String value;
    private String label;

    OwedFlagEnum(String value, String label) {
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
