package com.sitech.family.custservice.base.util;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/11 12:44
 */
public interface Constants {

    public interface Entity
    {
        /**
         * 操作类型
         */
        public static final String UPDATE_TYPE_INSERT = "I";// 新增

        public static final String UPDATE_TYPE_UPDATE = "U";// 更新前，不变

        public static final String UPDATE_TYPE_DELETE = "D";// 删除

        public static final String UPDATE_TYPE_UNCHENG = "X";// 更新状态

        public static final String FINISH_FLAG = "N"; /* 生效状态 */
        public static final String EXP_DATE = "20991231"; /* 失效日期 */
        public static final String EXP_TIME = "20500101000000"; /* 失效时间 */
        public static final String MAX_BILL_ORDER = "99999999"; /* 默认账户销账优先级 */
        public static final String RATE_FLAG_Y = "Y";
        public static final String RATE_FLAG_N = "N";

        public static final String OFF_RUN = "L"; // 强关
        public static final String ON_RUN = "9"; // 强开
        public static final String RES_KIND = "A001"; // 实体卡类型
        public static final String ADD_NBR_TYPE = "02";// 附加业务号码类型

        /**
         * 卡销售方式，新增卡销售类型通知报表。
         */
        public static final String CASH = "11"; // 现金
        public static final String DEDUCT_SCORE = "14"; // 积分兑换
        public static final String FREE_GIVE = "21"; // 赠送
        public static final String SPE_CASH = "30"; // 特殊现金
        public static final String SUB_tChg = "31"; // 预存款
        public static final String GIFT_GIVE = "32"; // 促销品领奖赠送

        /**
         * 虚拟的MAIN_SVC_ID
         */
        public static final String VIR_SVC_ID = "S00107";

    }

    /**
     *
     * @Description: 序列常量 序列配置文件在config下的seq.config
     * @author: haoxz
     * @createTime: 2014-9-11 下午5:20:53
     */
    public interface SEQUENCE
    {
        public static final String SEQ_AC_ACCTID = "SEQ_AC_ACCTID"; /* 账务标识序列 */
        public static final String SEQ_CS_SELLSERIALID = "SEQ_CS_SELLSERIALID";/* 资源销售序列 */
        public static final String SEQ_CS_BATCHPLANID = "SEQ_CS_BATCHPLANID"; /* 批量标识序列 */
        public static final String SEQ_CS_SMSPUSH = "SEQ_CS_SMSPUSH"; /* 短信随机码序列 */
    }

    public interface GROUP_LEVEL
    {
        /**
         * 渠道级别
         */
        public static final String PROVINCE = "1";// 省级
        public static final String REGION = "2";// 地市级
        public static final String CITY = "3";// 区县级
        public static final String STORE = "4";// 营业厅级
    }

    public interface ROLL_BACK
    {

        public static final String CANCEL = "R";// 撤单
        public static final String CORRECT = "B";// 冲正

        /**
         * 所有历史表六种公共字段
         */
        public static final String UPDATE_ACCEPT = "UPDATE_ACCEPT";// 操作流水
        public static final String UPDATE_TIME = "UPDATE_TIME";// 操作时间
        public static final String UPDATE_DATE = "UPDATE_DATE";// 操作日期
        public static final String UPDATE_TYPE = "UPDATE_TYPE";// 操作类型
        public static final String UPDATE_CODE = "UPDATE_CODE";// 操作模块
        public static final String UPDATE_LOGIN = "UPDATE_LOGIN";// 操作员工
    }

    // 产品ID常量
    public interface GoodsPrcEntity
    {
        public static final String PRC_ID_WEAR = "M049266"; /*
         * 物联卡可穿戴设备全国漫游使用费-13
         * 元
         */
        public static final String PRC_ID_MSG = "M001009"; /* 短消息 */
        public static final String PRC_ID_GPRS = "M001038"; /* GPRS业务 */
    }

    // 品牌
    public interface BrandId
    {
        public static final String BRAND_ID_SZX_A = "2310PA";// 神州行品牌
        public static final String BRAND_ID_SZX_B = "2330PB";// 神州行品牌
        public static final String BRAND_ID_IMSGH = "2330GH";// IMS固话

    }
    public interface Province{
        public static final String PROVINCE_HLJ_ID = "230000";
        public static final String PROVINCE_JL_ID = "220000";
    }

    public interface BroadPwd{
        public static final String BROADPWD_KEY = "88----89\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";//宽带密码加解密密钥

    }
    public interface HbaseList{
        public static final String QUERY_IMEI_LIST = "cntt_data_01:TR_VC_110_IMEI_D";
    }

}
