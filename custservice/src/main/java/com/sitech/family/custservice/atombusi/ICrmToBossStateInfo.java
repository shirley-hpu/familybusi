package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.CrmToBossStateInfo;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 15:42
 */
public interface ICrmToBossStateInfo {

    /**
     * 新建家庭用户状态变化信息
     * @param crmToBossStateInfo
     * @return ReturnDto
     */
    void create(CrmToBossStateInfo crmToBossStateInfo);

    /**
     * 删除家庭用户状态变化信息
     * @param crmToBossStateInfo
     * @return ReturnDto
     */
    ReturnDto drop(CrmToBossStateInfo crmToBossStateInfo);

    /**
     * 修改家庭用户状态变化
     * @param crmToBossStateInfo
     * @return ReturnDto
     */
    void modify(CrmToBossStateInfo crmToBossStateInfo);

    /**
     * 查询家庭用户状态变化
     * @param crmToBossStateInfo
     * @return crmToBossStateInfo
     */
    CrmToBossStateInfo query(CrmToBossStateInfo crmToBossStateInfo);
}
