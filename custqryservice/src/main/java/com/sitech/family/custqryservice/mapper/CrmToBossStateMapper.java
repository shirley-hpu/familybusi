package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.CrmToBossState;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmToBossStateMapper {

    CrmToBossState query(Long idNo);

}
