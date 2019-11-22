package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 成员商品信息
 *
 * @author shirley
 * @date created in 2019/3/28
 */
public class FamilyMbrGoods implements Serializable {

    private static final long serialVersionUID = 1L;
    @JSONField(name = "MBR_GOODS_NAME")
    private String mbrGoodsName;
    @JSONField(name = "MBR_GOODS_DESC")
    private String mbrGoodsDesc;
    @JSONField(name = "MBR_GOODS_ID")
    private String mbrGoodsId;
    @JSONField(name = "MBRPRCLIST")
    private List<FamilyMbrPrc> mbrPrcList;

    public String getMbrGoodsName() {
        return mbrGoodsName;
    }

    public void setMbrGoodsName(String mbrGoodsName) {
        this.mbrGoodsName = mbrGoodsName;
    }

    public String getMbrGoodsDesc() {
        return mbrGoodsDesc;
    }

    public void setMbrGoodsDesc(String mbrGoodsDesc) {
        this.mbrGoodsDesc = mbrGoodsDesc;
    }

    public String getMbrGoodsId() {
        return mbrGoodsId;
    }

    public void setMbrGoodsId(String mbrGoodsId) {
        this.mbrGoodsId = mbrGoodsId;
    }

    public List<FamilyMbrPrc> getMbrPrcList() {
        return mbrPrcList;
    }

    public void setMbrPrcList(List<FamilyMbrPrc> mbrPrcList) {
        this.mbrPrcList = mbrPrcList;
    }

    @Override
    public String toString() {
        return "FamilyMbrGoods{" +
                "mbrGoodsName='" + mbrGoodsName + '\'' +
                ", mbrGoodsDesc='" + mbrGoodsDesc + '\'' +
                ", mbrGoodsId='" + mbrGoodsId + '\'' +
                ", mbrPrcList=" + mbrPrcList +
                '}';
    }
}
