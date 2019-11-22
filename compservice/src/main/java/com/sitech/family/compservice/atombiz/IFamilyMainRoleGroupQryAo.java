package com.sitech.family.compservice.atombiz;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * todo
 *
 * @author shirley
 * @version 1.0
 * @date 2019-07-31 15:52
 */
public interface IFamilyMainRoleGroupQryAo {

    /**
     * @param inDTO
     */
    Map qryFamilyMainRoleGroup(Map<String, Object> inDTO);

    OutDTO<Object> qryFamilyUserBasicInfo(Map<String,Object> map);
}
