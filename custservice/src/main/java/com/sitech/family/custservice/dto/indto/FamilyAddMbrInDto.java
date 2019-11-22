package com.sitech.family.custservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import com.sitech.family.common.pubdto.FamilyMbrAdd;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * @author wusm
 * @description
 * @date 2019/3/28 15:39
 */
public class FamilyAddMbrInDto implements Serializable {

    @Valid
    @JSONField(name = "USERGROUPMBRINFOLIST")
    @ApiModelProperty(value = "群成员关系list节点",name = "familyUserGroupMbrList")
    private List<FamilyMbrAdd> familyMbrAddList;

    public List<FamilyMbrAdd> getFamilyMbrAddList() {
        return familyMbrAddList;
    }

    public void setFamilyMbrAddList(List<FamilyMbrAdd> familyMbrAddList) {
        this.familyMbrAddList = familyMbrAddList;
    }

    @Override
    public String toString() {
        return "FamilyAddMbrInDto{" +
                "familyMbrAddList=" + familyMbrAddList +
                '}';
    }
}
