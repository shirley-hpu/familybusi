package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.ICssCodeDefDictInfo;
import com.sitech.family.dao.dict.ICssCodeDefDictDao;
import com.sitech.family.dto.dict.CssCodeDefInfo;
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
public class CssCodeDefDictInfo implements ICssCodeDefDictInfo {


    private final ICssCodeDefDictDao cssCodeDefDictDao;

    @Autowired
    public CssCodeDefDictInfo(ICssCodeDefDictDao cssCodeDefDictDao) {
        this.cssCodeDefDictDao = cssCodeDefDictDao;
    }


    @Override
    public List<CssCodeDefInfo> qryByCond(Map map) {
        return cssCodeDefDictDao.qryByCond(map);
    }

    @Override
    public List<CssCodeDefInfo> qryByClass(Map map) {
        return cssCodeDefDictDao.qryByClass(map);
    }

    @Override
    public List<CssCodeDefInfo> qryByClassGrpId(Map map) {
        return cssCodeDefDictDao.qryByClassGrpId(map);
    }

    @Override
    public List<CssCodeDefInfo> qryByCondAll(Map map) {
        return cssCodeDefDictDao.qryByCondAll(map);
    }

    @Override
    public List<CssCodeDefInfo> qryBySpecial(Map map) {
        return cssCodeDefDictDao.qryBySpecial(map);
    }

    @Override
    public Map qryByCondForNum(Map map) {
        return cssCodeDefDictDao.qryByCondForNum(map);
    }
}
