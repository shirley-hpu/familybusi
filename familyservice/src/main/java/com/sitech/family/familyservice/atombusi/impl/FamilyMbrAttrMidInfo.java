package com.sitech.family.familyservice.atombusi.impl;

import com.sitech.family.familyservice.atombusi.IFamilyMbrAttrMidInfo;
import com.sitech.family.dao.usergroup.IUserMbrAttrMidInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:49
 */
@Component
public class FamilyMbrAttrMidInfo implements IFamilyMbrAttrMidInfo {

    @Autowired
    private IUserMbrAttrMidInfoDao iUserMbrAttrMidInfoDao;

    /**
     * 新增成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        return iUserMbrAttrMidInfoDao.create(userMbrAttrMidInfo);
    }

    /**
     * 修改成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        return iUserMbrAttrMidInfoDao.modify(userMbrAttrMidInfo);
    }

    /**
     * 删除成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        return iUserMbrAttrMidInfoDao.drop(userMbrAttrMidInfo);
    }

    /**
     * 查询成员订购属性实例
     *
     * @param insType
     * @param insValue
     * @param attrId
     * @param effDate
     * @param attrNo
     * @return UserMbrAttrMidInfo
     */
    @Override
    public UserMbrAttrMidInfo query(String insType, BigDecimal insValue, String attrId, Date effDate, String attrNo) {
        return iUserMbrAttrMidInfoDao.query(insType, insValue, attrId, effDate, attrNo);
    }

    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map) {
        return iUserMbrAttrMidInfoDao.qryUserMbrAttrMidInfoList(map);
    }

    /**
     * 删除成员订购属性实例
     *
     * @param updateOprInfo
     * @param insValue
     * @return ReturnDto
     */
    @Override
    public ReturnDto delByInsValue(UpdateOprInfo updateOprInfo, BigDecimal insValue) {
        return iUserMbrAttrMidInfoDao.delByInsValue(updateOprInfo, insValue);
    }
}
