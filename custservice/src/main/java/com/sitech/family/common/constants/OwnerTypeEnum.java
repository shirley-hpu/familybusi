package com.sitech.family.common.constants;

/**
 * 用户类型
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum OwnerTypeEnum {

    VAL_1(1, "个人"),
    VAL_2(2, "家庭"),
    VAL_3(3, "集团"),
    VAL_4(4, "团体");

    private Integer value;
    private String label;

    OwnerTypeEnum(Integer value, String label) {
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
