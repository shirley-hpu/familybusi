package com.sitech.family.common.constants;

/**
 * 主题服务ID
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum MasterServIdEnum {

    VAL_1001("1001", "G网"),
    VAL_1002("1002", "宽带"),
    VAL_1003("1003", "数据固定业务"),
    VAL_1004("1004", "固话"),
    VAL_1005("1005", "???业务"),
    VAL_1006("1006", "IMS业务");

    private String value;
    private String label;

    MasterServIdEnum(String value, String label) {
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
