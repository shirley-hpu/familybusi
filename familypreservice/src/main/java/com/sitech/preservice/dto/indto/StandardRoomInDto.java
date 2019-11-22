package com.sitech.preservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class StandardRoomInDto implements Serializable {

    @JSONField(name = "CELL_INTID")
    @NotBlank(message = "小区不能为空")
    private String cellIntId;

    @JSONField(name = "BUILDING_INTID")
    @NotBlank(message = "楼不能为空")
    private String buildingIntId;

    @JSONField(name = "UNIT_INTID")
    @NotBlank(message = "单元不能为空")
    private String unitIntId;

    @Override
    public String toString() {
        return "StandardRoomInDto{" +
                "cellIntId='" + cellIntId + '\'' +
                ", buildingIntId='" + buildingIntId + '\'' +
                ", unitIntId='" + unitIntId + '\'' +
                '}';
    }

    public String getCellIntId() {
        return cellIntId;
    }

    public void setCellIntId(String cellIntId) {
        this.cellIntId = cellIntId;
    }

    public String getBuildingIntId() {
        return buildingIntId;
    }

    public void setBuildingIntId(String buildingIntId) {
        this.buildingIntId = buildingIntId;
    }

    public String getUnitIntId() {
        return unitIntId;
    }

    public void setUnitIntId(String unitIntId) {
        this.unitIntId = unitIntId;
    }
}
