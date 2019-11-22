package com.sitech.family.custqryservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guanqp
 * @description 服务实例轨迹信息
 * @date 2018/12/28
 */
public class UserSvcAttrTrace  implements Serializable {

    private BigDecimal svcinsId;
    private String svcId;
    private String attrId;
    private String attrNo;
    private Date effDate;
    private long updateAccept;
    private String updateType;
    private long idNo;
    private String attrValue;
    private String grpNo;
    private Date expDate;
    private String loginNo;
    private long loginAccept;
    private Date opTime;
    private String opCode;
    private String servOrderId;
    private String finishFlag;
    private Date updateTime;
    private int updateDate;
    private String updateCode;
    private String updateLogin;

    public BigDecimal getSvcinsId() {
        return svcinsId;
    }

    public void setSvcinsId(BigDecimal svcinsId) {
        this.svcinsId = svcinsId;
    }

    public String getSvcId() {
        return svcId;
    }

    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrNo() {
        return attrNo;
    }

    public void setAttrNo(String attrNo) {
        this.attrNo = attrNo;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public long getIdNo() {
        return idNo;
    }

    public void setIdNo(long idNo) {
        this.idNo = idNo;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getServOrderId() {
        return servOrderId;
    }

    public void setServOrderId(String servOrderId) {
        this.servOrderId = servOrderId;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(int updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String updateLogin) {
        this.updateLogin = updateLogin;
    }

    @Override
    public String toString() {
        return "UserSvcAttrTrace{" +
                "svcinsId=" + svcinsId +
                ", svcId='" + svcId + '\'' +
                ", attrId='" + attrId + '\'' +
                ", attrNo='" + attrNo + '\'' +
                ", effDate=" + effDate +
                ", updateAccept=" + updateAccept +
                ", updateType='" + updateType + '\'' +
                ", idNo=" + idNo +
                ", attrValue='" + attrValue + '\'' +
                ", grpNo='" + grpNo + '\'' +
                ", expDate=" + expDate +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", servOrderId='" + servOrderId + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", updateTime=" + updateTime +
                ", updateDate=" + updateDate +
                ", updateCode='" + updateCode + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                '}';
    }
}
