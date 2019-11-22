package com.sitech.family.dao.user;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.CrmToBossStateInfo;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/19 9:46
 */
public interface ICrmToBossStateDao {
    /**
     * 新建家庭用户状态变化信息
     * @param crmToBossStateInfo
     * @return ReturnDto
     */
    ReturnDto create(CrmToBossStateInfo crmToBossStateInfo);
    /**
     * 修改家庭用户状态变化
     * @param crmToBossStateInfo
     */
    ReturnDto modify(CrmToBossStateInfo crmToBossStateInfo);

    /**
     * 查询家庭用户状态变化
     * @param crmToBossStateInfo
     * @return crmToBossStateInfo
     */
    CrmToBossStateInfo query(CrmToBossStateInfo crmToBossStateInfo);
}
