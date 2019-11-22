package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * Created by xuwei on 2018/12/11.
 */
public class PhoneQry {

    @NotBlank(message = "160002$组织机构不能为空")
    @JSONField(name = "GROUP_ID")
    public String  groupId;

    @NotBlank(message = "160003$号码最大查询量不能为空")
    @JSONField(name = "MAX_NUM")
    public String  maxNum;

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

    @Override
    public String toString() {
        return "PhoneQryDto{" +
                "groupId='" + groupId + '\'' +
                ", maxNum='" + maxNum + '\'' +
                '}';
    }
}

