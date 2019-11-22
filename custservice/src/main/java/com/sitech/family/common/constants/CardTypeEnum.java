package com.sitech.family.common.constants;

/**
 * 用户卡级别
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum CardTypeEnum {

    VAL_1(1L, "普通客户"),
    VAL_2(2L, "个人钻石卡"),
    VAL_3(3L, "个人金卡"),
    VAL_4(4L, "个人银卡"),
    VAL_5(5L, "个人贵宾卡"),
    VAL_6(6L, "普通中高端"),
    VAL_12(12L, "集团钻石卡"),
    VAL_13(13L, "集团金卡"),
    VAL_14(14L, "集团银卡"),
    VAL_15(15L, "集团贵宾卡");

    private Long value;
    private String label;

    CardTypeEnum(Long value, String label) {
        this.value = value;
        this.label = label;
    }

    public Long getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
