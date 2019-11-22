package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.FeePrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FeePriceMapper {

    FeePrice query(@Param("groupId") String groupId,@Param("svcId") String svcId,@Param("actionId") String actionId,@Param("busiMode") String busiMode,@Param("feeCode") String feeCode,@Param("feeType") String feeType,@Param("effDate") Date effDate);
}
