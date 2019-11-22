package com.sitech.family.common.constants;

/**
 * 停机标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum StopFlagEnum {

    VAL_Y("Y", "普通停机"),
    VAL_N("N", "不可停"),
    VAL_P("P", "协议停机");

    private String value;
    private String label;

    StopFlagEnum(String value, String label) {
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
