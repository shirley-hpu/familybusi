package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 群实例
 * @date 2018/12/21 10:45
 */
@Repository
public interface IUserGroupMapper {

    /**
     * 查询群实例
     * @param groupId
     * @return UserGroup
     */
    UserGroup query(BigDecimal groupId);

    /**
     * 查询历史表群实例
     * @param map
     * @return List<UserGroup>
     */
    List<UserGroup> qryUserGroupList(@Param("params") Map map);

}
