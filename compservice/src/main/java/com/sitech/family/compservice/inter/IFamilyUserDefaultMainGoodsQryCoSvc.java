package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/23 10:42
 */
public interface IFamilyUserDefaultMainGoodsQryCoSvc {
    /**
     * 大众市场默认主资费查询
     * @param inDTO
     * @return
     */
    public OutDTO qryDefaultMainGoods(InDTO<RequestMessage<Map>> inDTO,BindingResult bindingResult);
}
