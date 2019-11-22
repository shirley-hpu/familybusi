package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserSvcAttrTrace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */

@Repository
public interface IUserSvcAttrTraceMapper {

    UserSvcAttrTrace query(@Param("svcinsId")BigDecimal svcinsId,@Param("attrId") String attrId,@Param("attrNo") String attrNo,@Param("effDate") Date effDate);

}
