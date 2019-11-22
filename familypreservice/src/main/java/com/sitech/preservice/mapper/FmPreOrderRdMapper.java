package com.sitech.preservice.mapper;

import com.sitech.preservice.dto.FmPreOrderRdOutDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FmPreOrderRdMapper {

    int commit(Map map);

    List<FmPreOrderRdOutDto> query(Map indata);
}
