package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserBrand;

import com.sitech.family.custservice.dto.mapperdto.UserBrand;
import com.sitech.family.custservice.mapper.UserBrandMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * 创建用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserBrand userBrand) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userBrandMapper.create(userBrand);

            userBrandMapper.insert(userBrand);
        } catch (Exception e) {
            throw new BusiException("创建用户与品牌间的关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserBrand userBrand) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = userBrand.getIdNo();
            String brandId = userBrand.getBrandId();
            Date effDate = userBrand.getEffDate();

            UserBrand userBrand1 = userBrandMapper.query(idNo, brandId, effDate);

            if (StringUtil.isEmptyOrNull(userBrand1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户与品牌间的关系失败");
                return returnDto;
            }

            userBrand1.setUpdateAccept(userBrand.getUpdateAccept());
            userBrand1.setUpdateType(userBrand.getUpdateType());
            userBrand1.setUpdateTime(userBrand.getUpdateTime());
            userBrand1.setUpdateDate(userBrand.getUpdateDate());
            userBrand1.setUpdateLogin(userBrand.getUpdateLogin());
            userBrand1.setUpdateCode(userBrand.getUpdateCode());

            userBrandMapper.insert(userBrand1);

            userBrandMapper.modify(userBrand);

            userBrand.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userBrandMapper.insert(userBrand);
        } catch (Exception e) {
            throw new BusiException("更新用户与品牌间的关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserBrand userBrand) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = userBrand.getIdNo();
            String brandId = userBrand.getBrandId();
            Date effDate = userBrand.getEffDate();

            UserBrand userBrand1 = userBrandMapper.query(idNo, brandId, effDate);

            if (StringUtil.isEmptyOrNull(userBrand1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户与品牌间的关系失败");
                return returnDto;
            }

            userBrand1.setUpdateAccept(userBrand.getUpdateAccept());
            userBrand1.setUpdateType(userBrand.getUpdateType());
            userBrand1.setUpdateTime(userBrand.getUpdateTime());
            userBrand1.setUpdateDate(userBrand.getUpdateDate());
            userBrand1.setUpdateLogin(userBrand.getUpdateLogin());
            userBrand1.setUpdateCode(userBrand.getUpdateCode());

            userBrandMapper.insert(userBrand1);
            userBrandMapper.drop(userBrand);
        } catch (Exception e) {
            throw new BusiException("删除用户与品牌间的关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

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

    /**
     * 查询用户与品牌间的关系
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public List<UserBrand> qryUserBrandRelList(Map map) {
        List<UserBrand> list = new ArrayList<>();

        try {
            list = userBrandMapper.qryUserBrandRelList(map);
        } catch (Exception e) {
            throw new BusiException("查询用户与品牌间的关系失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史用户与品牌间的关系
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public List<UserBrand> qryUserBrandRelHisList(Map map) {
        List<UserBrand> list = new ArrayList<>();

        try {
            list = userBrandMapper.qryUserBrandRelHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史用户与品牌间的关系失败:" + e.getMessage());
        }

        return list;
    }


}
