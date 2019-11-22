package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.custservice.mapper.UserGroupMbrMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 群成员实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGroupMbrImpl implements IUserGroupMbr {

    @Autowired
    private UserGroupMbrMapper userGroupMbrMapper;

    /**
     * 创建群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGroupMbr userGroupMbr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userGroupMbrMapper.insert(userGroupMbr);

            userGroupMbrMapper.create(userGroupMbr);
        } catch (Exception e) {
            throw new BusiException("创建群成员实例信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGroupMbr userGroupMbr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroupMbr userGoodsDrop = userGroupMbrMapper.query(userGroupMbr.getMemberId());

            if (StringUtil.isEmptyOrNull(userGoodsDrop)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除群成员实例信息失败");
                return returnDto;
            }

            userGoodsDrop.setUpdateAccept(userGroupMbr.getUpdateAccept());
            userGoodsDrop.setUpdateType(userGroupMbr.getUpdateType());
            userGoodsDrop.setUpdateTime(userGroupMbr.getUpdateTime());
            userGoodsDrop.setUpdateDate(userGroupMbr.getUpdateDate());
            userGoodsDrop.setUpdateLogin(userGroupMbr.getUpdateLogin());
            userGoodsDrop.setUpdateCode(userGroupMbr.getUpdateCode());

            userGroupMbrMapper.insert(userGoodsDrop);

            userGroupMbrMapper.drop(userGroupMbr.getMemberId());
        } catch (Exception e) {
            throw new BusiException("删除群成员实例信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新群成员实例信息
     *
     * @param userGroupMbr
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGroupMbr userGroupMbr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGroupMbr userGroupMbrTemp = userGroupMbrMapper.query(userGroupMbr.getMemberId());

            if (StringUtil.isEmptyOrNull(userGroupMbrTemp)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新群成员实例信息失败");
                return returnDto;
            }

            userGroupMbrTemp.setUpdateAccept(userGroupMbr.getUpdateAccept());
            userGroupMbrTemp.setUpdateType(userGroupMbr.getUpdateType());
            userGroupMbrTemp.setUpdateTime(userGroupMbr.getUpdateTime());
            userGroupMbrTemp.setUpdateDate(userGroupMbr.getUpdateDate());
            userGroupMbrTemp.setUpdateLogin(userGroupMbr.getUpdateLogin());
            userGroupMbrTemp.setUpdateCode(userGroupMbr.getUpdateCode());

            userGroupMbrMapper.insert(userGroupMbrTemp);

            userGroupMbrMapper.modify(userGroupMbr);

            userGroupMbr.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userGroupMbrMapper.insert(userGroupMbr);
        } catch (Exception e) {
            throw new BusiException("更新群成员实例信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询群成员实例信息
     *
     * @param memberId
     * @return UserGroupMbr
     */
    @Override
    public UserGroupMbr query(BigDecimal memberId) {
        UserGroupMbr userGroupMbr = new UserGroupMbr();

        try {
            userGroupMbr = userGroupMbrMapper.query(memberId);
        } catch (Exception e) {
            throw new BusiException("查询群成员实例信息失败:" + e.getMessage());
        }

        return userGroupMbr;
    }

    /**
     * 查询群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    @Override
    public List<UserGroupMbr> qryUserGroupMbrList(Map map) {
        List<UserGroupMbr> list = new ArrayList<>();

        try {
            list = userGroupMbrMapper.qryUserGroupMbrList(map);
        } catch (Exception e) {
            throw new BusiException("查询群成员实例信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史群成员实例信息
     *
     * @param map
     * @return List<UserGroupMbr>
     */
    @Override
    public List<UserGroupMbr> qryUserGroupMbrHisList(Map map) {
        List<UserGroupMbr> list = new ArrayList<>();

        try {
            list = userGroupMbrMapper.qryUserGroupMbrHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史群成员实例信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userGroupMbr
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserGroupMbr userGroupMbr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("objectId",userGroupMbr.getObjectId());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserGroupMbr> userGroupMbrList = userGroupMbrMapper.qryUserGroupMbrList(map);

            if (userGroupMbrList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            userGroupMbrMapper.updateFinishState(userGroupMbr);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }

    /**
     * 查询短流程订单
     *
     * @param map
     * @return
     */
    @Override
    public List<UserGroupMbr> qryShortProcessList(Map map) {
        List<UserGroupMbr> list = new ArrayList<>();

        try {
            list = userGroupMbrMapper.qryShortProcessList(map);
        } catch (Exception e) {
            throw new BusiException("查询群成员实例信息失败:" + e.getMessage());
        }

        return list;
    }
}
