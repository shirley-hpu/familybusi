package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.AccountRel;
import com.sitech.family.dto.ReturnDto;

import java.util.List;
import java.util.Map;

/**
 * @author shirley
 * @description 账户关系实体
 * @date created in 2018/12/3
 * @modified
 */
public interface IContractRlt {

    /**
     * 创建账户关系信息
     *
     * @param accountRel
     * @return ReturnDto
     */
    ReturnDto create(AccountRel accountRel);

    /**
     * 删除账户关系信息
     *
     * @param accountRel
     * @return ReturnDto
     */
    ReturnDto drop(AccountRel accountRel);

    /**
     * 更新账户关系信息
     *
     * @param accountRel
     * @return ReturnDto
     */
    ReturnDto modify(AccountRel accountRel);

    /**
     * 查询账户关系信息
     *
     * @param servAcctId
     * @return AccountRel
     */
    AccountRel query(Long servAcctId);

    /**
     * 查询账户关系信息
     *
     * @param map
     * @return List<AccountRel>
     */
    List<AccountRel> qryContractRltList(Map map);

    /**
     * 查询历史账户信息信息
     *
     * @param map
     * @return List<AccountRel>
     */
    List<AccountRel> qryContractRltHisList(Map map);

}
