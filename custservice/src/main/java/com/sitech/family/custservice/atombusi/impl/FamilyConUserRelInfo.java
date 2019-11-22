package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IFamilyConUserRelInfo;
import com.sitech.family.dao.account.IConUserRelInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.account.ConUserRelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 逻辑原子实体业务实现层
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Component
public class FamilyConUserRelInfo implements IFamilyConUserRelInfo {

    /**
     * 调用dll.dao层ConUserRelInfoDao接口
     */
    @Autowired
    private IConUserRelInfoDao conUserRelInfoDao;

    @Override
    public ReturnDto create(ConUserRelInfo conUserRelInfoDto) {
        return conUserRelInfoDao.create(conUserRelInfoDto);
    }

    @Override
    public ReturnDto modify(ConUserRelInfo conUserRelInfoDto) {
        return conUserRelInfoDao.modify(conUserRelInfoDto);
    }

    @Override
    public ReturnDto drop(ConUserRelInfo conUserRelInfoDto) {
        return conUserRelInfoDao.drop(conUserRelInfoDto);
    }

    @Override
    public ConUserRelInfo query(Long servAcctId) {
        return conUserRelInfoDao.query(servAcctId);
    }

    @Override
    public List<ConUserRelInfo> qryConUserRelInfoList(Map map) {
        return conUserRelInfoDao.qryConUserRelInfoList(map);
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        return conUserRelInfoDao.updateFinishState(updateOprInfo,idNo);
    }
}
