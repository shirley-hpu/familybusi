package com.sitech.family.common.constants;

/**
 * 成员角色
 */
public enum MbrRoleEnum {

    VAL_60001("60001", "家庭主角"),
    VAL_60002("60002", "家庭普通成员");

    private String value;
    private String label;

    MbrRoleEnum(String value, String label) {
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
