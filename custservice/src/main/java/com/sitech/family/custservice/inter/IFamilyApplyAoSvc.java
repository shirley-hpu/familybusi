package com.sitech.family.custservice.inter;

import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.FamilyApplyFnsInDto;
import com.sitech.family.custservice.dto.indto.FamilyUserApplyInDto;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

/**
 * @author wusm
 * @description
 * @date 2019/3/13 17:44
 */
public interface IFamilyApplyAoSvc {

    /**
     * 群用户创建
     *
     * @param inDTO
     * @return
     */
    public OutDTO<ReturnDto> cfmFamilyUserApply(InDTO<RequestMessage<FamilyUserApplyInDto>> inDTO, BindingResult bindingResult);


    /**
     * 群用户创建在途
     *
     * @param inDTO
     * @return
     */
    public OutDTO<ReturnDto> cfmFamilyUserPreApply(InDTO<RequestMessage<FamilyUserApplyInDto>> inDTO, BindingResult bindingResult);


    /**
     * 群用户竣工
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO fnsFamilyApply(InDTO<RequestMessage<FamilyApplyFnsInDto>> inDTO);
}
