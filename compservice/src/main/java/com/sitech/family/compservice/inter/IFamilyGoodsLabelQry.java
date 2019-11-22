package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyGoodsLabel;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author wusm
 * @description 商品标签查询
 * @date 2019/4/1 17:45
 */
public interface IFamilyGoodsLabelQry {

    /**
     * 商品标签查询
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyGoodsLabel(InDTO<RequestMessage<FamilyGoodsLabel>> inDTO);
}
