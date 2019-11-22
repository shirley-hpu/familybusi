package com.sitech.preservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import com.sitech.preservice.dto.FmPreOrderMid;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/5/30
 */
public class FmPreOrderMidInDto {


    @JSONField(name = "PREODER_INFO")
    private FmPreOrderMid fmPreOrderMid;

    public FmPreOrderMid getFmPreOrderMid() {
        return fmPreOrderMid;
    }

    public void setFmPreOrderMid(FmPreOrderMid fmPreOrderMid) {
        this.fmPreOrderMid = fmPreOrderMid;
    }
}
