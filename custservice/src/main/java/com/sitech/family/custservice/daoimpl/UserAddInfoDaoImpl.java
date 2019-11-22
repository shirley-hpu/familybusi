package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.daoimpl.user.IUserAdd;
import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.family.custservice.dto.mapperdto.UserAdd;
import com.sitech.family.dao.user.IUserAddInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserAddInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:56
 */
@Component
public class UserAddInfoDaoImpl implements IUserAddInfoDao {
    private static Logger logger = LoggerFactory.getLogger(UserAddInfoDaoImpl.class);

    @Autowired
    private IUserAdd iUserAdd;

    @Autowired
    private IUser iUser;

    /**
     * 新增家庭用户附加信息
     *
     * @param userAddInfo
     */
    @Override
    public ReturnDto create(UserAddInfo userAddInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = iUser.query(userAddInfo.getIdNo());

            if (StringUtil.isNotEmptyOrNull(user)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserAdd userAdd = new UserAdd();
            userAdd.setIdNo(userAddInfo.getIdNo());
            userAdd.setOpTime(userAdd.getOpTime());
            userAdd.setOtherValue(userAddInfo.getOtherValue());
            userAdd.setOpNote(userAdd.getOpNote());
            userAdd.setOpCode(userAdd.getOpCode());
            userAdd.setLoginNo(userAdd.getLoginNo());
            userAdd.setSystemNote(userAdd.getOpNote());
            userAdd.setFinishFlag(user.getFinishFlag());
            userAdd.setFieldValue(userAddInfo.getFieldValue());
            userAdd.setFieldCode(userAddInfo.getFieldCode());
            userAdd.setBusiType(userAddInfo.getBusiType());
            userAdd.setFieldOrder(userAddInfo.getFieldOrder());
            userAdd.setLoginAccept(userAdd.getLoginAccept());
            userAdd.setUpdateAccept(new Random().nextLong());
            userAdd.setUpdateCode("1");
            userAdd.setUpdateDate(1);
            userAdd.setUpdateLogin("1");
            userAdd.setUpdateTime(userAddInfo.getOpTime());
            userAdd.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            iUserAdd.create(userAdd);
        } catch (Exception e) {
            logger.error("新增家庭用户附加信息失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 修改家庭用户附加信息
     *
     * @param userAddInfo
     */
    @Override
    public ReturnDto modify(UserAddInfo userAddInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = iUser.query(userAddInfo.getIdNo());

            if (StringUtil.isNotEmptyOrNull(user)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserAdd userAdd = new UserAdd();
            userAdd.setIdNo(userAddInfo.getIdNo());
            userAdd.setOpTime(userAdd.getOpTime());
            userAdd.setOtherValue(userAddInfo.getOtherValue());
            userAdd.setOpNote(userAdd.getOpNote());
            userAdd.setOpCode(userAdd.getOpCode());
            userAdd.setLoginNo(userAdd.getLoginNo());
            userAdd.setSystemNote(userAdd.getOpNote());
            userAdd.setFinishFlag(user.getFinishFlag());
            userAdd.setFieldValue(userAddInfo.getFieldValue());
            userAdd.setFieldCode(userAddInfo.getFieldCode());
            userAdd.setBusiType(userAddInfo.getBusiType());
            userAdd.setFieldOrder(userAddInfo.getFieldOrder());
            userAdd.setLoginAccept(userAdd.getLoginAccept());
            userAdd.setUpdateAccept(new Random().nextLong());
            userAdd.setUpdateCode("1");
            userAdd.setUpdateDate(1);
            userAdd.setUpdateLogin("1");
            userAdd.setUpdateTime(userAddInfo.getOpTime());
            userAdd.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            iUserAdd.modify(userAdd);
        } catch (Exception e) {
            logger.error("修改家庭用户附加信息失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 删除家庭用户附加信息
     *
     * @param userAddInfo
     */
    @Override
    public ReturnDto drop(UserAddInfo userAddInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserAdd userAdd = new UserAdd();
            userAdd.setIdNo(userAddInfo.getIdNo());
            userAdd.setFieldCode(userAddInfo.getFieldCode());
            userAdd.setUpdateAccept(new Random().nextLong());
            userAdd.setUpdateCode("1");
            userAdd.setUpdateDate(1);
            userAdd.setUpdateLogin("1");
            userAdd.setUpdateTime(userAddInfo.getOpTime());
            userAdd.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            iUserAdd.drop(userAdd);
        } catch (Exception e) {
            logger.error("删除家庭用户附加信息失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 查询家庭用户附加信息
     *
     * @return userAddInfo
     */
    @Override
    public UserAddInfo query(Long idNo, String fieldCode) {
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(fieldCode)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserAdd userAddOne = iUserAdd.query(idNo, fieldCode);

            if (StringUtil.isEmptyOrNull(userAddOne)) {
                return new UserAddInfo();
            }

            UserAddInfo userAddInfo = new UserAddInfo();
            userAddInfo.setIdNo(userAddOne.getIdNo());
            userAddInfo.setOpTime(userAddOne.getOpTime());
            userAddInfo.setOtherValue(userAddOne.getOtherValue());
            userAddInfo.setOpNote(userAddOne.getOpNote());
            userAddInfo.setOpCode(userAddOne.getOpCode());
            userAddInfo.setLoginNo(userAddOne.getLoginNo());
            userAddInfo.setSystemNote(userAddOne.getSystemNote());
            userAddInfo.setFieldValue(userAddOne.getFieldValue());
            userAddInfo.setFieldCode(userAddOne.getFieldCode());
            userAddInfo.setBusiType(userAddOne.getBusiType());
            userAddInfo.setFieldOrder(userAddOne.getFieldOrder());
            userAddInfo.setLoginAccept(userAddOne.getLoginAccept());

            return userAddInfo;
        } catch (Exception e) {
            return new UserAddInfo();
        }
    }

    @Override
    public List<UserAddInfo> qryUserAddInfoList(Map map) {
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
}
