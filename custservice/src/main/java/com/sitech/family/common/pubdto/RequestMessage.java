package com.sitech.family.common.pubdto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xuwei on 2018/7/23.
 */
public class RequestMessage<T> {
    @JSONField(name = "loginInfo")
    private LoginInfo loginInfo;

    @JSONField(name = "oprInfo")
    private OprInfo oprInfo;

    @JSONField(name = "paramMap")
    private T busiData;

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public OprInfo getOprInfo() {
        return oprInfo;
    }

    public void setOprInfo(OprInfo oprInfo) {
        this.oprInfo = oprInfo;
    }

    public T getBusiData() {
        return busiData;
    }

    public void setBusiData(T busiData) {
        this.busiData = busiData;
    }

}
