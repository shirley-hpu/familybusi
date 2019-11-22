package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-24 10:28
 * @Version: 1.0
 */
public interface IFamilyPkgGoodsAoSvc {

    /**
     * 查询家庭套餐基本信息
     * @param inDTO
     * @return outDto
     */
    public OutDTO qryFamilyPkgGoods(InDTO<RequestMessage<Map>> inDTO);
}
