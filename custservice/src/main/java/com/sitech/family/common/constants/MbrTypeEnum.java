package com.sitech.family.common.constants;

/**
 * 成员角色
 */
public enum MbrTypeEnum {

    VAL_1001("1001", "语音卡"),
    VAL_1002("1002", "宽带"),
    VAL_1008("1008", "固定电话"),
    VAL_2050("2050", "IPTV电视");

    private String value;
    private String label;

    MbrTypeEnum(String value, String label) {
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
