package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CrmToBossStateMapper {

    void create(CrmToBossState crmToBossState);

    void insert(CrmToBossState crmToBossState);

    void modify(CrmToBossState crmToBossState);

    void drop(Long idNo);

    CrmToBossState query(Long idNo);

    List<CrmToBossState> qryCrmToBossStateList(@Param("params") Map map);

    List<CrmToBossState> qryCrmToBossStateHisList(@Param("inparams") Map map);
}
