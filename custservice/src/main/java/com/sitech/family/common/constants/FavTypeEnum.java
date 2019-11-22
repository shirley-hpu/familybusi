package com.sitech.family.common.constants;

/**
 * 优惠类型
 */
public enum FavTypeEnum {

    VAL_1("1", "折扣"),
    VAL_2("2", "直降"),
    VAL_3("3", "赠送(费用、语音、流量等非功能性业务)"),
    VAL_4("4", "优惠券");

    private String value;
    private String label;

    FavTypeEnum(String value, String label) {
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
