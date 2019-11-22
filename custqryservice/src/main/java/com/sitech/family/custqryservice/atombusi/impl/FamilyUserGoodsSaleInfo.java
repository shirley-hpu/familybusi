package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsSaleInfo;
import com.sitech.family.dao.usergoods.IUserGoodsSaleInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭商品销售轨迹信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserGoodsSaleInfo implements IFamilyUserGoodsSaleInfo {

    /**
     *
     */
    @Resource(name = "userGoodsSaleInfoQryDaoImpl")
    private IUserGoodsSaleInfoQryDao userGoodsSaleInfoQryDao;

    @Override
    public UserGoodsSaleInfo query(Long loginAccept, String resourceNo, Long sellSerialNo, Date opTime) {
        return userGoodsSaleInfoQryDao.query(loginAccept, resourceNo, sellSerialNo, opTime);
    }

    @Override
    public List<UserGoodsSaleInfo> qryUserGoodsSaleInfoList(Map map) {
        return userGoodsSaleInfoQryDao.qryUserGoodsSaleInfoList(map);
    }
}
