package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

/**
 * @author guanqp
 * @Description  用户基本信息查询
 * @date 2019/2/20 10:56
 */
public class UserInfoQryInDto {

    @NotBlank(message = "160017$家长手机号码不能为空")
    @JSONField(name = "PHONE_NO")
    public String  phoneNo;

    @NotBlank(message = "160018$主体服务类型不能为空")
    @JSONField(name = "MASTER_SERV_ID")
    public String  masterServId;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    @Override
    public String toString() {
        return "UserInfoQryInDto{" +
                "phoneNo='" + phoneNo + '\'' +
                ", masterServId='" + masterServId + '\'' +
                '}';
    }
}

