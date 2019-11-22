package com.sitech.family.common.constants;

/**
 * VIP生成方式
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum VIPCreateTypeEnum {

    VAL_0(0, "无卡"),
    VAL_1(1, "人工"),
    VAL_2(2, "自动");

    private Integer value;
    private String label;

    VIPCreateTypeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
