package com.sitech.preservice.mapper;

import com.sitech.preservice.dto.CssCodeDef;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 统一代码配置表
 */
@Repository
public interface CssCodeDefMapper {

    /**
     * @param map
     * @return List<CssCodeDef>
     */
    List<CssCodeDef> qryByCondAll(@Param("params") Map map);


}