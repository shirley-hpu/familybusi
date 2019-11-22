package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserSvcTrace;
import com.sitech.family.custservice.dto.mapperdto.UserSvcTrace;
import com.sitech.family.custservice.mapper.IUserSvcTraceMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 17:55
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserSvcTraceImpl implements IUserSvcTrace {

    @Autowired
    private IUserSvcTraceMapper mapper;

    /**
     * 创建服务实例轨迹信息
     *
     * @param userSvcTrace
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserSvcTrace userSvcTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userSvcTrace);

            mapper.insert(userSvcTrace);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建服务实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 更新服务实例轨迹信息
     *
     * @param userSvcTrace
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserSvcTrace userSvcTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal svcinsId = userSvcTrace.getSvcinsId();
            UserSvcTrace userSvcTrace1 = mapper.query(svcinsId);

            if (StringUtil.isEmptyOrNull(userSvcTrace1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新服务实例轨迹信息失败");
                return returnDto;
            }

            userSvcTrace1.setUpdateAccept(userSvcTrace.getUpdateAccept());
            userSvcTrace1.setUpdateType(userSvcTrace.getUpdateType());
            userSvcTrace1.setUpdateTime(userSvcTrace.getUpdateTime());
            userSvcTrace1.setUpdateDate(userSvcTrace.getUpdateDate());
            userSvcTrace1.setUpdateLogin(userSvcTrace.getUpdateLogin());
            userSvcTrace1.setUpdateCode(userSvcTrace.getUpdateCode());

            mapper.insert(userSvcTrace1);

            mapper.modify(userSvcTrace);

            userSvcTrace.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userSvcTrace);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改服务实例轨迹信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改服务实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 删除服务实例轨迹信息
     *
     * @param userSvcTrace
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserSvcTrace userSvcTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal svcinsId = userSvcTrace.getSvcinsId();
            UserSvcTrace userSvcTrace1 = mapper.query(svcinsId);

            if (StringUtil.isEmptyOrNull(userSvcTrace1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除服务实例轨迹信息失败");
                return returnDto;
            }

            userSvcTrace1.setUpdateAccept(userSvcTrace.getUpdateAccept());
            userSvcTrace1.setUpdateType(userSvcTrace.getUpdateType());
            userSvcTrace1.setUpdateTime(userSvcTrace.getUpdateTime());
            userSvcTrace1.setUpdateDate(userSvcTrace.getUpdateDate());
            userSvcTrace1.setUpdateLogin(userSvcTrace.getUpdateLogin());
            userSvcTrace1.setUpdateCode(userSvcTrace.getUpdateCode());

            mapper.insert(userSvcTrace1);

            mapper.drop(svcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除服务实例轨迹信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除服务实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 查询服务实例轨迹信息
     *
     * @param svcinsId
     * @return List<UserSvcTrace>
     */
    @Override
    public UserSvcTrace query(BigDecimal svcinsId) {
        UserSvcTrace userSvcTrace = new UserSvcTrace();

        try {
            userSvcTrace = mapper.query(svcinsId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务实例轨迹信息失败" + e.getMessage());
        }

        return userSvcTrace;
    }

    /**
     * 查询服务实例轨迹信息
     *
     * @param map
     * @return List<UserSvcTrace>
     */
    @Override
    public List<UserSvcTrace> qryUserSvcTraceInfoList(Map map) {
        List<UserSvcTrace> list = new ArrayList<>();

        try {
            list = mapper.qryUserSvcTraceInfoList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务实例轨迹信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询服务实例轨迹信息
     *
     * @param map
     * @return List<UserSvcTrace>
     */
    @Override
    public List<UserSvcTrace> qryUserSvcTraceInfoHisList(Map map) {
        List<UserSvcTrace> list = new ArrayList<>();

        try {
            list = mapper.qryUserSvcTraceInfoHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务实例轨迹信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userSvcTrace
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserSvcTrace userSvcTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userSvcTrace.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserSvcTrace> userSvcTraceList = qryUserSvcTraceInfoList(map);

            if (userSvcTraceList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(userSvcTrace);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
