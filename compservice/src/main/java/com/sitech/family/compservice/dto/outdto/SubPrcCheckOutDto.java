package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author guanqp
 * @Description  主资费校验 outdto
 * @date 2019/3/12 16:21
 */
public class SubPrcCheckOutDto implements Serializable{

    @JSONField(name = "REL_CHK_LIST")
    private RelChkList relChkList;

    public RelChkList getRelChkList() {
        return relChkList;
    }

    public void setRelChkList(RelChkList relChkList) {
        this.relChkList = relChkList;
    }
}
