package com.sitech.family.common.constants;

/**
 * 档案状态
 * FINISH_FLAG
 *
 * @author shirley
 * @date created in 2019/3/11
 */
public enum FinishFlagEnum {

    VAL_Y("Y", "已竣工生效"),
    VAL_N("N", "未竣工生效"),
    VAL_M("M", "预约订购或者退订");



    private String value;
    private String label;

    FinishFlagEnum(String value, String label) {
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
