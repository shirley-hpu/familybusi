package com.sitech.family.custservice.base.util;

/**
 * 序列名管理
 *
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 13:35
 */
public class SequenceConst {


    public static final String SEQ_NAME1 = "ID_SEQ";

    /**
     * 家庭商品订购实例标识 UR_USERGOODS_INFO.GOODSINS_ID
     * START WITH 38000000000000
     * MAXVALUE   39999999999999
     * MINVALUE   38000000000000
     */
    public static final String SEQ_FM_GOODSINS_ID = "SEQ_FM_GOODSINS_ID";


    /**
     * 家庭资费订购实例标识 UR_USERPRC_INFO.PRODPRCINS_ID
     * START WITH 48000000000000
     * MAXVALUE   48999999999999
     * MINVALUE   48000000000000
     */
    public static final String SEQ_FM_PRODPRCINS_ID = "SEQ_FM_PRODPRCINS_ID";


    /**
     * 家庭服务订购实例标识 ur_usersvctrace_info.SVCINS_ID
     * START WITH 48000000000000
     * MAXVALUE   48999999999999
     * MINVALUE   48000000000000
     */
    public static final String SEQ_FM_SVCINSID = "SEQ_FM_SVCINSID";


    /**
     * 销售记录序列值 UR_RESSELLTERM_INFO.SELL_SERIAL_NO
     * START WITH 40000000000000
     * MAXVALUE   59999999999999
     * MINVALUE   40000000000000
     */
    public static final String SEQ_FM_SELLSERIALID = "SEQ_FM_SELLSERIALID";


    /**
     * 家庭账务关系标识 CS_ConUserRel_info.SERV_ACCT_ID
     * &&
     * 家庭账户关系标识 CS_account_rel.SERV_ACCT_ID
     * START WITH 40000000000000
     * MAXVALUE   59999999999999
     * MINVALUE   40000000000000
     */
    public static final String SEQ_FM_ACCTID = "SEQ_FM_ACCTID";


    /**
     * 成员标识 UR_USERGROUPMBR_INFO.MEMBER_ID
     * START WITH 49000000000000
     * MAXVALUE   59999999999999
     * MINVALUE   49000000000000
     */
    public static final String SEQ_FM_MEMBERID = "SEQ_FM_MEMBERID";


    /**
     * 群实例标识 UR_USERGROUP_INFO.GROUP_ID
     * START WITH 49000000000000
     * MAXVALUE   59999999999999
     * MINVALUE   49000000000000
     */
    public static final String SEQ_FM_GROUPID = "SEQ_FM_GROUPID";


    /**
     * 家庭用户受限序列标识 UR_USERGOODSLMT_INFO.LIMITINS_ID
     * START WITH 49000000000000
     * MAXVALUE   59999999999999
     * MINVALUE   49000000000000
     */
    public static final String SEQ_FM_LIMITINS_ID = "SEQ_FM_LIMITINS_ID";


    /**
     * 家客系统通用流水序列 公共字段LOGIN_ACCEPT
     * &&
     * 家庭用户状态变化序列号 CS_UserState_info.STATE_CHANGE_NO
     * START WITH 400000000000000000
     * MAXVALUE   599999999999999999
     * MINVALUE   400000000000000000
     */
    public static final String SEQ_FM_LOGINACCEPT = "SEQ_FM_LOGINACCEPT";


    /**
     * 家庭用户标识 UR_USER_INFO.ID_NO
     * &&
     * 家庭用户虚拟服务号码 UR_USER_INFO.PHONE_ NO ：与 家庭用户标识 同值
     * START WITH 1900000000000
     * MAXVALUE   1999999999999
     * MINVALUE   1900000000000
     * eg:吉林长春 2301
     */
    public static final String SEQ_FM_USERID_2301 = "SEQ_FM_USERID_2301";


}
