package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.BillDay;
import com.sitech.family.dto.ReturnDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 17:58
 */
public interface IBillDay {

    /**
     * 创建结账日信息
     *
     * @param billDay
     * @return ReturnDto
     */
    ReturnDto create(BillDay billDay);

    /**
     * 更新结账日信息
     *
     * @param billDay
     * @return ReturnDto
     */
    ReturnDto modify(BillDay billDay);

    /**
     * 删除结账日信息
     *
     * @param billDay
     * @return ReturnDto
     */
    ReturnDto drop(BillDay billDay);

    /**
     * 查询结账日信息
     *
     * @param idNo,effDate,contractNo,billDay
     * @return BillDay
     */
    BillDay query(Long idNo, Date effDate, Long contractNo, String billDay);

    /**
     * 查询结账日信息
     *
     * @param map
     * @return List<BillDay>
     */
    List<BillDay> qryBillDayList(Map map);

    /**
     * 查询历史表结账日信息
     *
     * @param map
     * @return List<BillDay>
     */
    List<BillDay> qryBillDayHisList(Map map);
}
