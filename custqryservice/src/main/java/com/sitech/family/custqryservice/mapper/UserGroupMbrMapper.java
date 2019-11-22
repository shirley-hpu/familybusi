package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserGroupMbrMapper {

    /**
     * @param memberId
     * @return
     */
    UserGroupMbr query(BigDecimal memberId);

    List<UserGroupMbr> queryFamilyGroupMbr(Map<String,String> params);
}
