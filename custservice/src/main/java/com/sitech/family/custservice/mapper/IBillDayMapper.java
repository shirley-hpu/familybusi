package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.BillDay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 18:04
 */
@Repository
public interface IBillDayMapper {

    /**
     * 新增结账日信息
     *
     * @param billDay
     * @return null
     */
    void create(BillDay billDay);

    /**
     * 新增历史表结账日信息
     *
     * @param billDay
     * @return null
     */
    void insert(BillDay billDay);

    /**
     * 更新结账日信息
     *
     * @param billDay
     * @return null
     */
    void modify(BillDay billDay);

    /**
     * 删除结账日信息
     *
     * @param billDay
     * @return null
     */
    void drop(BillDay billDay);

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
    List<BillDay> qryBillDayList(@Param("params") Map map);

    /**
     * 查询历史表结账日信息
     *
     * @param map
     * @return List<BillDay>
     */
    List<BillDay> qryBillDayHisList(@Param("inparams") Map map);
}
