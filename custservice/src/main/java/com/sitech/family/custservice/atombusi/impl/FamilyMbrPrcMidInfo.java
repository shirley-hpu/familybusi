package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyMbrPrcMidInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserMbrPrcMidInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:49
 */
@Component
public class FamilyMbrPrcMidInfo implements IFamilyMbrPrcMidInfo {

    @Autowired
    private IUserMbrPrcMidInfoDao iUserMbrPrcMidInfoDao;

    /**
     * 新增成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        return iUserMbrPrcMidInfoDao.create(userMbrPrcMidInfo);
    }

    /**
     * 修改成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        return iUserMbrPrcMidInfoDao.modify(userMbrPrcMidInfo);
    }

    /**
     * 删除成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        return iUserMbrPrcMidInfoDao.drop(userMbrPrcMidInfo);
    }

    /**
     * 查询成员订购实例
     *
     * @param insType,insValue
     * @return UserMbrPrcMidInfo
     */
    @Override
    public UserMbrPrcMidInfo query(String insType, BigDecimal insValue) {
        return iUserMbrPrcMidInfoDao.query(insType, insValue);
    }

    /**
     * 查询成员订购实例
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map) {
        return iUserMbrPrcMidInfoDao.qryUserMbrPrcMidInfoList(map);
    }

    /**
     * 根据idNo删除中间表数据
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto delByIdNo(UpdateOprInfo updateOprInfo, Long idNo) {
        return iUserMbrPrcMidInfoDao.delByIdNo(updateOprInfo, idNo);
    }
}
