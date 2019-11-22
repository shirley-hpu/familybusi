package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface UserDetailHisMapper {

    /**
     * @param userDetail
     * @return
     */
    int insert(UserDetail userDetail);

    /**
     * @param idNo
     * @return
     */
    List<UserDetail> selectByPrimaryKey(Long idNo);

}
