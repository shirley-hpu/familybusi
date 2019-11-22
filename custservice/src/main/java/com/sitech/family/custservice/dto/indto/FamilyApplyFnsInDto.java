package com.sitech.family.custservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wusm
 * @description
 * @date 2019/4/19 15:50
 */
public class FamilyApplyFnsInDto implements Serializable {

    @JSONField(name = "ID_NO")
    @NotBlank(message = "入参ID_NO不能为空")
    @ApiModelProperty(value = "用户标识", name = "idNo", required = true)
    private String idNo;

    @JSONField(name = "OBJECT_ID")
    @NotBlank(message = "入参OBJECT_ID不能为空")
    @ApiModelProperty(value = "成员号码", name = "objectId", required = true)
    private String objectId;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "FamilyApplyFnsInDto{" +
                "idNo='" + idNo + '\'' +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
