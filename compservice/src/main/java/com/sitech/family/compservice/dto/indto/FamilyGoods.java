package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class FamilyGoods implements Serializable {

    @JSONField(name = "PRC_ID")
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
    @NotBlank(message = "RUN_FLAG不能为空")
    private String runFlag;

    @JSONField(name = "CHANNEL_ID")
    @NotBlank(message = "CHANNEL_ID不能为空")
    private String channelId;

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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "FamilyGoods{" +
                "prcId='" + prcId + '\'' +
                ", masterServId='" + masterServId + '\'' +
                ", userRange='" + userRange + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", runFlag='" + runFlag + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
