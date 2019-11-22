package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

import java.util.Map;

/**
 * 成员资费预约订购记录查询
 *
 * @author shirley
 * @date created in 2019/4/20
 */
public interface IFamilyMbrAoSvc {


    /**
     * @param inDTO
     */
    OutDTO<Object> qryFamilyPreMbrPrc(InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult);

    OutDTO<Object> qryFamilyGroupMbr(InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult);
}
