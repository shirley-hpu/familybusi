package com.sitech.preservice.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2019/5/30 16:12
 */
public class FamilyPreOrderCfm implements Serializable {

    @JSONField(name = "PREODER_INFO")
    private PreoderInfo preoderInfo;

    public static class PreoderInfo implements Serializable{
        @JSONField(name = "PHONE_NO")
        @NotBlank(message = "PHONE_NO不能为空")
        private String phoneNo;

        @JSONField(name = "GOODS_NAME")
        @NotBlank(message = "GOODS_NAME不能为空")
        private String goodsName;

        @JSONField(name = "GOODS_DESC")
        @NotBlank(message = "GOODS_DESC不能为空")
        private String goodsDesc;

        @JSONField(name = "FREE_SUM")
        @NotBlank(message = "FREE_SUM不能为空")
        private String freeSum;

        @JSONField(name = "USE_ADDRESS")
        @NotBlank(message = "USE_ADDRESS不能为空")
        private String useAddress;

        @JSONField(name = "INSTALL_TIME")
        private Date installTime;

        private Date opTime;

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsDesc() {
            return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
        }

        public String getFreeSum() {
            return freeSum;
        }

        public void setFreeSum(String freeSum) {
            this.freeSum = freeSum;
        }

        public String getUseAddress() {
            return useAddress;
        }

        public void setUseAddress(String useAddress) {
            this.useAddress = useAddress;
        }

        public Date getInstallTime() {
            return installTime;
        }

        public void setInstallTime(Date installTime) {
            this.installTime = installTime;
        }

        public Date getOpTime() {
            return opTime;
        }

        public void setOpTime(Date opTime) {
            this.opTime = opTime;
        }

        @Override
        public String toString() {
            return "PreoderInfo{" +
                    "phoneNo='" + phoneNo + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", goodsDesc='" + goodsDesc + '\'' +
                    ", freeSum='" + freeSum + '\'' +
                    ", useAddress='" + useAddress + '\'' +
                    ", installTime=" + installTime +
                    ", opTime=" + opTime +
                    '}';
        }
    }

    public PreoderInfo getPreoderInfo() {
        return preoderInfo;
    }

    public void setPreoderInfo(PreoderInfo preoderInfo) {
        this.preoderInfo = preoderInfo;
    }

    @Override
    public String toString() {
        return "FamilyPreOrderCfm{" +
                "preoderInfo=" + preoderInfo +
                '}';
    }
}
