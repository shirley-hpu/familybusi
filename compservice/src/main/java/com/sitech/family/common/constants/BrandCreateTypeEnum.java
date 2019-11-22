package com.sitech.family.common.constants;

/**
 * 用户品牌维护方式
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum BrandCreateTypeEnum {

    VAL_1("1", "产品关联生成"),
    VAL_2("2", "客户经理维护");

    private String value;
    private String label;

    BrandCreateTypeEnum(String value, String label) {
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
