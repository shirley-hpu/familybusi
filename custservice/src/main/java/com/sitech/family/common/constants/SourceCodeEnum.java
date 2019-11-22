package com.sitech.family.common.constants;

/**
 * 订购、退订渠道代码
 *
 * @author shirley
 * @date created in 2019/3/27
 */
public enum SourceCodeEnum {

    VAL_01("01", "能力开放平台"),
    VAL_02("02", "网上营业厅"),
    VAL_03("03", "掌上营业厅"),
    VAL_04("04", "短信营业厅"),
    VAL_05("05", "自助终端"),
    VAL_06("06", "IVR"),
    VAL_07("07", "RADIUS"),
    VAL_09("09", "一级WAP"),
    VAL_11("11", "营业前台"),
    VAL_12("12", "营销执行"),
    VAL_17("17", "10086客服"),
    VAL_18("18", "一级BOSS"),
    VAL_19("19", "银行"),
    VAL_21("21", "智能终端CRM"),
    VAL_22("22", "智能终端ESOP"),
    VAL_23("23", "亲情号"),
    VAL_24("24", "物联网"),
    VAL_25("25", "PBOSS"),
    VAL_26("26", "渠道协同"),
    VAL_27("27", "手机营业厅保障"),
    VAL_28("28", "三卡合一"),
    VAL_29("29", "建行POS"),
    VAL_30("30", "在线客服"),
    VAL_31("31", "网上商城"),
    VAL_32("32", "手机客户端"),
    VAL_39("39", "远程写卡"),
    VAL_45("45", "集团门户"),
    VAL_47("47", "空中充值"),
    VAL_62("62", "行业网关(IAGW)"),
    VAL_63("63", "垃圾彩信"),
    VAL_85("85", "彩铃平台"),
    VAL_91("91", "联动优势"),
    VAL_92("92", "4A系统"),
    VAL_96("96", "微信厅"),
    VAL_98("98", "系统后台"),
    VAL_99("99", "其它渠道"),
    VAL_A1("A1", "天猫"),
    VAL_A2("A2", "代理商门户"),
    VAL_A3("A3", "12580满意度测评渠道"),
    VAL_A4("A4", "电话经理");

    private String value;
    private String label;

    SourceCodeEnum(String value, String label) {
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
