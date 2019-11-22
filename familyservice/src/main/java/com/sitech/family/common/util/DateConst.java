package com.sitech.family.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/6 15:51
 */
public class DateConst {
    public static final String DATE_MODEL_1 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_MODEL_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_MODEL_3 = "yyyy-MM-dd HH:mm";
    public static final String DATE_MODEL_4 = "yyyy-MM-dd HH";
    public static final String DATE_MODEL_5 = "yyyy-MM-dd";
    public static final String DATE_MODEL_6 = "yyyy-MM";

    public static final String DATE_MODEL_7 = "yyyyMMddHHmmss.SSS";
    public static final String DATE_MODEL_8 = "yyyyMMddHHmmss";
    public static final String DATE_MODEL_9 = "yyyyMMddHHmm";
    public static final String DATE_MODEL_10 = "yyyyMMddHH";
    public static final String DATE_MODEL_11 = "yyyyMMdd";
    public static final String DATE_MODEL_12 = "yyyyMM";

    public static final String DATE_MODEL_13 = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String DATE_MODEL_14 = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_MODEL_15 = "yyyy/MM/dd HH:mm";
    public static final String DATE_MODEL_16 = "yyyy/MM/dd HH";
    public static final String DATE_MODEL_17 = "yyyy/MM/dd";
    public static final String DATE_MODEL_18 = "yyyy/MM";

    public static final String DATE_MODEL_99 = "yyyy";
    public static final String DATE_MODEL_100 = "yyMMdd";
    public static final String DATE_MODEL_101 = "yy";
    public static final String DATE_MODEL_102 = "MM";
    public static final String DATE_MODEL_103 = "dd";

    /**
     * 获取历史表Update_Date值
     * @param date
     * @param dateModel
     * @return
     */
    public static Integer getUpdateDate(Date date,String dateModel){
        return Integer.decode(new SimpleDateFormat(dateModel).format(date));
    }
    /**
     * 根据日期字符串，判断日期格式。常用于不知道的日期格式判断。
     *
     * @param date
     *            日期字符串
     * @return String
     */
    public static String getType(String date) {
        String result = null;
        if (date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DateConst.DATE_MODEL_1;
        } else if (date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DateConst.DATE_MODEL_2;
        } else if (date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
            result = DateConst.DATE_MODEL_3;
        } else if (date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}")) {
            result = DateConst.DATE_MODEL_4;
        } else if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            result = DateConst.DATE_MODEL_5;
        } else if (date.matches("\\d{4}-\\d{2}")) {
            result = DateConst.DATE_MODEL_6;
        } else if (date.matches("\\d{14}.\\d+")) {
            result = DateConst.DATE_MODEL_7;
        } else if (date.matches("\\d{14}")) {
            result = DateConst.DATE_MODEL_8;
        } else if (date.matches("\\d{12}")) {
            result = DateConst.DATE_MODEL_9;
        } else if (date.matches("\\d{10}")) {
            result = DateConst.DATE_MODEL_10;
        } else if (date.matches("\\d{8}")) {
            result = DateConst.DATE_MODEL_11;
        } else if (date.matches("\\d{6}")) {
            result = DateConst.DATE_MODEL_12;
        } else if (date
                .matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d+")) {
            result = DateConst.DATE_MODEL_13;
        } else if (date.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            result = DateConst.DATE_MODEL_14;
        } else if (date.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}")) {
            result = DateConst.DATE_MODEL_15;
        } else if (date.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}")) {
            result = DateConst.DATE_MODEL_16;
        } else if (date.matches("\\d{4}/\\d{2}/\\d{2}")) {
            result = DateConst.DATE_MODEL_17;
        } else if (date.matches("\\d{4}/\\d{2}")) {
            result = DateConst.DATE_MODEL_18;
        }
        return result;
    }
}
