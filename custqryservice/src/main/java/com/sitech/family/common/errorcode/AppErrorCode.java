package com.sitech.family.common.errorcode;

/**
 * Created by xuwei on 2018/7/24.
 */

public class AppErrorCode extends AppError{
    /**
     * 获取错误编号
     * @param opCode 操作编码
     * @param seq 错误序列号
     * @return
     */
    public static String getErrorCode(String opCode,String seq)
    {
        return AppError.getErrorCode(AppErrorConstants.ChannelType.COMMON,
                AppErrorConstants.ErrorType.BUSI_ERROR,
                AppErrorConstants.SystemCode.COMMON,
                opCode,
                seq);
    }

    /**
     * 获取错误编号
     * @param opCode 操作编码
     * @param seq 错误序列号
     * @param errorType 错误类别
     * @return
     */
    public static String getErrorCode(String opCode,String seq,String errorType)
    {
        return AppError.getErrorCode(AppErrorConstants.ChannelType.COMMON,
                errorType,
                AppErrorConstants.SystemCode.COMMON,
                opCode,
                seq);
    }

}
