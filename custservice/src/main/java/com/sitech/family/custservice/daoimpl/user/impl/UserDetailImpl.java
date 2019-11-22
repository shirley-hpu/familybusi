package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserDetail;
import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import com.sitech.family.custservice.mapper.UserDetailMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 用户详细信息
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserDetailImpl implements IUserDetail {

    @Autowired
    private UserDetailMapper userDetailMapper;

    /**
     * 创建用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserDetail userDetail) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userDetailMapper.insert(userDetail);

            userDetailMapper.create(userDetail);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserDetail userDetail) {
        ReturnDto returnDto = new ReturnDto();

        try {

            UserDetail userDetailDrop = userDetailMapper.query(userDetail.getIdNo());

            if (StringUtil.isEmptyOrNull(userDetailDrop)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户详细信息失败");
                return returnDto;
            }

            userDetailDrop.setUpdateAccept(userDetail.getUpdateAccept());
            userDetailDrop.setUpdateType(userDetail.getUpdateType());
            userDetailDrop.setUpdateTime(userDetail.getUpdateTime());
            userDetailDrop.setUpdateDate(userDetail.getUpdateDate());
            userDetailDrop.setUpdateLogin(userDetail.getUpdateLogin());
            userDetailDrop.setUpdateCode(userDetail.getUpdateCode());

            userDetailMapper.insert(userDetailDrop);

            userDetailMapper.drop(userDetail);
        } catch (Exception e) {
            throw new BusiException("删除用户详细信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新用户详细信息
     *
     * @param userDetail
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserDetail userDetail) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserDetail userDetailTemp = userDetailMapper.query(userDetail.getIdNo());

            if (StringUtil.isEmptyOrNull(userDetailTemp)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户详细信息失败");
                return returnDto;
            }

            userDetailTemp.setUpdateAccept(userDetail.getUpdateAccept());
            userDetailTemp.setUpdateType(userDetail.getUpdateType());
            userDetailTemp.setUpdateTime(userDetail.getUpdateTime());
            userDetailTemp.setUpdateDate(userDetail.getUpdateDate());
            userDetailTemp.setUpdateLogin(userDetail.getUpdateLogin());
            userDetailTemp.setUpdateCode(userDetail.getUpdateCode());

            userDetailMapper.insert(userDetailTemp);

            userDetailMapper.modify(userDetail);

            userDetail.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userDetailMapper.insert(userDetail);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "用户信息修改失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询用户详细信息
     *
     * @param idNo
     * @return
     */
    @Override
    public UserDetail query(Long idNo) {
        UserDetail userDetail = new UserDetail();

        try {
            userDetail = userDetailMapper.query(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户详细信息失败" + e.getMessage());
        }

        return userDetail;
    }

    /**
     * 查询用户详细信息
     *
     * @param map
     * @return List<UserDetail>
     */
    @Override
    public List<UserDetail> qryUserDetailList(Map map) {
        List<UserDetail> list = new ArrayList<>();

        try {
            list = userDetailMapper.qryUserDetailList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户详细信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史用户详细信息
     *
     * @param map
     * @return List<UserDetail>
     */
    @Override
    public List<UserDetail> qryUserDetailHisList(Map map) {
        List<UserDetail> list = new ArrayList<>();

        try {
            list = userDetailMapper.qryUserDetailHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询历史用户详细信息失败" + e.getMessage());
        }

        return list;
    }
}
