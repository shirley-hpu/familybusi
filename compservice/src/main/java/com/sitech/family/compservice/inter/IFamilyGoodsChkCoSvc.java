package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyGoodsChk;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * @author wusm
 * @description 关系校验
 * @date 2018/9/27 17:02
 */
public interface IFamilyGoodsChkCoSvc {

    /**
     * 关系校验
     *
     * @param inDTO
     * @return outDTO
     */
    public OutDTO chkFamilyGoods(InDTO<RequestMessage<FamilyGoodsChk>> inDTO);

}
