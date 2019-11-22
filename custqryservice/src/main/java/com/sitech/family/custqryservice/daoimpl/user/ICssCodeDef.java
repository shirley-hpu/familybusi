package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.CssCodeDef;

import java.util.List;
import java.util.Map;

/**
 * 统一代码配置表
 *
 * @author shirley
 * @date created in 2019/4/19
 */
public interface ICssCodeDef {


    /**
     * @param map
     */
    List<CssCodeDef> qryByCond(Map map);

    /**
     * @param map
     */
    List<CssCodeDef> qryByClass(Map map);

    /**
     * @param map
     */
    List<CssCodeDef> qryByClassGrpId(Map map);

    /**
     * @param map
     */
    List<CssCodeDef> qryByCondAll(Map map);

    /**
     * @param map
     */
    List<CssCodeDef> qryBySpecial(Map map);

    /**
     * @param map
     */
    Map qryByCondForNum(Map map);


}
