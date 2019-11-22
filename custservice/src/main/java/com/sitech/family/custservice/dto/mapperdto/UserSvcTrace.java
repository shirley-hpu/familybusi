package com.sitech.family.custservice.dto.mapperdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description 服务实例轨迹信息
 * @date 2018/12/17 17:26
 */
public class UserSvcTrace implements Serializable {

    private BigDecimal svcinsId;

    private BigDecimal prodprcinsId;

    private Long idNo;

    private String svcId;

    private String svcType;

    private Date effDate;

    private Date expDate;

    private String state;

    private Date stateDate;

    private String loginNo;

    private Long loginAccept;

    private Date opTime;

    private String opCode;

    private String servOrderId;

    private String finishFlag;

    private Date updateTime;

    private String updateType;

    private String updateCode;

    private String updateLogin;

    private Long updateAccept;

    private Integer updateDate;

    public BigDecimal getSvcinsId() {
        return svcinsId;
    }

    public void setSvcinsId(BigDecimal svcinsId) {
        this.svcinsId = svcinsId;
    }

    public BigDecimal getProdprcinsId() {
        return prodprcinsId;
    }

    public void setProdprcinsId(BigDecimal prodprcinsId) {
        this.prodprcinsId = prodprcinsId;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getSvcId() {
        return svcId;
    }

    public void setSvcId(String svcId) {
        this.svcId = svcId;
    }

    public String getSvcType() {
        return svcType;
    }

    public void setSvcType(String svcType) {
        this.svcType = svcType;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
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

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
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

    public Long getUpdateAccept() {
        return updateAccept;
    }

    public void setUpdateAccept(Long updateAccept) {
        this.updateAccept = updateAccept;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserSvcTrace{" +
                "svcinsId=" + svcinsId +
                ", prodprcinsId=" + prodprcinsId +
                ", idNo=" + idNo +
                ", svcId='" + svcId + '\'' +
                ", svcType='" + svcType + '\'' +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", state='" + state + '\'' +
                ", stateDate=" + stateDate +
                ", loginNo='" + loginNo + '\'' +
                ", loginAccept=" + loginAccept +
                ", opTime=" + opTime +
                ", opCode='" + opCode + '\'' +
                ", servOrderId='" + servOrderId + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", updateTime=" + updateTime +
                ", updateType='" + updateType + '\'' +
                ", updateCode='" + updateCode + '\'' +
                ", updateLogin='" + updateLogin + '\'' +
                ", updateAccept=" + updateAccept +
                ", updateDate=" + updateDate +
                '}';
    }
}
