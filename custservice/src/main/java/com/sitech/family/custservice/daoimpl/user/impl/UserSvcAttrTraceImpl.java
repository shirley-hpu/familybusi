package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserSvcAttrTrace;
import com.sitech.family.custservice.dto.mapperdto.UserSvcAttrTrace;
import com.sitech.family.custservice.mapper.IUserSvcAttrTraceMapper;
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
 * @author guanqp
 * @description 服务属性实例轨迹信息
 * @date 2018/12/28
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserSvcAttrTraceImpl implements IUserSvcAttrTrace {

    @Autowired
    private IUserSvcAttrTraceMapper mapper;

    /**
     * 创建服务属性实例轨迹信息
     *
     * @param userSvcAttrTrace
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserSvcAttrTrace userSvcAttrTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userSvcAttrTrace);

            mapper.insert(userSvcAttrTrace);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建服务属性实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 更新服务属性实例轨迹信息
     *
     * @param userSvcAttrTrace
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserSvcAttrTrace userSvcAttrTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal svcinsId = userSvcAttrTrace.getSvcinsId();
            String attrId = userSvcAttrTrace.getAttrId();
            String attrNo = userSvcAttrTrace.getAttrNo();
            Date effDate = userSvcAttrTrace.getEffDate();

            UserSvcAttrTrace userSvcAttrTrace1 = mapper.query(svcinsId, attrId, attrNo, effDate);

            if (StringUtil.isEmptyOrNull(userSvcAttrTrace1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新服务属性实例轨迹信息失败");
                return returnDto;
            }

            userSvcAttrTrace1.setUpdateAccept(userSvcAttrTrace.getUpdateAccept());
            userSvcAttrTrace1.setUpdateType(userSvcAttrTrace.getUpdateType());
            userSvcAttrTrace1.setUpdateTime(userSvcAttrTrace.getUpdateTime());
            userSvcAttrTrace1.setUpdateDate(userSvcAttrTrace.getUpdateDate());
            userSvcAttrTrace1.setUpdateLogin(userSvcAttrTrace.getUpdateLogin());
            userSvcAttrTrace1.setUpdateCode(userSvcAttrTrace.getUpdateCode());

            mapper.insert(userSvcAttrTrace1);

            mapper.modify(userSvcAttrTrace);

            userSvcAttrTrace.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userSvcAttrTrace);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改服务属性实例轨迹信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("更新服务属性实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 删除服务属性实例轨迹信息
     *
     * @param userSvcAttrTrace
     * @return null
     */
    @Override
    public ReturnDto drop(UserSvcAttrTrace userSvcAttrTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal svcinsId = userSvcAttrTrace.getSvcinsId();
            String attrId = userSvcAttrTrace.getAttrId();
            String attrNo = userSvcAttrTrace.getAttrNo();
            Date effDate = userSvcAttrTrace.getEffDate();

            UserSvcAttrTrace userSvcAttrTrace1 = mapper.query(svcinsId, attrId, attrNo, effDate);

            if (StringUtil.isEmptyOrNull(userSvcAttrTrace1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除服务属性实例轨迹信息失败");
                return returnDto;
            }

            userSvcAttrTrace1.setUpdateAccept(userSvcAttrTrace.getUpdateAccept());
            userSvcAttrTrace1.setUpdateType(userSvcAttrTrace.getUpdateType());
            userSvcAttrTrace1.setUpdateTime(userSvcAttrTrace.getUpdateTime());
            userSvcAttrTrace1.setUpdateDate(userSvcAttrTrace.getUpdateDate());
            userSvcAttrTrace1.setUpdateLogin(userSvcAttrTrace.getUpdateLogin());
            userSvcAttrTrace1.setUpdateCode(userSvcAttrTrace.getUpdateCode());

            mapper.insert(userSvcAttrTrace1);

            mapper.drop(userSvcAttrTrace);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除服务属性实例轨迹信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除服务属性实例轨迹信息成功");
        return returnDto;
    }

    /**
     * 查询服务属性实例轨迹信息
     *
     * @param svcinsId,attrId,attrNo,effDate
     * @return UserSvcAttrTrace
     */
    @Override
    public UserSvcAttrTrace query(BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        UserSvcAttrTrace userSvcAttrTrace = new UserSvcAttrTrace();

        try {
            userSvcAttrTrace = mapper.query(svcinsId, attrId, attrNo, effDate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询服务属性实例轨迹信息失败" + e.getMessage());
        }

        return userSvcAttrTrace;
    }

    /**
     * 查询服务属性实例轨迹信息信息
     *
     * @param map
     * @return List<UserSvcAttrTrace>
     */
    @Override
    public List<UserSvcAttrTrace> qryUserSvcAttrTraceList(Map map) {
        List<UserSvcAttrTrace> list = new ArrayList<>();

        try {
            list = mapper.qryUserSvcAttrTraceList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), " 查询服务实例轨迹信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询服务实例轨迹信息历史信息
     *
     * @param map
     * @return List<UserSvcAttrTrace>
     */
    @Override
    public List<UserSvcAttrTrace> qryUserSvcAttrTraceHisList(Map map) {
        List<UserSvcAttrTrace> list = new ArrayList<>();

        try {
            list = mapper.qryUserSvcAttrTraceHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), " 查询服务实例轨迹信息历史信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userSvcAttrTrace
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserSvcAttrTrace userSvcAttrTrace) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userSvcAttrTrace.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            List<UserSvcAttrTrace> userSvcAttrTraceList = qryUserSvcAttrTraceList(map);

            if (userSvcAttrTraceList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(userSvcAttrTrace);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
