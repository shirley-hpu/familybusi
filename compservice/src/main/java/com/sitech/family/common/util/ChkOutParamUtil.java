package com.sitech.family.common.util;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 调用接口出参结果校验
 * @date 2018/9/27 18:13
 */
public class ChkOutParamUtil {
    private static final String SUCCESS_CODE = "0";

    /**
     * 出参结果判断:0 成功 其他值 失败
     * @param mapOutDTO
     */
    public static void chkOutParam(OutDTO<Map> mapOutDTO){

        if(!SUCCESS_CODE.equals(mapOutDTO.getRtnCode())){
            throw new BusiException("-9999", mapOutDTO.getRtnMsg());
        }
    }
}