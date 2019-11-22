package com.sitech.family.custservice.base.util;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/6 14:16
 */
public class StringUtils {
    /**
     *将java对象转换为String，对象为null时返回null
     *
     * @param value
     *            要转换的对象
     * @return String
     */
    public static final String castToString(Object value)
    {
        if (value == null)
            return null;
        else
            return value.toString();
    }
    /**
     * 验证对象是否为空或NULl
     *
     * @param str
     *            验证对象
     * @return 处理结果 空/Null:true,否则:false
     */
    public static boolean isEmptyOrNull(Object str)
    {
        if ("".equals(str) || null == str)
        {
            return true;
        }
        return false;
    }

    /**
     * 将String 转换为Long
     * @param value
     * @return
     */
    public static Long castToLong(String value)
    {
        if(value == null || "" == value){
            return null;
        }
        return Long.parseLong(value);
    }

    /**
     * 验证两个对象是否相等
     *
     * @param obj1
     *            对象一
     * @param obj2
     *            对象二
     * @return 相等 true，不相等：false
     */
    public static boolean isEqual(Object obj1, Object obj2)
    {
        if (obj1 == null && obj2 == null)
        {
            return true;
        }
        else if (obj1 == null)
        {
            return false;
        }
        else if (obj2 == null)
        {
            return false;
        }
        else
        {
            return obj1.equals(obj2);
        }
    }
}
