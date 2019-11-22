package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserSvcTrace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 18:06
 */
@Repository
public interface IUserSvcTraceMapper {

    void create(UserSvcTrace inDTO);

    void insert(UserSvcTrace inDTO);

    void modify(UserSvcTrace inDTO);

    void drop(BigDecimal svcinsId);

    UserSvcTrace query(BigDecimal svcinsId);

    List<UserSvcTrace> qryUserSvcTraceInfoList(@Param("params") Map map);

    List<UserSvcTrace> qryUserSvcTraceInfoHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userSvcTrace
     * @return
     */
    void updateFinishState(UserSvcTrace userSvcTrace);
}
