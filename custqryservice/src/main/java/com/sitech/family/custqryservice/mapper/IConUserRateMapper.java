package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.ConUserRate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/3 18:10
 */
@Repository
public interface IConUserRateMapper {

    ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode);

}
