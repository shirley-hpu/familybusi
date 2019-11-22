package com.sitech.family.common.constants;

/**
 * 优惠来源类型
 */
public enum OpsourTypeEnum {

    VAL_1(1, "商品订购"),
    VAL_2(2, "营销活动"),
    VAL_3(3, "订单优惠");

    private Integer value;
    private String label;

    OpsourTypeEnum(Integer value, String label) {
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
