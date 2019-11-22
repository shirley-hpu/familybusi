package com.sitech.family.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by xuwei on 2018/12/12.
 */
public class RequestMessage<T> {

    @JSONField(name = "OPR_INFO")
    @NotNull(message="170000$入参oprInfo不能为空")
    private OprInfo oprInfo;

    @JSONField(name = "BUSI_INFO")
    @NotNull(message="170001$入参busiInfo不能为空")
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

    @Override
    public String toString() {
        return "RequestMessage{" +
                "oprInfo=" + oprInfo +
                ", busiInfo=" + busiInfo +
                '}';
    }
}
