package com.sitech.family.common.constants;

/**
 * 关联方式
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum RelationTypeEnum {

    VAL_1("1", "逻辑互斥"),
    VAL_a("a", "套餐自动升档"),
    VAL_7("7", "连带订购"),
    VAL_8("8", "连带退订"),
    VAL_11("11", "到期转移");

    private String value;
    private String label;

    RelationTypeEnum(String value, String label) {
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
