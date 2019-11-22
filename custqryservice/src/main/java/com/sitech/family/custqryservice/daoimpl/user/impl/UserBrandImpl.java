package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserBrand;
import com.sitech.family.custqryservice.dto.mapperdto.UserBrand;
import com.sitech.family.custqryservice.mapper.UserBrandMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: familybusi
 * @description: 用户与品牌关系实体实现
 * @author: yang xing
 * @create: 2018-12-19 10:14
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserBrandImpl implements IUserBrand {

    @Autowired
    private UserBrandMapper userBrandMapper;

    /**
     * 查询用户与品牌间的关系
     * @param idNo,brandId,effDate
     * @return ReturnDto
     */
    @Override
    public UserBrand query(Long idNo, String brandId, Date effDate) {
        UserBrand userBrand = new UserBrand();

        try {
            userBrand = userBrandMapper.query(idNo, brandId, effDate);
        } catch (Exception e) {
            throw new BusiException("查询用户与品牌间的关系失败:" + e.getMessage());
        }

        return userBrand;
    }

}
