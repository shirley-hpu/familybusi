package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyBillInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

/**
 * 家庭账单查询
 * @author Zhangc
 * @version 1.0
 * @date 2019/9/17 21:12
 */
public interface IFamilyBillQryCoSvc {
    /**
     * 家庭账单查询
     * @param inDTO
     * @return
     */
    OutDTO<Object> qryFamilyBill(InDTO<RequestMessage<FamilyBillInDto>> inDTO, BindingResult bindingResult);
}
