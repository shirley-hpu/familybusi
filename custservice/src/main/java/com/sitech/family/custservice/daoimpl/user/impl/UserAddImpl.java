package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserAdd;
import com.sitech.family.custservice.dto.mapperdto.UserAdd;
import com.sitech.family.custservice.mapper.IUserAddMapper;
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
 * @author wusm
 * @description
 * @date 2018/12/20 11:13
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserAddImpl implements IUserAdd {

    @Autowired
    private IUserAddMapper mapper;

    /**
     * 创建用户扩展属性信息
     *
     * @param userAdd
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserAdd userAdd) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userAdd);

            mapper.insert(userAdd);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "创建用户扩展属性信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建用户扩展属性信息成功");
        return returnDto;
    }

    /**
     * 更新用户扩展属性信息
     *
     * @param userAdd
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserAdd userAdd) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = userAdd.getIdNo();
            String fieldCode = userAdd.getFieldCode();
            UserAdd userAdd1 = mapper.query(idNo, fieldCode);

            if (StringUtil.isEmptyOrNull(userAdd1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,修改结账日信息失败");
                return returnDto;
            }

            userAdd1.setUpdateAccept(userAdd.getUpdateAccept());
            userAdd1.setUpdateType(userAdd.getUpdateType());
            userAdd1.setUpdateTime(userAdd.getUpdateTime());
            userAdd1.setUpdateDate(userAdd.getUpdateDate());
            userAdd1.setUpdateLogin(userAdd.getUpdateLogin());
            userAdd1.setUpdateCode(userAdd.getUpdateCode());

            mapper.insert(userAdd1);

            mapper.modify(userAdd);

            userAdd.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userAdd);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新用户扩展属性信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户扩展属性信息成功");
        return returnDto;
    }

    /**
     * 删除用户扩展属性信息
     *
     * @param userAdd
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserAdd userAdd) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = userAdd.getIdNo();
            String fieldCode = userAdd.getFieldCode();
            UserAdd userAdd1 = mapper.query(idNo, fieldCode);

            if (StringUtil.isEmptyOrNull(userAdd1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户扩展属性信息失败");
                return returnDto;
            }

            userAdd1.setUpdateAccept(userAdd.getUpdateAccept());
            userAdd1.setUpdateType(userAdd.getUpdateType());
            userAdd1.setUpdateTime(userAdd.getUpdateTime());
            userAdd1.setUpdateDate(userAdd.getUpdateDate());
            userAdd1.setUpdateLogin(userAdd.getUpdateLogin());
            userAdd1.setUpdateCode(userAdd.getUpdateCode());

            mapper.insert(userAdd1);

            mapper.drop(idNo, fieldCode);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户扩展属性信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户扩展属性信息成功");
        return returnDto;
    }

    /**
     * 查询用户扩展属性信息
     *
     * @param idNo,fieldCode
     * @return UserAdd
     */
    @Override
    public UserAdd query(Long idNo, String fieldCode) {
        UserAdd userAdd = new UserAdd();
        try {
            userAdd = mapper.query(idNo, fieldCode);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户扩展属性信息失败" + e.getMessage());
        }
        return userAdd;
    }

    /**
     * 查询用户扩展属性信息
     *
     * @param map
     * @return List<UserAdd>
     */
    @Override
    public List<UserAdd> qryUserAddList(Map map) {
        List<UserAdd> list = new ArrayList<>();

        try {
            list = mapper.qryUserAddList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户扩展属性信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户扩展属性信息
     *
     * @param map
     * @return List<UserAdd>
     */
    @Override
    public List<UserAdd> qryUserAddHisList(Map map) {
        List<UserAdd> list = new ArrayList<>();

        try {
            list = mapper.qryUserAddHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户扩展属性信息失败" + e.getMessage());
        }

        return list;
    }
}
