package com.sitech.family.common.errorcode;

/**
 * Created by xuwei on 2018/7/24.
 */
public interface AppErrorConstants {

    /**
     * 渠道编码（3位）
     *
     * @author xuwei
     *
     */
    public interface ChannelType
    {
        public static final String COMMON = "998";//COMMON专用
        public static final String CRM = "100"; // CRM
        public static final String BOSS = "101"; // BOSS
        public static final String NET = "102"; // 网厅
        public static final String SMS = "103"; // 短厅
        public static final String CSOP = "104"; // 客服话务
        public static final String TMSOP = "105"; // 电话经理
        public static final String CCMS = "106"; // 绿网投诉
        public static final String DSS = "107"; // 经营分析
        public static final String PBOSS = "108"; // PBOSS
        public static final String ESOP = "109";//ESOP
        public static final String INTELLIGENT_TERMINAL  = "110";//智能终端
    }

    /**
     * 错误类型（2位）
     *
     * @author xuwei
     *
     */
    public interface ErrorType
    {
        public static final String SYSTEM_ERROR = "10"; // 系统错误
        public static final String BUSI_ERROR = "11"; // 业务错误
        public static final String PROMPT_INFO = "12"; // 引导信息
        public static final String BUSIRULE_ERROR = "13";//业务规则引擎
    }

    public interface EntityCode
    {
        public static final String UTIL_EntityId = "0000";//工具类
        public static final String DATASYN_EntityId="0002";//数据同步
        public static final String ORDER_EntityId = "0003";//订单
        public static final String MSG_EntityId = "0004";//短信
        public static final String BUSIRULE_EntityId = "0005";//业务规则引擎
        public static final String CNTT_EntityId = "0006";//统一接触

    }

    /**
     * 子系统编码（3位）
     *
     * @author xuwei
     *
     */
    public interface SystemCode
    {

        public static final String JCF = "999"; // 框架专用
        public static final String COMMON = "998";//common专用
        public static final String ORDER = "101"; // 订单处理
        public static final String ORDERSVC = "102"; // 订单受理
        public static final String CUSTSVC = "103"; // 客户服务
        public static final String PRODMNG = "104"; // 产品管理
        public static final String RESMNG = "105"; // 资源管理
        public static final String CUSTMNG = "106"; // 客户管理
        public static final String BASEMNG = "107"; // 基础域
        public static final String ONEBOSS = "108"; // 一级boss
        public static final String ACCTMGR = "109"; // 账务管理
        public static final String ACCTDEAL = "110"; // 账务处理
        public static final String RPT = "111"; // 台帐报表
        public static final String HOLD = "112"; // 维系挽留
        public static final String SMSP = "113"; // 服务开通
        public static final String CMDMGR = "114"; // 综合接口
        public static final String MARKET = "115"; // 营销管理
        public static final String SELLMGR = "116"; // 销售管理
        public static final String CHNMGR = "117"; // 渠道管理
        public static final String DATAEXTR = "118"; // 业务数据抽取平台
        public static final String CNTT = "119"; // 统一接触系统
        public static final String ESOP = "120"; // ESOP系统
        public static final String CSOP = "121"; // 客服话务
        public static final String TMSOP = "122"; // 电话经理
        public static final String CCMS = "123"; // 绿网投诉
        public static final String DSS = "124"; // 经营分析
        public static final String SCOREMGR = "125"; // 积分管理
        public static final String SCOREDEAL = "126"; // 积分处理
        public static final String INTELLIGENT_TERMINAL_ESOP = "127"; // 智能终端ESOP
        public static final String INTELLIGENT_TERMINAL_CRM = "128"; // 智能终端CRM
        public static final String INFO_INFORM = "129"; // 信息通知平台
    }

}
