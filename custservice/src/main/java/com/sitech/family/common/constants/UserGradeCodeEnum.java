package com.sitech.family.common.constants;

/**
 * 用户性质代码
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum UserGradeCodeEnum {

    VAL_01("01", "公免用户"),
    VAL_02("02", "测试用户"),
    VAL_03("03", "普通用户");

    private String value;
    private String label;

    UserGradeCodeEnum(String value, String label) {
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
