package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserDetail;
import com.sitech.family.custqryservice.dto.mapperdto.UserDetail;
import com.sitech.family.custqryservice.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
public class UserDetailImpl implements IUserDetail {

    @Autowired
    private UserDetailMapper userDetailMapper;

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return
     */
    @Override
    public UserDetail query(Long idNo) {
        return userDetailMapper.query(idNo);
    }
}
