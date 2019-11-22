package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.ICssCodeDef;
import com.sitech.family.custqryservice.dto.mapperdto.CssCodeDef;
import com.sitech.family.dao.dict.ICssCodeDefDictDao;
import com.sitech.family.dto.dict.CssCodeDefInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 统一代码配置表
 *
 * @author shirley
 * @date created in 2019/4/19
 */
@Component
public class CssCodeDefDictDaoImpl implements ICssCodeDefDictDao {

    private final ICssCodeDef cssCodeDefImpl;

    @Autowired
    public CssCodeDefDictDaoImpl(ICssCodeDef cssCodeDefImpl) {
        this.cssCodeDefImpl = cssCodeDefImpl;
    }

    @Override
    public List<CssCodeDefInfo> qryByCond(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        List<CssCodeDefInfo> list = new ArrayList<>();

        try {
            List<CssCodeDef> cssCodeDefList = cssCodeDefImpl.qryByCond(map);
            if (StringUtil.isNotEmptyOrNull(cssCodeDefList)) {

                for (CssCodeDef temp : cssCodeDefList) {
                    CssCodeDefInfo cssCodeDefInfo = new CssCodeDefInfo();
                    cssCodeDefInfo.setCodeClass(temp.getCodeClass());
                    cssCodeDefInfo.setClassDesc(temp.getClassDesc());
                    cssCodeDefInfo.setClassLevel(temp.getClassLevel());
                    cssCodeDefInfo.setCodeId(temp.getCodeId());
                    cssCodeDefInfo.setBeginValue(temp.getBeginValue());
                    cssCodeDefInfo.setBeginValueDesc(temp.getBeginValueDesc());
                    cssCodeDefInfo.setEffDate(temp.getEffDate());
                    cssCodeDefInfo.setExpDate(temp.getExpDate());
                    cssCodeDefInfo.setEndValue(temp.getEndValue());
                    cssCodeDefInfo.setEndValueDesc(temp.getEndValueDesc());
                    cssCodeDefInfo.setGroupId(temp.getGroupId());
                    cssCodeDefInfo.setIdDesc(temp.getIdDesc());
                    cssCodeDefInfo.setIdType(temp.getIdType());
                    cssCodeDefInfo.setOtherValue(temp.getOtherValue());
                    cssCodeDefInfo.setRemark(temp.getRemark());
                    cssCodeDefInfo.setBak(temp.getBak());
                    cssCodeDefInfo.setValueId(temp.getValueId());
                    list.add(cssCodeDefInfo);
                }
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDefInfo> qryByClass(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        List<CssCodeDefInfo> list = new ArrayList<>();

        try {
            List<CssCodeDef> cssCodeDefList = cssCodeDefImpl.qryByClass(map);
            if (StringUtil.isNotEmptyOrNull(cssCodeDefList)) {

                for (CssCodeDef temp : cssCodeDefList) {
                    CssCodeDefInfo cssCodeDefInfo = new CssCodeDefInfo();
                    cssCodeDefInfo.setCodeClass(temp.getCodeClass());
                    cssCodeDefInfo.setClassDesc(temp.getClassDesc());
                    cssCodeDefInfo.setClassLevel(temp.getClassLevel());
                    cssCodeDefInfo.setCodeId(temp.getCodeId());
                    cssCodeDefInfo.setBeginValue(temp.getBeginValue());
                    cssCodeDefInfo.setBeginValueDesc(temp.getBeginValueDesc());
                    cssCodeDefInfo.setEffDate(temp.getEffDate());
                    cssCodeDefInfo.setExpDate(temp.getExpDate());
                    cssCodeDefInfo.setEndValue(temp.getEndValue());
                    cssCodeDefInfo.setEndValueDesc(temp.getEndValueDesc());
                    cssCodeDefInfo.setGroupId(temp.getGroupId());
                    cssCodeDefInfo.setIdDesc(temp.getIdDesc());
                    cssCodeDefInfo.setIdType(temp.getIdType());
                    cssCodeDefInfo.setOtherValue(temp.getOtherValue());
                    cssCodeDefInfo.setRemark(temp.getRemark());
                    cssCodeDefInfo.setBak(temp.getBak());
                    cssCodeDefInfo.setValueId(temp.getValueId());
                    list.add(cssCodeDefInfo);
                }
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDefInfo> qryByClassGrpId(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        List<CssCodeDefInfo> list = new ArrayList<>();

        try {
            List<CssCodeDef> cssCodeDefList = cssCodeDefImpl.qryByClassGrpId(map);
            if (StringUtil.isNotEmptyOrNull(cssCodeDefList)) {

                for (CssCodeDef temp : cssCodeDefList) {
                    CssCodeDefInfo cssCodeDefInfo = new CssCodeDefInfo();
                    cssCodeDefInfo.setCodeClass(temp.getCodeClass());
                    cssCodeDefInfo.setClassDesc(temp.getClassDesc());
                    cssCodeDefInfo.setClassLevel(temp.getClassLevel());
                    cssCodeDefInfo.setCodeId(temp.getCodeId());
                    cssCodeDefInfo.setBeginValue(temp.getBeginValue());
                    cssCodeDefInfo.setBeginValueDesc(temp.getBeginValueDesc());
                    cssCodeDefInfo.setEffDate(temp.getEffDate());
                    cssCodeDefInfo.setExpDate(temp.getExpDate());
                    cssCodeDefInfo.setEndValue(temp.getEndValue());
                    cssCodeDefInfo.setEndValueDesc(temp.getEndValueDesc());
                    cssCodeDefInfo.setGroupId(temp.getGroupId());
                    cssCodeDefInfo.setIdDesc(temp.getIdDesc());
                    cssCodeDefInfo.setIdType(temp.getIdType());
                    cssCodeDefInfo.setOtherValue(temp.getOtherValue());
                    cssCodeDefInfo.setRemark(temp.getRemark());
                    cssCodeDefInfo.setBak(temp.getBak());
                    cssCodeDefInfo.setValueId(temp.getValueId());
                    list.add(cssCodeDefInfo);
                }
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDefInfo> qryByCondAll(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        List<CssCodeDefInfo> list = new ArrayList<>();

        try {
            List<CssCodeDef> cssCodeDefList = cssCodeDefImpl.qryByCondAll(map);
            if (StringUtil.isNotEmptyOrNull(cssCodeDefList)) {

                for (CssCodeDef temp : cssCodeDefList) {
                    CssCodeDefInfo cssCodeDefInfo = new CssCodeDefInfo();
                    cssCodeDefInfo.setCodeClass(temp.getCodeClass());
                    cssCodeDefInfo.setClassDesc(temp.getClassDesc());
                    cssCodeDefInfo.setClassLevel(temp.getClassLevel());
                    cssCodeDefInfo.setCodeId(temp.getCodeId());
                    cssCodeDefInfo.setBeginValue(temp.getBeginValue());
                    cssCodeDefInfo.setBeginValueDesc(temp.getBeginValueDesc());
                    cssCodeDefInfo.setEffDate(temp.getEffDate());
                    cssCodeDefInfo.setExpDate(temp.getExpDate());
                    cssCodeDefInfo.setEndValue(temp.getEndValue());
                    cssCodeDefInfo.setEndValueDesc(temp.getEndValueDesc());
                    cssCodeDefInfo.setGroupId(temp.getGroupId());
                    cssCodeDefInfo.setIdDesc(temp.getIdDesc());
                    cssCodeDefInfo.setIdType(temp.getIdType());
                    cssCodeDefInfo.setOtherValue(temp.getOtherValue());
                    cssCodeDefInfo.setRemark(temp.getRemark());
                    cssCodeDefInfo.setBak(temp.getBak());
                    cssCodeDefInfo.setValueId(temp.getValueId());
                    list.add(cssCodeDefInfo);
                }
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
        return list;
    }

    @Override
    public List<CssCodeDefInfo> qryBySpecial(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        List<CssCodeDefInfo> list = new ArrayList<>();

        try {
            List<CssCodeDef> cssCodeDefList = cssCodeDefImpl.qryBySpecial(map);
            if (StringUtil.isNotEmptyOrNull(cssCodeDefList)) {

                for (CssCodeDef temp : cssCodeDefList) {
                    CssCodeDefInfo cssCodeDefInfo = new CssCodeDefInfo();
                    cssCodeDefInfo.setCodeClass(temp.getCodeClass());
                    cssCodeDefInfo.setClassDesc(temp.getClassDesc());
                    cssCodeDefInfo.setClassLevel(temp.getClassLevel());
                    cssCodeDefInfo.setCodeId(temp.getCodeId());
                    cssCodeDefInfo.setBeginValue(temp.getBeginValue());
                    cssCodeDefInfo.setBeginValueDesc(temp.getBeginValueDesc());
                    cssCodeDefInfo.setEffDate(temp.getEffDate());
                    cssCodeDefInfo.setExpDate(temp.getExpDate());
                    cssCodeDefInfo.setEndValue(temp.getEndValue());
                    cssCodeDefInfo.setEndValueDesc(temp.getEndValueDesc());
                    cssCodeDefInfo.setGroupId(temp.getGroupId());
                    cssCodeDefInfo.setIdDesc(temp.getIdDesc());
                    cssCodeDefInfo.setIdType(temp.getIdType());
                    cssCodeDefInfo.setOtherValue(temp.getOtherValue());
                    cssCodeDefInfo.setRemark(temp.getRemark());
                    cssCodeDefInfo.setBak(temp.getBak());
                    cssCodeDefInfo.setValueId(temp.getValueId());
                    list.add(cssCodeDefInfo);
                }
            }
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
        return list;
    }

    @Override
    public Map qryByCondForNum(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败,参数对象不存在或为空!");
        }

        Map outMap;
        try {

            outMap = cssCodeDefImpl.qryByCondForNum(map);

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
        return outMap;

    }
}
