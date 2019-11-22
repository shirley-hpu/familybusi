package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-25 15:38
 * @Version: 1.0
 */
public interface IFamilyOrderPrcAttrAoSvc {

    /**
     * 查询资费属性信息
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyOrderPrcAttr(InDTO<RequestMessage<Map>> inDTO);
}
