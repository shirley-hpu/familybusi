package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IServiceNo;
import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.dto.mapperdto.ServiceNo;
import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.family.dao.user.IServiceNoInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserServiceNoInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:22
 */
@Component
public class ServiceNoInfoDaoImpl implements IServiceNoInfoDao {
    private static Logger logger = LoggerFactory.getLogger(ServiceNoInfoDaoImpl.class);

    @Autowired
    private IServiceNo iServiceNo;

    @Autowired
    private IUser iUser;

    /**
     * 新增家庭用户状态
     *
     * @param userServiceNoInfo
     */
    @Override
    public ReturnDto create(UserServiceNoInfo userServiceNoInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = iUser.query(userServiceNoInfo.getIdNo());

            if (StringUtil.isEmptyOrNull(user)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            ServiceNo serviceNo = new ServiceNo();
            serviceNo.setServiceNo(user.getPhoneNo());
            serviceNo.setServiceType("01");//SERVICE_TYPE固定为01（代表开户号码自身）
            serviceNo.setOpCode(userServiceNoInfo.getOpCode());
            serviceNo.setMasterServId(user.getMasterServId());
            serviceNo.setLoginNo(userServiceNoInfo.getLoginNo());
            serviceNo.setFinishFlag(user.getFinishFlag());
            serviceNo.setIdNo(userServiceNoInfo.getIdNo());
            serviceNo.setLoginAccept(userServiceNoInfo.getLoginAccept());
            serviceNo.setOpTime(userServiceNoInfo.getOpTime());
            serviceNo.setUpdateAccept(new Random().nextLong());
            serviceNo.setUpdateCode("1");
            serviceNo.setUpdateDate(1);
            serviceNo.setUpdateLogin("1");
            serviceNo.setUpdateTime(userServiceNoInfo.getOpTime());
            serviceNo.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = iServiceNo.create(serviceNo);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 修改家庭用户状态
     *
     * @param userServiceNoInfo
     */
    @Override
    public ReturnDto modify(UserServiceNoInfo userServiceNoInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = iUser.query(userServiceNoInfo.getIdNo());

            if (StringUtil.isNotEmptyOrNull(user)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            ServiceNo serviceNo = new ServiceNo();
            serviceNo.setServiceNo(userServiceNoInfo.getServiceNo());
            serviceNo.setServiceType(userServiceNoInfo.getServiceType());
            serviceNo.setOpCode(userServiceNoInfo.getOpCode());
            serviceNo.setMasterServId(user.getMasterServId());
            serviceNo.setLoginNo(userServiceNoInfo.getLoginNo());
            serviceNo.setFinishFlag(user.getFinishFlag());
            serviceNo.setIdNo(userServiceNoInfo.getIdNo());
            serviceNo.setLoginAccept(userServiceNoInfo.getLoginAccept());
            serviceNo.setOpTime(userServiceNoInfo.getOpTime());
            serviceNo.setUpdateAccept(new Random().nextLong());
            serviceNo.setUpdateCode("1");
            serviceNo.setUpdateDate(1);
            serviceNo.setUpdateLogin("1");
            serviceNo.setUpdateTime(userServiceNoInfo.getOpTime());
            serviceNo.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            returnDto = iServiceNo.modify(serviceNo);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            logger.error("修改家庭用户状态失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 删除家庭用户状态
     *
     * @param userServiceNoInfo
     */
    @Override
    public ReturnDto drop(UserServiceNoInfo userServiceNoInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            ServiceNo serviceNo = new ServiceNo();
            serviceNo.setIdNo(userServiceNoInfo.getIdNo());
            serviceNo.setServiceNo(userServiceNoInfo.getServiceNo());
            serviceNo.setServiceType(userServiceNoInfo.getServiceType());
            serviceNo.setUpdateAccept(new Random().nextLong());
            serviceNo.setUpdateCode("1");
            serviceNo.setUpdateDate(1);
            serviceNo.setUpdateLogin("1");
            serviceNo.setUpdateTime(userServiceNoInfo.getOpTime());
            serviceNo.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            returnDto = iServiceNo.drop(serviceNo);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            logger.error("删除家庭用户状态失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 查询家庭用户状态
     *
     * @return userServiceNoInfo
     */
    @Override
    public UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType) {

        if (StringUtil.isEmptyOrNull(serviceNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(serviceType)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {

            ServiceNo serviceNoQry = iServiceNo.query(idNo, serviceNo, serviceType);


            if (StringUtil.isEmptyOrNull(serviceNoQry)) {
                return new UserServiceNoInfo();
            }

            UserServiceNoInfo userServiceNoInfo = new UserServiceNoInfo();
            userServiceNoInfo.setServiceNo(serviceNoQry.getServiceNo());
            userServiceNoInfo.setServiceType(serviceNoQry.getServiceType());
            userServiceNoInfo.setOpCode(serviceNoQry.getOpCode());
            userServiceNoInfo.setLoginNo(serviceNoQry.getLoginNo());
            userServiceNoInfo.setIdNo(serviceNoQry.getIdNo());
            userServiceNoInfo.setLoginAccept(serviceNoQry.getLoginAccept());
            userServiceNoInfo.setOpTime(serviceNoQry.getOpTime());
            return userServiceNoInfo;
        } catch (Exception e) {
            return new UserServiceNoInfo();
        }
    }

    @Override
    public List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            //TODO 待物理层方法修改好后


            return null;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            ServiceNo serviceNo = new ServiceNo();
            serviceNo.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            serviceNo.setIdNo(idNo);
            serviceNo.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            serviceNo.setLoginNo(updateOprInfo.getLoginNo());
            serviceNo.setOpCode(updateOprInfo.getOpCode());
            serviceNo.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iServiceNo.updateFinishState(serviceNo);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
