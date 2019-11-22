package com.sitech.family.common.constants;

/**
 * 信用度调整方式
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum LmtAdjustTypeEnum {

    VAL_10("10", "静态调整方式"),
    VAL_11("11", "暂停");

    private String value;
    private String label;

    LmtAdjustTypeEnum(String value, String label) {
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
