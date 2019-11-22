package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IResSellTerm;
import com.sitech.family.custqryservice.dto.mapperdto.ResSellTerm;
import com.sitech.family.custqryservice.mapper.ResSellTermMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: familybusi
 * @description: 终端资源销售记录信息实体实现
 * @author: yang xing
 * @create: 2018-12-20 17:28
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ResSellTermImpl implements IResSellTerm {

    @Autowired
    private ResSellTermMapper resSellTermMapper;

    /**
     * 查询终端资源销售记录
     *
     * @param opTime,resourceNo,sellSerialNo
     * @return ReturnDto
     */
    @Override
    public ResSellTerm query(Date opTime, String resourceNo, Long sellSerialNo) {
        ResSellTerm resSellTerm = new ResSellTerm();

        try {
            resSellTerm = resSellTermMapper.query(opTime, resourceNo, sellSerialNo);
        } catch (Exception e) {
            throw new BusiException("查询终端资源销售记录失败:" + e.getMessage());
        }

        return resSellTerm;
    }

}
