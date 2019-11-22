package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description: 附加资费全量信息
 * @Author: wusm
 * @Date: 2019-07-31 15:22
 * @Version: 1.0
 */
public class FamilyAddFeeInfo implements Serializable {

    @JSONField(name = "PRC_ID")
    @NotBlank(message = "PRC_ID不能为空")
    private String prcId;

    @JSONField(name = "MASTER_SERV_ID")
    @NotBlank(message = "MASTER_SERV_ID不能为空")
    private String masterServId;

    @JSONField(name = "USER_RANGE")
    @NotBlank(message = "USER_RANGE不能为空")
    private String userRange;

    @JSONField(name = "GOODS_TYPE")
    @NotBlank(message = "GOODS_TYPE不能为空")
    private String goodsType;

    @JSONField(name = "RUN_FLAG")
    @NotBlank(message = "runFlag不能为空")
    private String runFlag;

    @JSONField(name = "MEMBER_ROLE_ID")
    @NotBlank(message = "memberRoleId不能为空")
    private String memberRoleId;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getMasterServId() {
        return masterServId;
    }

    public void setMasterServId(String masterServId) {
        this.masterServId = masterServId;
    }

    public String getUserRange() {
        return userRange;
    }

    public void setUserRange(String userRange) {
        this.userRange = userRange;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getRunFlag() {
        return runFlag;
    }

    public void setRunFlag(String runFlag) {
        this.runFlag = runFlag;
    }

    public String getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(String memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    @Override
    public String toString() {
        return "FamilyAddFeeInfo{" +
                "prcId='" + prcId + '\'' +
                ", masterServId='" + masterServId + '\'' +
                ", userRange='" + userRange + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", runFlag='" + runFlag + '\'' +
                ", memberRoleId='" + memberRoleId + '\'' +
                '}';
    }
}
