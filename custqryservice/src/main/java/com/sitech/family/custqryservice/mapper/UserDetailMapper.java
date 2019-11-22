package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserDetail;
import org.springframework.stereotype.Repository;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserDetailMapper {

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return UserDetail
     */
    UserDetail query(Long idNo);

}
