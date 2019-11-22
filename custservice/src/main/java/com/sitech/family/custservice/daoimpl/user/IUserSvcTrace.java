package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserSvcTrace;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 服务实例轨迹信息
 * @date 2018/12/17 17:53
 */
public interface IUserSvcTrace {

    /**
     * 创建服务实例轨迹信息
     * @param userSvcTrace
     * @return ReturnDto
     */
    ReturnDto create(UserSvcTrace userSvcTrace) ;

    /**
     * 更新服务实例轨迹信息
     * @param userSvcTrace
     * @return ReturnDto
     */
    ReturnDto modify(UserSvcTrace userSvcTrace);

    /**
     * 删除服务实例轨迹信息
     * @param userSvcTrace
     * @return ReturnDto
     */
    ReturnDto drop(UserSvcTrace userSvcTrace);

    /**
     * 查询服务实例轨迹信息
     * @param svcinsId
     * @return UserSvcTrace
     */
    UserSvcTrace query(BigDecimal svcinsId);

    /**
     * 查询服务实例轨迹信息
     * @param map
     * @return List<UserSvcTrace>
     */
    List<UserSvcTrace> qryUserSvcTraceInfoList(Map map);

    /**
     * 查询服务实例轨迹信息
     * @param map
     * @return List<UserSvcTrace>
     */
    List<UserSvcTrace> qryUserSvcTraceInfoHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userSvcTrace
     * @return
     */
    ReturnDto updateFinishState(UserSvcTrace userSvcTrace);
}
