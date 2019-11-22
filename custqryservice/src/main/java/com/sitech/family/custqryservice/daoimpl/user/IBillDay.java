package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.BillDay;

import java.util.Date;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 17:58
 */
public interface IBillDay {

    /**
     * 查询结账日信息
     *
     * @param idNo,effDate,contractNo,billDay
     * @return BillDay
     */
    BillDay query(Long idNo, Date effDate, Long contractNo, String billDay);
}
