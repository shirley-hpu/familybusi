package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserFav;
import com.sitech.family.custservice.dto.mapperdto.UserFav;
import com.sitech.family.custservice.mapper.UserFavMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户优惠参数实例信息
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserFavImpl implements IUserFav {

    @Autowired
    private UserFavMapper userFavMapper;

    @Override
    public ReturnDto drop(UserFav userFav) {
        ReturnDto returnDto;

        try {
            List<UserFav> list = userFavMapper.query(userFav.getFavinsId());

            if (StringUtil.isEmptyOrNull(list) || list.size() == 0) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除优惠订购信息失败");
                return returnDto;
            }

            UserFav userFavDrop = list.get(0);
            userFavDrop.setUpdateAccept(userFav.getUpdateAccept());
            userFavDrop.setUpdateType(userFav.getUpdateType());
            userFavDrop.setUpdateTime(userFav.getUpdateTime());
            userFavDrop.setUpdateDate(userFav.getUpdateDate());
            userFavDrop.setUpdateLogin(userFav.getUpdateLogin());
            userFavDrop.setUpdateCode(userFav.getUpdateCode());

            userFavMapper.insert(userFavDrop);

            userFavMapper.drop(userFav.getFavinsId());
        } catch (Exception e) {
            throw new BusiException("删除优惠订购信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto create(UserFav userFav) {
        ReturnDto returnDto;

        try {
            userFavMapper.insert(userFav); //历史表

            userFavMapper.create(userFav);
        } catch (Exception e) {
            throw new BusiException("创建优惠订购信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public List<UserFav> query(BigDecimal favinsId) {
        List<UserFav> list = null;
        try {
            list = userFavMapper.query(favinsId);
        } catch (Exception e) {
            throw new BusiException("查询优惠订购信息失败:" + e.getMessage());
        }
        return list;
    }

    @Override
    public ReturnDto modify(UserFav userFav) {
        ReturnDto returnDto;

        try {
            List<UserFav> list = userFavMapper.query(userFav.getFavinsId());

            if (StringUtil.isEmptyOrNull(list) || list.size() == 0) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新优惠订购信息失败");
                return returnDto;
            }

            UserFav userFavTemp = list.get(0);
            userFavTemp.setUpdateAccept(userFav.getUpdateAccept());
            userFavTemp.setUpdateType(userFav.getUpdateType());
            userFavTemp.setUpdateTime(userFav.getUpdateTime());
            userFavTemp.setUpdateDate(userFav.getUpdateDate());
            userFavTemp.setUpdateLogin(userFav.getUpdateLogin());
            userFavTemp.setUpdateCode(userFav.getUpdateCode());

            userFavMapper.insert(userFavTemp);

            userFavMapper.modify(userFav);

            userFav.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userFavMapper.insert(userFav);
        } catch (Exception e) {
            throw new BusiException("更新优惠订购信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }
}
