package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.CssCodeDef;
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
    List<CssCodeDef> qryByCond(@Param("params") Map map);

    /**
     * GROUP_ID ='0' CODE_CLASS
     *
     * @param map
     * @return List<CssCodeDef>
     */
    List<CssCodeDef> qryByClass(@Param("params") Map map);

    /**
     * CODE_CLASS GROUP_ID
     *
     * @param map
     * @return List<CssCodeDef>
     */
    List<CssCodeDef> qryByClassGrpId(@Param("params") Map map);

    /**
     * @param map
     * @return List<CssCodeDef>
     */
    List<CssCodeDef> qryByCondAll(@Param("params") Map map);

    /**
     * END_VALUE_DESC 模糊查询
     *
     * @param map
     * @return List<CssCodeDef>
     */
    List<CssCodeDef> qryBySpecial(@Param("params") Map map);

    /**
     * 条件查询记录条数
     *
     * @param map
     * @return Map
     */
    Map qryByCondForNum(@Param("params") Map map);


}