package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserPrcMbrIns;
import com.sitech.family.custqryservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.custqryservice.mapper.UserPrcMbrInsMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
public class UserPrcMbrInsImpl implements IUserPrcMbrIns {

    @Autowired
    private UserPrcMbrInsMapper userPrcMbrInsMapper;

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param memberId
     * @param prodPrcInsId
     * @return ReturnDto
     */
    @Override
    public UserPrcMbrIns query(BigDecimal memberId, BigDecimal prodPrcInsId) {
        UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();

        try {
            userPrcMbrIns = userPrcMbrInsMapper.query(memberId, prodPrcInsId);
        } catch (Exception e) {
            throw new BusiException("查询家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        return userPrcMbrIns;
    }
}
