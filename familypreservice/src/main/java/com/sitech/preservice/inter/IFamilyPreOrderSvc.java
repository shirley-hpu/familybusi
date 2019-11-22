package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.dto.indto.FmPreOrderMidInDto;
import org.springframework.validation.BindingResult;

/**
 * 预受理
 *
 * @author shirley
 * @date created in 2019/5/30
 */
public interface IFamilyPreOrderSvc {



    OutDTO<Object> qryFmPreOrderMidList(InDTO<RequestMessage<FmPreOrderMidInDto>> inDTO, BindingResult bindingResult);




}
