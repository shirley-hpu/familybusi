package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergoods.IUserGoodsInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭商品订购信息
 * @date 2018/12/17 14:11
 */
@Component
public class FamilyUserGoodsInfo implements IFamilyUserGoodsInfo {

    @Autowired
    private IUserGoodsInfoDao iUserGoodsInfoDao;

    /**
     * 新增家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGoodsInfo userGoodsInfo) {
        return iUserGoodsInfoDao.create(userGoodsInfo);
    }

    /**
     * 修改家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGoodsInfo userGoodsInfo) {
        return iUserGoodsInfoDao.modify(userGoodsInfo);
    }

    /**
     * 删除家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGoodsInfo userGoodsInfo) {
        return iUserGoodsInfoDao.drop(userGoodsInfo);
    }

    /**
     * 查询家庭商品订购信息
     *
     * @return userGoodsInfo
     */
    @Override
    public UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept) {
        return iUserGoodsInfoDao.query(goodsinsId, relgoodsinsId, svcinsId, prodprcinsId, loginAccept);
    }

    @Override
    public List<UserGoodsInfo> qryUserGoodsInfoList(Map map) {
        return iUserGoodsInfoDao.qryUserGoodsInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo,Long idNo) {
        return iUserGoodsInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
