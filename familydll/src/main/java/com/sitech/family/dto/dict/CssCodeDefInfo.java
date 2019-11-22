package com.sitech.family.dto.dict;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共配置数据
 */
public class CssCodeDefInfo implements Serializable {
    private String codeClass;
    private String classDesc;
    private String classLevel;
    private String codeId;
    private String valueId;
    private String idDesc;
    private String idType;
    private String beginValue;
    private String beginValueDesc;
    private String endValue;
    private String endValueDesc;
    private String otherValue;
    private String groupId;
    private Date effDate;
    private Date expDate;
    private String remark;
    private String bak;

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(String idDesc) {
        this.idDesc = idDesc;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getBeginValue() {
        return beginValue;
    }

    public void setBeginValue(String beginValue) {
        this.beginValue = beginValue;
    }

    public String getBeginValueDesc() {
        return beginValueDesc;
    }

    public void setBeginValueDesc(String beginValueDesc) {
        this.beginValueDesc = beginValueDesc;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public String getEndValueDesc() {
        return endValueDesc;
    }

    public void setEndValueDesc(String endValueDesc) {
        this.endValueDesc = endValueDesc;
    }

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    @Override
    public String toString() {
        return "CssCodeDef{" +
                "codeClass='" + codeClass + '\'' +
                ", classDesc='" + classDesc + '\'' +
                ", classLevel='" + classLevel + '\'' +
                ", codeId='" + codeId + '\'' +
                ", valueId='" + valueId + '\'' +
                ", idDesc='" + idDesc + '\'' +
                ", idType='" + idType + '\'' +
                ", beginValue='" + beginValue + '\'' +
                ", beginValueDesc='" + beginValueDesc + '\'' +
                ", endValue='" + endValue + '\'' +
                ", endValueDesc='" + endValueDesc + '\'' +
                ", otherValue='" + otherValue + '\'' +
                ", groupId='" + groupId + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", remark='" + remark + '\'' +
                ", bak='" + bak + '\'' +
                '}';
    }
}
