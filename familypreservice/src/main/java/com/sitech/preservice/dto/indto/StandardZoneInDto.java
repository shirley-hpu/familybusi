package com.sitech.preservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class StandardZoneInDto implements Serializable {

    @JSONField(name="CITY_NAME")
    @NotBlank(message = "地市不能为空")
    private String cityName;

    @JSONField(name = "COUNTRY_NAME")
    private String countryName;

    @JSONField(name = "CELL_NAME")
    @NotBlank(message = "小区名不能为空")
    private String cellName;

    @Override
    public String toString() {
        return "StandardZoneInDto{" +
                "cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", cellName='" + cellName + '\'' +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }
}
