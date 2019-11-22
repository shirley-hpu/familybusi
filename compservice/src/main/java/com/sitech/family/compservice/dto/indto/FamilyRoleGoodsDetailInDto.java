package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-09 15:02
 * @Version: 1.0
 */
public class FamilyRoleGoodsDetailInDto implements Serializable {

    @JSONField(name = "PKGPRC_ID")
    @NotBlank(message = "PKGPRC_ID不能为空")
    private String pkgprcId;

    @JSONField(name = "ELEMENT_ID")
    @NotBlank(message = "ELEMENT_ID不能为空")
    private String elementId;

    public String getPkgprcId() {
        return pkgprcId;
    }

    public void setPkgprcId(String pkgprcId) {
        this.pkgprcId = pkgprcId;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    @Override
    public String toString() {
        return "FamilyRoleGoodsDetailInDto{" +
                "pkgprcId='" + pkgprcId + '\'' +
                ", elementId='" + elementId + '\'' +
                '}';
    }
}
