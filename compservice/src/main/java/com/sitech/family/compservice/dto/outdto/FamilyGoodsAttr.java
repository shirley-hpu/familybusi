package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 资费属性、服务属性
 *
 * @author shirley
 * @date created in 2019/3/28
 */
public class FamilyGoodsAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "PRC_ID")
    private String prcId;
    @JSONField(name = "SVC_ID")
    private String svcId;
    @JSONField(name = "ATTR_ID")
    private String attrId;
    @JSONField(name = "ATTR_NAME")
    private String attrName;
    @JSONField(name = "ATTR_DESC")
    private String attrDesc;
    @JSONField(name = "IF_DEFAULT_VALUE")
    private String ifDefaultValue;
    @JSONField(name = "STATE")
    private String state;
    @JSONField(name = "STATE_DATE")
    private String stateDate;
    @JSONField(name = "MIN_VALUE")
    private String minValue;
    @JSONField(name = "MAX_VALUE")
    private String maxValue;
    @JSONField(name = "CREATE_DATE")
    private String createDate;
    @JSONField(name = "SHOW_ORDER")
    private String showOrder;
    @JSONField(name = "BILL_SEND_FLAG")
    private String billSendFlag;
    @JSONField(name = "EFF_DATE")
    private String effDate;
    @JSONField(name = "EXP_DATE")
    private String expDate;
    @JSONField(name = "DEFAULT_VALUE")
    private String defaultValue;
    @JSONField(name = "GRP_NO")
    private String grpNo;

    public String getPrcId() {
        return prcId;
    }

    public void setPrcId(String prcId) {
        this.prcId = prcId;
    }

    public String getSvcId() {
        return svcId;
    }

    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    public String getIfDefaultValue() {
        return ifDefaultValue;
    }

    public void setIfDefaultValue(String ifDefaultValue) {
        this.ifDefaultValue = ifDefaultValue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDate() {
        return stateDate;
    }

    public void setStateDate(String stateDate) {
        this.stateDate = stateDate;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(String showOrder) {
        this.showOrder = showOrder;
    }

    public String getBillSendFlag() {
        return billSendFlag;
    }

    public void setBillSendFlag(String billSendFlag) {
        this.billSendFlag = billSendFlag;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    @Override
    public String toString() {
        return "FamilyGoodsAttr{" +
                "prcId='" + prcId + '\'' +
                ", svcId='" + svcId + '\'' +
                ", attrId='" + attrId + '\'' +
                ", attrName='" + attrName + '\'' +
                ", attrDesc='" + attrDesc + '\'' +
                ", ifDefaultValue='" + ifDefaultValue + '\'' +
                ", state='" + state + '\'' +
                ", stateDate='" + stateDate + '\'' +
                ", minValue='" + minValue + '\'' +
                ", maxValue='" + maxValue + '\'' +
                ", createDate='" + createDate + '\'' +
                ", showOrder='" + showOrder + '\'' +
                ", billSendFlag='" + billSendFlag + '\'' +
                ", effDate='" + effDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", grpNo='" + grpNo + '\'' +
                '}';
    }
}
