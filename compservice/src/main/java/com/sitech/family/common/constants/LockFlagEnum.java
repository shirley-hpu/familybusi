package com.sitech.family.common.constants;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/4/17
 */
public enum LockFlagEnum {

    VAL_0("0", "正常,可以拨打其他人短号"),
    VAL_1("1", "封锁,不可以拨打其他人短号");

    private String value;
    private String label;

    LockFlagEnum(String value, String label) {
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
