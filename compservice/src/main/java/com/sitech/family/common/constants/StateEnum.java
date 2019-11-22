package com.sitech.family.common.constants;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum StateEnum {

    VAL_A("A", "正常"),
    VAL_B("B", "在途"),
    VAL_X("X", "已退订"),
    VAL_P("P", "暂停");

    private String value;
    private String label;

    StateEnum(String value, String label) {
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
