package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserSvcAttrTrace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */

@Repository
public interface IUserSvcAttrTraceMapper {

    void create(UserSvcAttrTrace userSvcAttrTrace);

    void insert(UserSvcAttrTrace userSvcAttrTrace);

    void modify(UserSvcAttrTrace userSvcAttrTrace);

    void drop(UserSvcAttrTrace userSvcAttrTrace);

    UserSvcAttrTrace query(@Param("svcinsId")BigDecimal svcinsId,@Param("attrId") String attrId,@Param("attrNo") String attrNo,@Param("effDate") Date effDate);

    List<UserSvcAttrTrace> qryUserSvcAttrTraceList(@Param("params") Map map);

    List<UserSvcAttrTrace> qryUserSvcAttrTraceHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userSvcAttrTrace
     * @return
     */
    void updateFinishState(UserSvcAttrTrace userSvcAttrTrace);
}
