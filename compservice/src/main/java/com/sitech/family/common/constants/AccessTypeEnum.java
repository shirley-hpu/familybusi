package com.sitech.family.common.constants;

/**
 * 用户接入网类型
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum AccessTypeEnum {

    VAL_000("000", "2G,3G用户"),
    VAL_001("001", "4G用户");

    private String value;
    private String label;

    AccessTypeEnum(String value, String label) {
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
