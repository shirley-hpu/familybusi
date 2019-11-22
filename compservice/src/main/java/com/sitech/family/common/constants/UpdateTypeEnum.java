package com.sitech.family.common.constants;

/**
 * @author wusm
 * @description
 * @date 2019/4/22 10:41
 */
public enum UpdateTypeEnum {

    VAL_A("A","新增"),
    VAL_D("D","删除"),
    VAL_U("U","更新"),
    VAL_X("X","备份");

    private String value;
    private String label;

    UpdateTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
