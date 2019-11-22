package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * 查询商品信息
 *
 * @author shirley
 * @date created in 2019/6/12
 */
public interface IFamilyGoodsQryAoSvc {


    /**
     * @param inDTO
     * @return
     */
    public OutDTO<Object> qryFamilyGoodsDict(InDTO<RequestMessage<Map>> inDTO);
}

