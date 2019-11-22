package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyConUserRelInfo;
import com.sitech.family.dao.account.IConUserRelInfoQryDao;
import com.sitech.family.dto.account.ConUserRelInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource(name = "conUserRelInfoQryDaoImpl")
    private IConUserRelInfoQryDao conUserRelInfoQryDao;


    @Override
    public ConUserRelInfo query(Long servAcctId) {
        return conUserRelInfoQryDao.query(servAcctId);
    }

    @Override
    public List<ConUserRelInfo> qryConUserRelInfoList(Map map) {
        return conUserRelInfoQryDao.qryConUserRelInfoList(map);
    }

}
