package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.ConUserRate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/3 18:10
 */
@Repository
public interface IConUserRateMapper {

    void create(ConUserRate conUserRate);

    void insert(ConUserRate conUserRate);

    void modify(ConUserRate conUserRate);

    void drop(ConUserRate conUserRate);

    ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode);

    List<ConUserRate> qryConUserRateList(@Param("params") Map map);

    List<ConUserRate> qryConUserRateHisList(@Param("inparams") Map map);
}
