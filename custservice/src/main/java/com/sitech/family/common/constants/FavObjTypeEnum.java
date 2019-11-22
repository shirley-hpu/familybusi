package com.sitech.family.common.constants;

/**
 * 优惠对象类型
 * 当优惠对象类型为1，2时，计费账务不需要关注优惠对象值(FAV_OBJ_VALUE)，配置时优惠对象值默认为0
 */
public enum FavObjTypeEnum {

    VAL_1("1", "用户"),
    VAL_2("2", "账户"),
    VAL_3("3", "商品(定价、资费)"),
    VAL_4("4", "账目项");

    private String value;
    private String label;

    FavObjTypeEnum(String value, String label) {
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
