package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
public class OpenUserCountNumOutDto implements Serializable {
    @JSONField(name = "BUSI_INFO")
    private OpenUserCountNumBusiInfoOutDto busiInfo;

    public OpenUserCountNumBusiInfoOutDto getBusiInfo() {
        return busiInfo;
    }

    public void setBusiInfo(OpenUserCountNumBusiInfoOutDto busiInfo) {
        this.busiInfo = busiInfo;
    }
}
