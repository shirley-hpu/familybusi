package com.sitech.family.configservice.mapper;

import com.sitech.family.configservice.dll.dto.CsMenuConfigDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface ReqInfoMapper {
    
    List<CsMenuConfigDto> qryMenuList(String ownerBottom);
    List<CsMenuConfigDto> qryMenuListChild(@Param("ids")List<String> ids);
}
