package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IServiceNo;
import com.sitech.family.custservice.dto.mapperdto.ServiceNo;
import com.sitech.family.custservice.mapper.IServiceNoMapper;
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
 * @description 用户路由信息
 * @date 2018/12/20 16:52
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ServiceNoImpl implements IServiceNo {

    @Autowired
    private IServiceNoMapper mapper;

    /**
     * 创建用户路由信息
     *
     * @param serviceNo
     * @return returnDto
     */
    @Override
    public ReturnDto create(ServiceNo serviceNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(serviceNo);

            mapper.insert(serviceNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "创建用户路由信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建用户路由信息成功");
        return returnDto;
    }

    /**
     * 更新用户路由信息
     *
     * @param serviceNo
     * @return returnDto
     */
    @Override
    public ReturnDto modify(ServiceNo serviceNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = serviceNo.getIdNo();
            String serviceno = serviceNo.getServiceNo();
            String serviceType = serviceNo.getServiceType();

            ServiceNo serviceNo1 = mapper.query(idNo,serviceno,serviceType);

            if (StringUtil.isEmptyOrNull(serviceNo1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户路由信息失败");
                return returnDto;
            }

            serviceNo1.setUpdateAccept(serviceNo.getUpdateAccept());
            serviceNo1.setUpdateType(serviceNo.getUpdateType());
            serviceNo1.setUpdateTime(serviceNo.getUpdateTime());
            serviceNo1.setUpdateDate(serviceNo.getUpdateDate());
            serviceNo1.setUpdateLogin(serviceNo.getUpdateLogin());
            serviceNo1.setUpdateCode(serviceNo.getUpdateCode());

            mapper.insert(serviceNo1);

            mapper.modify(serviceNo);

            serviceNo.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(serviceNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户路由信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户路由信息成功");
        return returnDto;
    }

    /**
     * 删除用户路由信息
     *
     * @param serviceNo
     * @return returnDto
     */
    @Override
    public ReturnDto drop(ServiceNo serviceNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = serviceNo.getIdNo();
            String serviceno = serviceNo.getServiceNo();
            String serviceType = serviceNo.getServiceType();

            ServiceNo serviceNo1 = mapper.query(idNo,serviceno,serviceType);

            if (StringUtil.isEmptyOrNull(serviceNo1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户路由信息失败");
                return returnDto;
            }

            serviceNo1.setUpdateAccept(serviceNo.getUpdateAccept());
            serviceNo1.setUpdateType(serviceNo.getUpdateType());
            serviceNo1.setUpdateTime(serviceNo.getUpdateTime());
            serviceNo1.setUpdateDate(serviceNo.getUpdateDate());
            serviceNo1.setUpdateLogin(serviceNo.getUpdateLogin());
            serviceNo1.setUpdateCode(serviceNo.getUpdateCode());

            mapper.insert(serviceNo1);

            mapper.drop(serviceNo);
        }catch (Exception e){
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户路由信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户路由信息成功");
        return returnDto;
    }

    /**
     * 查询用户路由信息
     *
     * @param idNo,serviceNo,serviceType
     * @return ServiceNo
     */
    @Override
    public ServiceNo query(Long idNo, String serviceNo, String serviceType) {
        ServiceNo serviceNo1 = new ServiceNo();

        try {
            serviceNo1 = mapper.query(idNo,serviceNo,serviceType);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户路由信息失败"+e.getMessage());
        }

        return serviceNo1;
    }

    /**
     * 查询用户路由信息
     *
     * @param map
     * @return ServiceNo
     */
    @Override
    public List<ServiceNo> qryServiceNoList(Map map) {
        List<ServiceNo> list = new ArrayList<>();

        try {
            list = mapper.qryServiceNoList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户路由信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户路由历史信息
     *
     * @param map
     * @return List<ServiceNo>
     */
    @Override
    public List<ServiceNo> qryServiceNoHisList(Map map) {
        List<ServiceNo> list = new ArrayList<>();

        try {
            list = mapper.qryServiceNoHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户路由信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param serviceNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(ServiceNo serviceNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",serviceNo.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            List<ServiceNo> serviceNoList = qryServiceNoList(map);

            if (serviceNoList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(serviceNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
