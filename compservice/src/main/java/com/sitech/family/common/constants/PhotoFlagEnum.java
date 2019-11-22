package com.sitech.family.common.constants;

/**
 * 拍照标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum PhotoFlagEnum {

    VAL_N("N", "非拍照"),
    VAL_Y("Y", "拍照");

    private String value;
    private String label;

    PhotoFlagEnum(String value, String label) {
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
