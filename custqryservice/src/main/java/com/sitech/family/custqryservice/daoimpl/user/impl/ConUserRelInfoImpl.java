package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custqryservice.dto.mapperdto.ConUserRel;
import com.sitech.family.custqryservice.mapper.ConUserRelMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 帐务付费明细  实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
public class ConUserRelInfoImpl implements IConUserRelInfo {

    @Autowired
    private ConUserRelMapper conUserRelMapper;

    /**
     * 查询帐务付费明细信息
     *
     * @param servAcctId
     * @return ConUserRel
     */
    @Override
    public ConUserRel query(Long servAcctId) {
        ConUserRel conUserRel = new ConUserRel();

        try {
            conUserRel = conUserRelMapper.query(servAcctId);
        } catch (Exception e) {
            throw new BusiException("查询帐务付费明细信息失败:" + e.getMessage());
        }

        return conUserRel;

    }
}
