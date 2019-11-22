package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 成员删除服务入参
 */
@ApiModel(value = "FamilyMbrDelInDto", description = "成员删除信息入参")
public class FamilyMbrDelInDto implements Serializable {

    @JSONField(name = "MEMBER_INFO_LIST")
    @NotNull(message = "MEMBER_INFO_LIST")
    @ApiModelProperty(name = "MEMBER_INFO_LIST", value = "成员删除信息", required = true)
    private List<FamilyMbrDel> familyMbrDelList;

    @ApiModel(value = "FamilyMbrDel", description = "成员删除信息")
    public static class FamilyMbrDel {

        @JSONField(name = "GROUP_ID")
        @NotBlank(message = "GROUP_ID")
        @ApiModelProperty(name = "GROUP_ID", value = "群实例标识", required = true)
        private String groupId;

        @JSONField(name = "ID_NO")
        @NotBlank(message = "ID_NO")
        @ApiModelProperty(name = "ID_NO", value = "用户标识", required = true)
        private String idNo;

        @JSONField(name = "CONTRACT_NO")
        @NotBlank(message = "CONTRACT_NO")
        @ApiModelProperty(name = "CONTRACT_NO", value = "默认帐户标识", required = true)
        private String contractNo;

        @JSONField(name = "MEMBER_ID")
        @NotBlank(message = "MEMBER_ID")
        @ApiModelProperty(name = "MEMBER_ID", value = "成员标识", required = true)
        private String memberId;

        @JSONField(name = "SERVICE_NO")
        //@NotBlank(message = "SERVICE_NO")
        @ApiModelProperty(name = "SERVICE_NO", value = "接入号")
        private String serviceNo;

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getContractNo() {
            return contractNo;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getServiceNo() {
            return serviceNo;
        }

        public void setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
        }

        @Override
        public String toString() {
            return "FamilyMbrDelInDto{" +
                    "groupId='" + groupId + '\'' +
                    ", idNo='" + idNo + '\'' +
                    ", contractNo='" + contractNo + '\'' +
                    ", memberId='" + memberId + '\'' +
                    ", serviceNo='" + serviceNo + '\'' +
                    '}';
        }
    }

    public List<FamilyMbrDel> getFamilyMbrDelList() {
        return familyMbrDelList;
    }

    public void setFamilyMbrDelList(List<FamilyMbrDel> familyMbrDelList) {
        this.familyMbrDelList = familyMbrDelList;
    }

    @Override
    public String toString() {
        return "FamilyMbrDelInDto{" +
                "familyMbrDelList=" + familyMbrDelList +
                '}';
    }
}
