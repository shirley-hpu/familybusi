package com.sitech.family.common.constants;

/**
 * 关联操作类型
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum RelopTypeEnum {

    VAL_A("A", "关联订购"),
    VAL_D("D", "关联退订");

    private String value;
    private String label;

    RelopTypeEnum(String value, String label) {
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
