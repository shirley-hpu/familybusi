package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * 主号家庭信息查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:54
 */
public interface IFamilyMainRoleGroupQryCoSvc {


    /**
     * @param inDTO
     */
    OutDTO<Object> qryFamilyMainRoleGroup(InDTO<RequestMessage<Map>> inDTO);

    OutDTO<Object> qryFamilyUserBasicInfo(InDTO<RequestMessage<Map>> inDTO);
}
