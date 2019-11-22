package com.sitech.family.custqryservice.inter;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;

import java.util.Map;

/**
 * 统一代码配置表
 *
 * @author shirley
 * @date created in 2019/4/19
 */
public interface ICssCodeDefDictAoSvc {


    /**
     * @param map
     */
    OutDTO<Object> qryByCond(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);

    /**
     * @param map
     */
    OutDTO<Object> qryByClass(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);

    /**
     * @param map
     */
    OutDTO<Object> qryByClassGrpId(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);

    /**
     * @param map
     */
    OutDTO<Object> qryByCondAll(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);

    /**
     * @param map
     */
    OutDTO<Object> qryBySpecial(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);

    /**
     * @param map
     */
    OutDTO<Object> qryByCondForNum(InDTO<RequestMessage<Map>> map, BindingResult bindingResult);
}
