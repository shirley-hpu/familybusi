package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserSvcTrace;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 18:06
 */
@Repository
public interface IUserSvcTraceMapper {

    UserSvcTrace query(BigDecimal svcinsId);

}
