package com.sitech.preservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class StandardCoverInDto implements Serializable {

    @JSONField(name = "CELL_INTID")
    @NotBlank(message = "")
    private String cellIniId;

    @JSONField(name = "BUILDING_INTID")
    @NotBlank(message = "")
    private String buindingIntId;

    @JSONField(name = "UNIT_INTID")
    @NotBlank(message = "")
    private String unitIntId;

    @JSONField(name = "ROOM_INTID")
    @NotBlank(message = "")
    private String roomIntId;

    @Override
    public String toString() {
        return "StandardCoverInDto{" +
                "cellIniId='" + cellIniId + '\'' +
                ", buindingIntId='" + buindingIntId + '\'' +
                ", unitIntId='" + unitIntId + '\'' +
                ", roomIntId='" + roomIntId + '\'' +
                '}';
    }

    public String getCellIniId() {
        return cellIniId;
    }

    public void setCellIniId(String cellIniId) {
        this.cellIniId = cellIniId;
    }

    public String getBuindingIntId() {
        return buindingIntId;
    }

    public void setBuindingIntId(String buindingIntId) {
        this.buindingIntId = buindingIntId;
    }

    public String getUnitIntId() {
        return unitIntId;
    }

    public void setUnitIntId(String unitIntId) {
        this.unitIntId = unitIntId;
    }

    public String getRoomIntId() {
        return roomIntId;
    }

    public void setRoomIntId(String roomIntId) {
        this.roomIntId = roomIntId;
    }
}
