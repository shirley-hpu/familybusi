package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.family.custservice.mapper.IUserMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/19 17:44
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserImpl implements IUser {

    @Autowired
    private IUserMapper mapper;

    /**
     * 创建用户信息
     *
     * @param user
     * @return returnDto
     */
    @Override
    public ReturnDto create(User user) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(user);

            mapper.insert(user);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return returnDto
     */
    @Override
    public ReturnDto modify(User user) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = user.getIdNo();
            User user1 = mapper.query(idNo);

            if (StringUtil.isEmptyOrNull(user1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户信息失败");
                return returnDto;
            }

            user1.setUpdateAccept(user.getUpdateAccept());
            user1.setUpdateType(user.getUpdateType());
            user1.setUpdateTime(user.getUpdateTime());
            user1.setUpdateDate(user.getUpdateDate());
            user1.setUpdateLogin(user.getUpdateLogin());
            user1.setUpdateCode(user.getUpdateCode());

            mapper.insert(user1);

            mapper.modify(user);

            user.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(user);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户信息成功");
        return returnDto;
    }

    /**
     * 删除用户信息
     *
     * @param user
     * @return returnDto
     */
    @Override
    public ReturnDto drop(User user) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = user.getIdNo();
            User user1 = mapper.query(idNo);

            if (StringUtil.isEmptyOrNull(user1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户信息失败");
                return returnDto;
            }

            user1.setUpdateAccept(user.getUpdateAccept());
            user1.setUpdateType(user.getUpdateType());
            user1.setUpdateTime(user.getUpdateTime());
            user1.setUpdateDate(user.getUpdateDate());
            user1.setUpdateLogin(user.getUpdateLogin());
            user1.setUpdateCode(user.getUpdateCode());

            mapper.insert(user1);

            mapper.drop(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户信息成功");
        return returnDto;
    }

    /**
     * 查询用户信息
     *
     * @param idNo
     * @return User
     */
    @Override
    public User query(Long idNo) {
        User user = new User();
        try {
            user = mapper.query(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户信息失败" + e.getMessage());
        }
        return user;
    }

    /**
     * 查询用户信息
     *
     * @param map
     * @return List<User>
     */
    @Override
    public List<User> qryUserList(Map map) {
        List<User> list = new ArrayList<>();
        try {
            list = mapper.qryUserList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户信息失败" + e.getMessage());
        }
        return list;
    }

    /**
     * 查询历史用户信息
     *
     * @param map
     * @return List<User>
     */
    @Override
    public List<User> qryUserHisList(Map map) {
        List<User> list = new ArrayList<>();
        try {
            list = mapper.qryUserHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户信息失败" + e.getMessage());
        }
        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param user
     * @return
     */
    @Override
    public ReturnDto updateFinishState(User user) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",user.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            List<User> userList = qryUserList(map);

            if (userList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(user);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
