package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserFavAttr;
import com.sitech.family.custservice.dto.mapperdto.UserFavAttr;
import com.sitech.family.custservice.mapper.UserFavAttrMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠参数实例
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserFavAttrImpl implements IUserFavAttr {

    @Autowired
    private UserFavAttrMapper userFavAttrMapper;

    @Override
    public ReturnDto drop(UserFavAttr userFavAttr) {
        ReturnDto returnDto;

        try {
            List<UserFavAttr> list = userFavAttrMapper.query(userFavAttr.getFavinsId(), userFavAttr.getAttrId(), userFavAttr.getEffDate());

            if (StringUtil.isEmptyOrNull(list) || list.size() == 0) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除优惠参数信息失败");
                return returnDto;
            }

            UserFavAttr userFavAttrDrop = list.get(0);
            userFavAttrDrop.setUpdateAccept(userFavAttr.getUpdateAccept());
            userFavAttrDrop.setUpdateType(userFavAttr.getUpdateType());
            userFavAttrDrop.setUpdateTime(userFavAttr.getUpdateTime());
            userFavAttrDrop.setUpdateDate(userFavAttr.getUpdateDate());
            userFavAttrDrop.setUpdateLogin(userFavAttr.getUpdateLogin());
            userFavAttrDrop.setUpdateCode(userFavAttr.getUpdateCode());

            userFavAttrMapper.insert(userFavAttrDrop);

            userFavAttrMapper.drop(userFavAttr.getFavinsId(), userFavAttr.getAttrId(), userFavAttr.getEffDate());
        } catch (Exception e) {
            throw new BusiException("删除优惠参数信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto create(UserFavAttr userFavAttr) {
        ReturnDto returnDto;

        try {
            userFavAttrMapper.insert(userFavAttr); //历史表

            userFavAttrMapper.create(userFavAttr);
        } catch (Exception e) {
            throw new BusiException("创建优惠参数信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public List<UserFavAttr> query(BigDecimal favinsId, String attrId, Date effDate) {
        List<UserFavAttr> list = null;
        try {
            list = userFavAttrMapper.query(favinsId, attrId, effDate);
        } catch (Exception e) {
            throw new BusiException("查询优惠参数信息失败:" + e.getMessage());
        }
        return list;
    }

    @Override
    public ReturnDto modify(UserFavAttr userFavAttr) {
        ReturnDto returnDto;

        try {
            List<UserFavAttr> list = userFavAttrMapper.query(userFavAttr.getFavinsId(), userFavAttr.getAttrId(), userFavAttr.getEffDate());

            if (StringUtil.isEmptyOrNull(list) || list.size() == 0) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新优惠参数信息失败");
                return returnDto;
            }

            UserFavAttr userFavAttrTemp = list.get(0);
            userFavAttrTemp.setUpdateAccept(userFavAttr.getUpdateAccept());
            userFavAttrTemp.setUpdateType(userFavAttr.getUpdateType());
            userFavAttrTemp.setUpdateTime(userFavAttr.getUpdateTime());
            userFavAttrTemp.setUpdateDate(userFavAttr.getUpdateDate());
            userFavAttrTemp.setUpdateLogin(userFavAttr.getUpdateLogin());
            userFavAttrTemp.setUpdateCode(userFavAttr.getUpdateCode());

            userFavAttrMapper.insert(userFavAttrTemp);

            userFavAttrMapper.modify(userFavAttr);

            userFavAttr.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userFavAttrMapper.insert(userFavAttr);
        } catch (Exception e) {
            throw new BusiException("更新优惠参数信息失败:" + e.getMessage());
        }

        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }
}
