package com.sitech.family.common.constants;

/**
 * 话单查询标志
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum QueryCdrflagEnum {

    VAL_N("N", "不可以查询话单"),
    VAL_Y("Y", "可以查询话单");

    private String value;
    private String label;

    QueryCdrflagEnum(String value, String label) {
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
