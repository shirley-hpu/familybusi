package com.sitech.family.common.constants;

/**
 * 实例分类
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum InsTypeEnum {

    VAL_1("1", "商品订购实例(GOODSINS_ID)"),
    VAL_2("2", "资费订购实例(PRODPRCINS_ID)"),
    VAL_3("3", "服务订购实例(SVCINS_ID)");

    private String value;
    private String label;

    InsTypeEnum(String value, String label) {
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
