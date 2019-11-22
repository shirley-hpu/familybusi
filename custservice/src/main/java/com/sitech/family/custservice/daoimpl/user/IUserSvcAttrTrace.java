package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserSvcAttrTrace;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */
public interface IUserSvcAttrTrace {
    /**
     * 创建服务属性实例轨迹信息
     * @param userSvcAttrTrace
     * @return ReturnDto
     */
    ReturnDto create(UserSvcAttrTrace userSvcAttrTrace) ;

    /**
     * 更新服务属性实例轨迹信息
     * @param userSvcAttrTrace
     * @return ReturnDto
     */
    ReturnDto modify(UserSvcAttrTrace userSvcAttrTrace);

    /**
     * 删除服务属性实例轨迹信息
     * @param userSvcAttrTrace
     * @return ReturnDto
     */
    ReturnDto drop(UserSvcAttrTrace userSvcAttrTrace);

    /**
     * 查询服务属性实例轨迹信息
     * @param svcinsId,attrId,attrNo,effDate
     * @return UserSvcAttrTrace
     */
    UserSvcAttrTrace query(BigDecimal svcinsId , String attrId, String attrNo, Date effDate);

    /**
     * 查询服务属性实例轨迹信息信息
     * @param map
     * @return List<UserSvcAttrTrace>
     */
    List<UserSvcAttrTrace> qryUserSvcAttrTraceList(Map map);

    /**
     * 查询服务属性实例轨迹信息历史信息
     * @param map
     * @return List<UserSvcAttrTrace>
     */
    List<UserSvcAttrTrace> qryUserSvcAttrTraceHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userSvcAttrTrace
     * @return
     */
    ReturnDto updateFinishState(UserSvcAttrTrace userSvcAttrTrace);
}
