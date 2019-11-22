package com.sitech.family.common.pubdto;

import java.io.Serializable;

/**
 * Created by xuwei on 2018/7/23.
 */
public final class LoginInfo implements Serializable {
    /**
     * 序列化编号
     */
    private static final long serialVersionUID = 94668975L;

    /**
     * 登录流水
     */
    private Long loginAccept;

    /**
     * 工号主键
     */
    private long systemUserId;

    /**
     * 工号
     */
    private String systemUserCode;
    /**
     * 密码
     */
    private String password;

    /**
     * 员工标识
     */
    private Long staffId;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 工号IP地址
     */
    private String ipAddress;

    /**
     * 组织编码
     */
    private Long orgId;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 公共管理区域编码
     */
    private Long commonRegionId;

    /**
     * 公共管理区域集团编码
     */
    private String regionCode;

    /**
     * 公共管理区域名称
     */
    private String regionName;
    /**
     * 公共管理区域类型
     */
    private String regionType;

    /**
     * 登录类型(客户经理，管控人员)
     */
    private String loginType;

    /**
     * 是否是管控
     */
    private String isManager;

    /**
     * 本地网标识
     */
    private Long lanId;

    /**
     * 本地网名称
     */
    private String lanName;

    /**
     * 行政区域编码
     */
    private Long locationId;

    /**
     * 行政区域名称
     */
    private String locationName;

    /**
     * 渠道编码
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 工号权限等级
     */
    private String powerRight;

    /**
     * 距离工号密码失效天数
     */
    private Integer invadate;

    /**
     * 统一版本
     */
    private String unify;

    /**
     * 合作伙伴ID－－增值业务使用
     */
    private Long partnerId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 租户代码
     */
    private String tenancyCode = "999";

    /**
     * 首次登录标识
     */
    private String loginFlag;

    /**
     * 外网工号平台归属Id
     */
    private String bak2;
    /**
     * 工号类型
     */
    private String sysuserType;
    /**
     * 工号等级
     */
    private String sysuserGrade;
    /**
     *
     * 工号等级级别
     */
    private String sysuserGradeOrder;
    /**
     * 工号类型名称
     */
    private String sysuserTypeName;

    /**
     * 工号级别名称
     */
    private String sysuserGradeName;
    /**
     * 子工号标识,约定值为Z
     */
    private String childFlag;

    /**
     * 创建子工号的母工号(登录的系统用户名称)
     */
    private String createOptid;

    /**
     * 工号绑定的手机号码
     */
    private String mobilePhone;
    /**
     *
     * @param 数据源标识
     */
    private String dbShardingSlot;

    public String getDbShardingSlot() {
        return dbShardingSlot;
    }
    public void setDbShardingSlot(String dbShardingSlot) {
        this.dbShardingSlot = dbShardingSlot;
    }
    public void setSystemUserId(long systemUserId) {
        this.systemUserId = systemUserId;
    }
    public String getSysuserType() {
        return sysuserType;
    }

    public void setSysuserType(String sysuserType) {
        this.sysuserType = sysuserType;
    }

    public String getSysuserGrade() {
        return sysuserGrade;
    }

    public void setSysuserGrade(String sysuserGrade) {
        this.sysuserGrade = sysuserGrade;
    }

    /**
     * @return the tenancyCode
     */
    public String getTenancyCode() {
        return tenancyCode;
    }

    /**
     * @param tenancyCode
     *            the tenancyCode to set
     */
    public void setTenancyCode(String tenancyCode) {
        this.tenancyCode = tenancyCode;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getUnify() {
        return unify;
    }

    public void setUnify(String unify) {
        this.unify = unify;
    }

    public Integer getInvadate() {
        return invadate;
    }

    public void setInvadate(Integer invadate) {
        this.invadate = invadate;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLanName() {
        return lanName;
    }

    public void setLanName(String lanName) {
        this.lanName = lanName;
    }

    public Long getLanId() {
        return lanId;
    }

    public void setLanId(Long lanId) {
        this.lanId = lanId;
    }

    public Long getLoginAccept() {
        return loginAccept;
    }

    public void setLoginAccept(Long loginAccept) {
        this.loginAccept = loginAccept;
    }

    public Long getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Long systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getSystemUserCode() {
        return systemUserCode;
    }

    public void setSystemUserCode(String systemUserCode) {
        this.systemUserCode = systemUserCode;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public Long getCommonRegionId() {
        return commonRegionId;
    }

    public void setCommonRegionId(Long commonRegionId) {
        this.commonRegionId = commonRegionId;
    }

    public String getPowerRight() {
        return powerRight;
    }

    public void setPowerRight(String powerRight) {
        this.powerRight = powerRight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getChildFlag() {
        return childFlag;
    }

    public void setChildFlag(String childFlag) {
        this.childFlag = childFlag;
    }

    public String getCreateOptid() {
        return createOptid;
    }

    public void setCreateOptid(String createOptid) {
        this.createOptid = createOptid;
    }


    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getSysuserTypeName() {
        return sysuserTypeName;
    }

    public void setSysuserTypeName(String sysuserTypeName) {
        this.sysuserTypeName = sysuserTypeName;
    }

    public String getSysuserGradeName() {
        return sysuserGradeName;
    }

    public void setSysuserGradeName(String sysuserGradeName) {
        this.sysuserGradeName = sysuserGradeName;
    }
    public String getSysuserGradeOrder() {
        return sysuserGradeOrder;
    }
    public void setSysuserGradeOrder(String sysuserGradeOrder) {
        this.sysuserGradeOrder = sysuserGradeOrder;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
