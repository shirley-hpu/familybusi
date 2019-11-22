package com.sitech.family.configservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 13:37
 */
public class CsMenuConfigOutDto implements Serializable {
    @JSONField
    private String menuId;
    private String menuName;
    private String menuIcon;
    private String parentMenuId;
    private String ownerBottom;
    private String menuPosition;
    private String menuUrl;
    private String urlParameter;
    private String sortNum;
    private String isEnable;
    private String menuClass;
    private String menuStyle;
    private String unit;
    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMenuPosition() {
        return menuPosition;
    }

    public void setMenuPosition(String menuPosition) {
        this.menuPosition = menuPosition;
    }

    public String getUrlParameter() {
        return urlParameter;
    }

    public void setUrlParameter(String urlParameter) {
        this.urlParameter = urlParameter;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getMenuStyle() {
        return menuStyle;
    }

    public void setMenuStyle(String menuStyle) {
        this.menuStyle = menuStyle;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getOwnerBottom() {
        return ownerBottom;
    }

    public void setOwnerBottom(String ownerBottom) {
        this.ownerBottom = ownerBottom;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
}
