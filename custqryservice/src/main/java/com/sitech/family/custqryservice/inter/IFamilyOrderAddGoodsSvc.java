package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.indto.FamilyOrderAdditionGoods;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

public interface IFamilyOrderAddGoodsSvc {

    /**
     * 家庭已订购附加商品信息查询
     * @param inDto
     * @return OutDTO
     */
    public OutDTO qryFamilyOrderAdditionGoods(InDTO<RequestMessage<FamilyOrderAdditionGoods>> inDto);
}
