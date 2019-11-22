package com.sitech.preservice.constants;

public enum PreNoteEnum {

    VAL_00("00","速率不满足"),
    VAL_01("01","端口不可用"),
    VAL_02("02","费用太高"),
    VAL_03("03","网速不稳定"),
    VAL_04("04","售后服务差"),
    VAL_05("05","宽带无法移机"),
    VAL_06("06","手机号销户"),
    VAL_07("07","个人原因"),
    VAL_08("08","手机号携转");

    private String value;
    private String label;

    PreNoteEnum(String value, String label) {
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
