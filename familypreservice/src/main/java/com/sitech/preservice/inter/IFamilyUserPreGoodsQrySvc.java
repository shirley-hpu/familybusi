package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;

import java.util.Map;


public interface IFamilyUserPreGoodsQrySvc {

    //查询用户已办权益及赠送权益（宽带、iptv、ims固话）
    public OutDTO qryFamilyUserPreGoods(InDTO<RequestMessage<Map>> inDTO);
}
