package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserPrc;
import com.sitech.family.custservice.dto.mapperdto.UserPrc;
import com.sitech.family.custservice.mapper.IUserPrcMapper;
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
 * @author wusm
 * @description 用户订购产品资费实例
 * @date 2018/12/10 10:27
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserPrcImpl implements IUserPrc {

    @Autowired
    private IUserPrcMapper mapper;

    /**
     * 创建用户订购产品资费实例信息
     *
     * @param userPrc
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserPrc userPrc) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userPrc);

            mapper.insert(userPrc);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建用户订购产品资费实例信息成功");
        return returnDto;
    }

    /**
     * 更新用户订购产品资费实例信息
     *
     * @param userPrc
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserPrc userPrc) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal prodprcinsId = userPrc.getProdprcinsId();
            UserPrc userPrc1 = mapper.query(prodprcinsId);

            if (StringUtil.isEmptyOrNull(userPrc1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户订购产品资费实例信息失败");
                return returnDto;
            }

            userPrc1.setUpdateAccept(userPrc.getUpdateAccept());
            userPrc1.setUpdateType(userPrc.getUpdateType());
            userPrc1.setUpdateTime(userPrc.getUpdateTime());
            userPrc1.setUpdateDate(userPrc.getUpdateDate());
            userPrc1.setUpdateLogin(userPrc.getUpdateLogin());
            userPrc1.setUpdateCode(userPrc.getUpdateCode());

            mapper.insert(userPrc1);

            mapper.modify(userPrc);

            userPrc.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userPrc);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户订购产品资费实例信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户订购产品资费实例信息成功");
        return returnDto;
    }

    /**
     * 删除用户订购产品资费实例信息
     *
     * @param userPrc
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserPrc userPrc) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal prodprcinsId = userPrc.getProdprcinsId();
            UserPrc userPrc1 = mapper.query(prodprcinsId);

            if (StringUtil.isEmptyOrNull(userPrc1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户订购产品资费实例信息失败");
                return returnDto;
            }

            userPrc1.setUpdateAccept(userPrc.getUpdateAccept());
            userPrc1.setUpdateType(userPrc.getUpdateType());
            userPrc1.setUpdateTime(userPrc.getUpdateTime());
            userPrc1.setUpdateDate(userPrc.getUpdateDate());
            userPrc1.setUpdateLogin(userPrc.getUpdateLogin());
            userPrc1.setUpdateCode(userPrc.getUpdateCode());

            mapper.insert(userPrc1);

            mapper.drop(prodprcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户订购产品资费实例信息失败");
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户订购产品资费实例信息成功");
        return returnDto;
    }

    /**
     * 查询用户订购产品资费实例信息
     *
     * @param prodprcinsId
     * @return List<UserPrc>
     */
    @Override
    public UserPrc query(BigDecimal prodprcinsId) {
        UserPrc userPrc = new UserPrc();
        try {
            userPrc = mapper.query(prodprcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户订购产品资费实例信息失败" + e.getMessage());
        }

        return userPrc;
    }

    /**
     * 查询用户订购产品资费实例历史信息
     *
     * @param map
     * @return List<UserPrc>
     */
    @Override
    public List<UserPrc> qryUserPrcInfoList(Map map) {
        List<UserPrc> list = new ArrayList<>();

        try {
            list = mapper.qryUserPrcInfoList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户订购产品资费实例信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户订购产品资费实例历史信息
     *
     * @param map
     * @return List<UserPrc>
     */
    @Override
    public List<UserPrc> qryUserPrcInfoHisList(Map map) {
        List<UserPrc> list = new ArrayList<>();

        try {
            list = mapper.qryUserPrcInfoHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户订购产品资费实例信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userPrc
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserPrc userPrc) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userPrc.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserPrc> userPrcList = qryUserPrcInfoList(map);

            if (userPrcList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(userPrc);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
