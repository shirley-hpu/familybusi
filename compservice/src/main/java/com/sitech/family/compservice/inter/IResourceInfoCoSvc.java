package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.BusiInfoAddress;
import com.sitech.family.compservice.dto.indto.PhoneNoPreemptInDto;
import com.sitech.family.compservice.dto.indto.PhoneQryInDto;
import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

import java.util.Map;

public interface IResourceInfoCoSvc {

    /**
     * 号码查询
     *
     * @param inDTO
     * @return
     */
    public OutDTO<Object> qryPhoneNo(InDTO<RequestMessage<PhoneQryInDto>> inDTO,BindingResult bindingResult);

    /**
     * SIM卡号查询
     * @param inDTO
     * @return
     */
    public OutDTO<Object> qrySimNo(InDTO<RequestMessage<Map>> inDTO);

    /**
     * 宽带安装地址查询
     *
     * @param inDTO
     * @return
     */
    public OutDTO qryStandardAddress(InDTO<RequestMessage<Map>> inDTO);


    /**
     * 号码预占
     *
     * @param inDTO
     * @return
     */
    public OutDTO<Object> subPhoneNoPreempt(InDTO<RequestMessage<PhoneNoPreemptInDto>> inDTO);


    /**
     * 号码释放
     *
     * @param inDTO
     * @return
     */
    public OutDTO<Object> subPhoneNoRelease(InDTO<RequestMessage<PhoneNoPreemptInDto>> inDTO);

}
