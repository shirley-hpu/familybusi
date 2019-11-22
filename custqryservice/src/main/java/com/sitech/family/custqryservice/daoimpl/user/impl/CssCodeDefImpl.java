package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.ICssCodeDef;
import com.sitech.family.custqryservice.dto.mapperdto.CssCodeDef;
import com.sitech.family.custqryservice.mapper.CssCodeDefMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 统一代码配置表
 *
 * @author shirley
 * @date created in 2019/4/19
 */
@Component
public class CssCodeDefImpl implements ICssCodeDef {


    @Autowired
    private CssCodeDefMapper cssCodeDefMapper;


    @Override
    public List<CssCodeDef> qryByCond(Map map) {

        List<CssCodeDef> list;
        try {

            list = cssCodeDefMapper.qryByCond(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDef> qryByClass(Map map) {

        List<CssCodeDef> list;
        try {

            list = cssCodeDefMapper.qryByClass(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDef> qryByClassGrpId(Map map) {

        List<CssCodeDef> list;
        try {

            list = cssCodeDefMapper.qryByClassGrpId(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDef> qryByCondAll(Map map) {

        List<CssCodeDef> list;
        try {

            list = cssCodeDefMapper.qryByCondAll(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return list;
    }

    /**
     * END_VALUE_DESC 模糊查询
     *
     * @param map
     * @return
     */
    @Override
    public List<CssCodeDef> qryBySpecial(Map map) {

        List<CssCodeDef> list;
        try {

            list = cssCodeDefMapper.qryBySpecial(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return list;
    }

    /**
     * 条件查询记录条数
     *
     * @param map
     * @return
     */
    @Override
    public Map qryByCondForNum(Map map) {

        Map outMap;
        try {

            outMap = cssCodeDefMapper.qryByCondForNum(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return outMap;
    }
}
