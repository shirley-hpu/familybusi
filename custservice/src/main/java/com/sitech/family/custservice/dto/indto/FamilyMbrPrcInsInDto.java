package com.sitech.family.custservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class FamilyMbrPrcInsInDto implements Serializable {

    @JSONField(name = "ID_NO")
    @NotBlank(message = "入参ID_NO不能为空")
    private String idNo;

    @JSONField(name = "GROUP_ID")
    @NotBlank(message = "入参GROUP_ID不能为空")
    private String groupId;

    @JSONField(name = "MEMBER_ID")
    @NotBlank(message = "入参MEMBER_ID不能为空")
    private String memberId;

    @JSONField(name = "MBRPRCINSLIST")
    private List<MbrPrcInsInfo> mbrPrcInsInfoList;

    public static class MbrPrcInsInfo implements Serializable {

        @JSONField(name = "EXP_DATE")
        @NotBlank(message = "入参EXP_DATE不能为空")
        private String expDate;

        @JSONField(name = "PRODPRCINS_ID")
        @NotBlank(message = "入参PRODPRCINS_ID不能为空")
        private String prodprcinsId;

        public String getExpDate() {
            return expDate;
        }

        public void setExpDate(String expDate) {
            this.expDate = expDate;
        }

        public String getProdprcinsId() {
            return prodprcinsId;
        }

        public void setProdprcinsId(String prodprcinsId) {
            this.prodprcinsId = prodprcinsId;
        }

        @Override
        public String toString() {
            return "MbrPrcInsInfo{" +
                    "expDate='" + expDate + '\'' +
                    ", prodprcinsId='" + prodprcinsId + '\'' +
                    '}';
        }
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<MbrPrcInsInfo> getMbrPrcInsInfoList() {
        return mbrPrcInsInfoList;
    }

    public void setMbrPrcInsInfoList(List<MbrPrcInsInfo> mbrPrcInsInfoList) {
        this.mbrPrcInsInfoList = mbrPrcInsInfoList;
    }

    @Override
    public String toString() {
        return "FamilyMbrPrcInsInDto{" +
                "idNo='" + idNo + '\'' +
                ", groupId='" + groupId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", mbrPrcInsInfoList=" + mbrPrcInsInfoList +
                '}';
    }
}
