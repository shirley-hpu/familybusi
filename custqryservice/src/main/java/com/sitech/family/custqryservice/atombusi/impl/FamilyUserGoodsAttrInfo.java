package com.sitech.family.custqryservice.atombusi.impl;


import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsAttrInfo;
import com.sitech.family.dao.usergoods.IUserGoodsAttrInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author wusm
 * @description
 * @date 2018/12/17 14:42
 */
@Component
public class FamilyUserGoodsAttrInfo implements IFamilyUserGoodsAttrInfo {

    @Autowired
    private IUserGoodsAttrInfoQryDao iUserGoodsAttrInfoQryDao;

    @Override
    public UserGoodsAttrInfo query(BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        return iUserGoodsAttrInfoQryDao.query(svcinsId, attrId, attrNo, effDate);
    }

    @Override
    public List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map) {

        return iUserGoodsAttrInfoQryDao.qryUserGoodsAttrInfoList(map);
    }
}
