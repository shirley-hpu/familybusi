package com.sitech.family.common.constants;

/**
 * 计费类型
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum BillTypeEnum {


    VAL_11(11, "在线计费(ocs)"),
    VAL_12(12, "离线计费(hotbilling)");

    private Integer value;
    private String label;

    BillTypeEnum(Integer value, String label) {
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
