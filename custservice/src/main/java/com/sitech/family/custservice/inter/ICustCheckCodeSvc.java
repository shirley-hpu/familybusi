package com.sitech.family.custservice.inter;

import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.CustCheckCodeInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author guanqp
 * @Description  验证码的入表和查询操作
 * @date 2019/3/28 10:31
 */
public interface ICustCheckCodeSvc {

    /**
     * 对验证码做入表操作
     * @param inDTO
     * @return
     */
    public OutDTO<Object> create(InDTO<RequestMessage<CustCheckCodeInDto>> inDTO);

    /**
     * 查询出验证码和有效时间
     * @param inDTO
     * @return
     */
    public OutDTO<Object> query(InDTO<RequestMessage<CustCheckCodeInDto>> inDTO);

}
