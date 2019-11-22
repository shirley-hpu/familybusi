package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IBillDay;
import com.sitech.family.custqryservice.dto.mapperdto.BillDay;
import com.sitech.family.custqryservice.mapper.IBillDayMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 18:01
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class BillDayImpl implements IBillDay {

    @Autowired
    private IBillDayMapper mapper;

    /**
     * 查询结账日信息
     *
     * @param idNo,effDate,contractNo,billDay
     * @return BillDay
     */
    @Override
    public BillDay query(Long idNo, Date effDate, Long contractNo, String billDay) {
        BillDay billDay1 = new BillDay();

        try {
            billDay1 = mapper.query(idNo, effDate, contractNo, billDay);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询结账日信息失败" + e.getMessage());
        }

        return billDay1;
    }

}
