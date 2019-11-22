package com.sitech.family.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/26 10:40
 */
public class RequestMessage<T> {
    @JSONField(name = "OPR_INFO")
    private OprInfo oprInfo;

    @JSONField(name = "BUSI_INFO")
    @NotNull(message="15000$busiInfo不能为空")
    @Valid
    private T busiInfo;

    public OprInfo getOprInfo() {
        return oprInfo;
    }

    public void setOprInfo(OprInfo oprInfo) {
        this.oprInfo = oprInfo;
    }

    public T getBusiInfo() {
        return busiInfo;
    }

    public void setBusiInfo(T busiInfo) {
        this.busiInfo = busiInfo;
    }
}
