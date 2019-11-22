package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsLmtInfo;
import com.sitech.family.dao.usergoods.IUserGoodsLmtInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 逻辑原子实体业务实现层
 * 家庭用户受限信息实体
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Component
public class FamilyUserGoodsLmtInfo implements IFamilyUserGoodsLmtInfo {

    /**
     * 家庭用户受限信息 逻辑模型层接口
     */
    @Resource(name = "userGoodsLmtInfoQryDaoImpl")
    private IUserGoodsLmtInfoQryDao userGoodsLmtInfoQryDao;

    @Override
    public UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId) {
        return userGoodsLmtInfoQryDao.query(limitinsId, goodsinsId);
    }

    @Override
    public List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map) {
        return userGoodsLmtInfoQryDao.qryUserGoodsLmtInfoList(map);
    }
}
