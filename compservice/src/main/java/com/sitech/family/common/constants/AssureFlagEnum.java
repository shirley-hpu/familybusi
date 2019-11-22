package com.sitech.family.common.constants;

/**
 * 担保标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum AssureFlagEnum {

    VAL_0("0", "无担保"),
    VAL_1("1", "有担保客户"),
    VAL_2("2", "担保金");

    private String value;
    private String label;

    AssureFlagEnum(String value, String label) {
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
