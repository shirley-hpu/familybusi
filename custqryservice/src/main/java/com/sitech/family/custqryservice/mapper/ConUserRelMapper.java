package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.ConUserRel;
import org.springframework.stereotype.Repository;

/**
 * 帐务关系
 */
@Repository
public interface ConUserRelMapper {

    /**
     * @param servAcctId
     * @return
     */
    ConUserRel query(Long servAcctId);

}