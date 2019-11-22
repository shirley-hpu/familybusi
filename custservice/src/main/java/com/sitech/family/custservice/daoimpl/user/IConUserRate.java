package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.ConUserRate;
import com.sitech.family.dto.ReturnDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/10 09:15
 */
public interface IConUserRate {

    /**
     * 创建账户关系信息
     * @param conUserRate
     * @return ReturnDto
     */
    ReturnDto create(ConUserRate conUserRate) ;

    /**
     * 更新账户关系信息
     * @param conUserRate
     * @return ReturnDto
     */
    ReturnDto modify(ConUserRate conUserRate);

    /**
     * 删除账户关系信息
     * @param conUserRate
     * @return ReturnDto
     */
    ReturnDto drop(ConUserRate conUserRate);

    /**
     * 查询账户关系信息
     * @param
     * @return List<ConUserRate>
     */
    ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode);

    /**
     * 查询账户信息
     * @param map
     * @return List<ConUserRate>
     */
    List<ConUserRate> qryConUserRateList(Map map);

    /**
     * 查询历史账户信息信息
     * @param map
     * @return List<ConUserRate>
     */
    List<ConUserRate> qryConUserRateHisList(Map map);
}
