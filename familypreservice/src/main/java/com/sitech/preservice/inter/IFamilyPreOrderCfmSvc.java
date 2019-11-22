package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.FamilyPreOrderCfm;
import com.sitech.preservice.dto.commondto.RequestMessage;

/**
 * @author wusm
 * @description
 * @date 2019/5/30 16:06
 */
public interface IFamilyPreOrderCfmSvc {

    /**
     * 预受理提交服务
     * @param inDTO
     * @return
     */
    public OutDTO commit(InDTO<RequestMessage<FamilyPreOrderCfm>> inDTO);
}
