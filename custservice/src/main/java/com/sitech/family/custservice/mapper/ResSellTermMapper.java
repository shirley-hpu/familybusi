package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ResSellTermMapper {

    void create(ResSellTerm resSellTerm);

    void insert(ResSellTerm resSellTerm);

    void modify(ResSellTerm resSellTerm);

    void drop(ResSellTerm resSellTerm);

    ResSellTerm query(@Param("opTime") Date opTime,@Param("resourceNo") String resourceNo,@Param("sellSerialNo") Long sellSerialNo);

    List<ResSellTerm> qryResSellTermList(@Param("params") Map map);

    List<ResSellTerm> qryResSellTermHisList(@Param("inparams") Map map);
}
