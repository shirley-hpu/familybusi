package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.AccountRel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账户关系实体
 */
@Repository
public interface AccountRelMapper {

    /**
     * @param accountRel
     * @return
     */
    void create(AccountRel accountRel);

    /**
     * @param accountRel
     * @return
     */
    void insert(AccountRel accountRel);

    /**
     * @param servAcctId
     * @return
     */
    void drop(Long servAcctId);

    /**
     * @param accountRel
     * @return
     */
    void modify(AccountRel accountRel);

    /**
     * @param servAcctId
     * @return AccountRel
     */
    AccountRel query(Long servAcctId);

    /**
     * @param map
     * @return List<AccountRel>
     */
    List<AccountRel> qryContractRltList(@Param("params") Map map);

    /**
     * @param map
     * @return List<AccountRel>
     */
    List<AccountRel> qryContractRltHisList(@Param("inparams") Map map);

}