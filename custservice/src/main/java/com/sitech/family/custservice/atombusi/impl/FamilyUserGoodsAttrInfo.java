package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyUserGoodsAttrInfo;
import com.sitech.family.dao.usergoods.IUserGoodsAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
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
    private IUserGoodsAttrInfoDao iUserGoodsAttrInfoDao;

    /**
     * 新增家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGoodsAttrInfo userGoodsAttrInfo) {
        return iUserGoodsAttrInfoDao.create(userGoodsAttrInfo);
    }

    /**
     * 修改家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGoodsAttrInfo userGoodsAttrInfo) {
        return iUserGoodsAttrInfoDao.modify(userGoodsAttrInfo);
    }

    /**
     * 删除家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGoodsAttrInfo userGoodsAttrInfo) {
        return iUserGoodsAttrInfoDao.drop(userGoodsAttrInfo);
    }

    /**
     * 查询家庭订购属性信息
     *
     * @return userGoodsAttrInfo
     */
    @Override
    public UserGoodsAttrInfo query(BigDecimal goodsinsId, BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        return iUserGoodsAttrInfoDao.query(goodsinsId, svcinsId, attrId, attrNo, effDate);
    }

    @Override
    public List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map) {

        return iUserGoodsAttrInfoDao.qryUserGoodsAttrInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        return iUserGoodsAttrInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
