package com.sitech.preservice.inter;

import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.commondto.RequestMessage;
import org.springframework.validation.BindingResult;

import java.util.Map;

/**
 * 推荐套餐查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/10/9 下午4:44
 */
public interface IFamilyPreGoodsQrySvc {


    /**
     * 推荐套餐查询
     *
     * @param map
     */
    public OutDTO<Object> qryFamilyPreGoods(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);
}
