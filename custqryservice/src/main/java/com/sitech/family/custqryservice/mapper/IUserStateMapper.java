package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserState;
import org.springframework.stereotype.Repository;

/**
 * @author wusm
 * @description 用户状态变化信息
 * @date 2018/12/20 15:08
 */
@Repository
public interface IUserStateMapper {

    /**
     * 查询用户状态变化信息
     * @param stateChangeNo
     * @return User
     */
    UserState query(Long stateChangeNo);


}
