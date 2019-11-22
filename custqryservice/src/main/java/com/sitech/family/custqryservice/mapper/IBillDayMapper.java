package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.BillDay;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 18:04
 */
@Repository
public interface IBillDayMapper {

    /**
     * 查询结账日信息
     *
     * @param idNo,effDate,contractNo,billDay
     * @return BillDay
     */
    BillDay query(Long idNo, Date effDate, Long contractNo, String billDay);

}
