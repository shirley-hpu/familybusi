package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbrAttr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 群成员属性实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserGroupMbrAttrMapper {

    /**
     * @param memberId,attrId,effDate,attrNo
     * @return UserGroupMbrAttr
     */
    UserGroupMbrAttr query(@Param("memberId") BigDecimal memberId,@Param("attrId") String attrId,@Param("effDate") Date effDate,@Param("attrNo") String attrNo);

}
