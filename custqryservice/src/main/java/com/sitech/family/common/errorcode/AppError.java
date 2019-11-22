package com.sitech.family.common.errorcode;

import com.sitech.ijcf.boot.core.error.exception.BusiException;

/**
 * Created by xuwei on 2018/7/24.
 */
public class AppError {
    public static String getErrorCode(String channelType,String errorType,String subSystemCode,String opCode,String seq){

            //TODO 检查各种长度
            if(errorType.length() != 2){
                throw new BusiException("errorType length isn't 2!");

        }
        return channelType+errorType+subSystemCode+opCode+seq;
    }

}
