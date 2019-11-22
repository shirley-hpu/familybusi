package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2018/12/11.
 */
public class PhoneQryInDto {

    @NotBlank(message = "160002$组织机构不能为空")
    @JSONField(name = "GROUP_ID")
    public String  groupId;

    @NotBlank(message = "160003$号码最大查询量不能为空")
    @JSONField(name = "MAX_NUM")
    public String  maxNum;

    @NotBlank(message = "160003$号码类型不能为空")
    @JSONField(name = "RES_CODE")
    public String resCode;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    @Override
    public String toString() {
        return "PhoneQryInDto{" +
                "groupId='" + groupId + '\'' +
                ", maxNum='" + maxNum + '\'' +
                ", resCode='" + resCode + '\'' +
                '}';
    }
}

