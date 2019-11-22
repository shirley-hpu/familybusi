package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.ResSellTerm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ResSellTermMapper {

    ResSellTerm query(@Param("opTime") Date opTime,@Param("resourceNo") String resourceNo,@Param("sellSerialNo") Long sellSerialNo);

}
