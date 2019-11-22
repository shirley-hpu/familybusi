package com.sitech.family.common.constants;

/**
 * 用户状态
 * RUN_CODE
 *
 * @author shirley
 * @date created in 2019/3/15
 */
public enum RunCodeEnum {

    A("A", "正常"),
    B("B", "全停"),
    C("C", "单通"),
    F("F", "集团产品暂停"),
    G("G", "报停"),
    H("H", "挂失"),
    I("I", "预销"),
    J("J", "预拆"),
    K("K", "强开"),
    L("L", "强关"),
    M("M", "到期全停"),
    N("N", "预接入"),
    O("O", "停漫游"),
    P("P", "开户未竣工"),
    S("S", "沉默期状态"),
    T("T", "校园宽带沉默"),
    U("U", "宽带到期停机"),
    V("V", "非实名通信受限"),
    W("W", "沉默期状态"),
    a("a", "销号"),
    b("b", "局拆"),
    c("c", "核销"),
    p("p", "开户未竣工");

    private String value;
    private String label;

    RunCodeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "RunCodeEnum{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
