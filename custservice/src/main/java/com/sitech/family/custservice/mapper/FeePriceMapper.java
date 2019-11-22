package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.FeePrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FeePriceMapper {

    void create(FeePrice feePrice);

    void modify(FeePrice feePrice);

    void drop(FeePrice feePrice);

    FeePrice query(@Param("groupId") String groupId,@Param("svcId") String svcId,@Param("actionId") String actionId,@Param("busiMode") String busiMode,@Param("feeCode") String feeCode,@Param("feeType") String feeType,@Param("effDate") Date effDate);
}
