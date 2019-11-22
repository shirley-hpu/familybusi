package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyGoodsPrcDictInfo;
import com.sitech.family.custqryservice.dto.mapperdto.PdGoodsPrcDict;
import com.sitech.family.custqryservice.mapper.IPdGoodsPrcDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class FamilyGoodsPrcDictInfo implements IFamilyGoodsPrcDictInfo {

    @Autowired
    private IPdGoodsPrcDictMapper iPdGoodsPrcDictMapper;

    @Override
    public PdGoodsPrcDict qryGoodsPrcDictInfo(Map map) {
        return iPdGoodsPrcDictMapper.qryGoodsPrcInfo(map);
    }
}
