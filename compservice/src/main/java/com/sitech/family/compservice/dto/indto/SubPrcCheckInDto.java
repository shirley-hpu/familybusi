package com.sitech.family.compservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author guanqp
 * @Description  主资费校验indto
 * @date 2019/3/12 15:12
 */
public class SubPrcCheckInDto implements Serializable {

    @NotBlank(message = "160019$用户标识不能为空")
    @JSONField(name = "ID_NO")
    public String  idNo;

    @NotBlank(message = "160020$用户归属不能为空")
    @JSONField(name = "GROUP_ID")
    public String  groupId;

    @NotBlank(message = "160021$ACTION不能为空")
    @JSONField(name = "ACTION")
    public String  action;

    @NotBlank(message = "160022$POWER_CODE不能为空")
    @JSONField(name = "POWER_CODE")
    public String  powerCode;

    @NotBlank(message = "160023$父级定价ID不能为空")
    @JSONField(name = "PARPRC_ID")
    public String parprcId;

    @Valid
    @JSONField(name = "SEL_BUSI")
    @NotNull(message = "入参节点SEL_BUSI不能为空")
    private List<SelBusi> selBusi;

    @Valid
    @JSONField(name = "BUY_BUSI")
    @NotNull(message = "入参节点BUY_BUSI不能为空")
    private List<BuyBusi> buyBusi;

    public List<SelBusi> getSelBusi() {
        return selBusi;
    }

    public void setSelBusi(List<SelBusi> selBusi) {
        this.selBusi = selBusi;
    }

    public List<BuyBusi> getBuyBusi() {
        return buyBusi;
    }

    public void setBuyBusi(List<BuyBusi> buyBusi) {
        this.buyBusi = buyBusi;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode;
    }

    public String getParprcId() {
        return parprcId;
    }

    public void setParprcId(String parprcId) {
        this.parprcId = parprcId;
    }

    @Override
    public String toString() {
        return "SubPrcCheckInDto{" +
                "idNo='" + idNo + '\'' +
                ", groupId='" + groupId + '\'' +
                ", action='" + action + '\'' +
                ", powerCode='" + powerCode + '\'' +
                ", parprcId='" + parprcId + '\'' +
                ", selBusi=" + selBusi +
                ", buyBusi=" + buyBusi +
                '}';
    }
}
