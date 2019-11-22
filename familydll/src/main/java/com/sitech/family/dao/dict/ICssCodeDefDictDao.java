package com.sitech.family.dao.dict;

import com.sitech.family.dto.dict.CssCodeDefInfo;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/4/19
 */
public interface ICssCodeDefDictDao {


    /**
     * @param map
     */
    List<CssCodeDefInfo> qryByCond(Map map);

    /**
     * @param map
     */
    List<CssCodeDefInfo> qryByClass(Map map);

    /**
     * @param map
     */
    List<CssCodeDefInfo> qryByClassGrpId(Map map);

    /**
     * @param map
     */
    List<CssCodeDefInfo> qryByCondAll(Map map);

    /**
     * @param map
     */
    List<CssCodeDefInfo> qryBySpecial(Map map);

    /**
     * @param map
     */
    Map qryByCondForNum(Map map);
}
