package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.*;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.daoimpl.user.IUserDetail;
import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import com.sitech.family.dao.user.IUserInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.boot.core.util.encrypt.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 16:59
 */
@Component
public class UserInfoDaoImpl implements IUserInfoDao {

    @Autowired
    private IUser iUser;

    @Autowired
    private IUserDetail iUserDetail;

    /**
     * 新增家庭用户
     *
     * @param userInfo
     */
    @Override
    public ReturnDto create(UserInfo userInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = new User();
            user.setAccessType(null);
            user.setAssureFlag(AssureFlagEnum.VAL_0.getValue());
            user.setBillType(BillTypeEnum.VAL_11.getValue());
            user.setBrandCreateType(BrandCreateTypeEnum.VAL_1.getValue());
            user.setMasterServId(MasterServIdEnum.VAL_1001.getValue());
            user.setGroupFlag(GroupFlagEnum.VAL_Y.getValue());
            user.setPhotoFlag(PhotoFlagEnum.VAL_Y.getValue());
            user.setBakField("");
            user.setBakField1(null);
            user.setBillEndTime(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            user.setBillingCycleTypeId(0L);
            user.setBillStartTime(userInfo.getOpTime());
            user.setCmdRight(0L);
            user.setCompletedDate(userInfo.getOpTime());
            user.setCreateDate(userInfo.getOpTime());
            user.setFirstUsedate(null);
            user.setOwnedChnlId(userInfo.getGroupId());
            user.setOwnerType(OwnerTypeEnum.VAL_2.getValue());
            user.setRentDate(null);
            user.setServiceGroup(userInfo.getGroupId());
            user.setStopRentDate(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            user.setContractNo(userInfo.getContractNo());
            user.setCreateLogin(userInfo.getCreateLogin());
            user.setCustId(userInfo.getCustId());
            user.setEmpGroup(userInfo.getEmpGroup());
            user.setEmpId(userInfo.getEmpId());
            user.setFinishFlag(userInfo.getFinishFlag());
            user.setGroupId(userInfo.getGroupId());
            user.setIdNo(userInfo.getIdNo());
            user.setLoginAccept(userInfo.getLoginAccept());
            user.setLoginNo(userInfo.getLoginNo());
            user.setOpCode(userInfo.getOpCode());
            user.setOpenTime(userInfo.getOpenTime());
            user.setOpTime(userInfo.getOpTime());
            user.setPhoneNo(userInfo.getPhoneNo());

            user.setUpdateAccept(new Random().nextLong());
            user.setUpdateCode(null);
            user.setUpdateDate(null);
            user.setUpdateLogin(null);
            user.setUpdateTime(userInfo.getOpTime());
            user.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = iUser.create(user);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserDetail userDetail = new UserDetail();
            userDetail.setPasswdType(PasswdTypeEnum.VAL_0.getValue());
            userDetail.setQueryCdrflag(QueryCdrflagEnum.VAL_Y.getValue());
            userDetail.setBak1(null);
            userDetail.setBak2(null);
            userDetail.setCardType(CardTypeEnum.VAL_1.getValue());
            userDetail.setIdNo(userInfo.getIdNo());
            userDetail.setLmtAdjustType(LmtAdjustTypeEnum.VAL_10.getValue());
            userDetail.setOwedFlag(OwedFlagEnum.VAL_Y.getValue());
            userDetail.setStopFlag(StopFlagEnum.VAL_Y.getValue());
            userDetail.setUserGradeCode(UserGradeCodeEnum.VAL_03.getValue());
            userDetail.setVipCardNo(null);
            userDetail.setVipCreateType(VIPCreateTypeEnum.VAL_2.getValue());
            userDetail.setLoginAccept(userInfo.getLoginAccept());
            userDetail.setLoginNo(userInfo.getLoginNo());
            userDetail.setOldRun(userInfo.getOldRun());
            userDetail.setOpCode(userInfo.getOpCode());
            userDetail.setOpNote(userInfo.getOpNote());
            userDetail.setOpTime(userInfo.getOpTime());
            userDetail.setRunCode(userInfo.getRunCode());
            userDetail.setRunTime(userInfo.getRunTime());
            userDetail.setSystemNote(userInfo.getSystemNote());

            //DES的加密算法"DES/ECB/PKCS5Padding"，返回是十六进制字符串
            //CodecUtil.encodeDES(UserPasswdEnum.VAL_PASSWD.getValue());
            userDetail.setUserPasswd(CodecUtil.encodeDES(UserPasswdEnum.VAL_PASSWD.getValue()));
            userDetail.setUpdateAccept(new Random().nextLong());
            userDetail.setUpdateCode(null);
            userDetail.setUpdateDate(null);
            userDetail.setUpdateLogin(null);
            userDetail.setUpdateTime(userInfo.getOpTime());
            userDetail.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            ReturnDto returnDto1 = iUserDetail.create(userDetail);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto1.getCode())) {
                returnDto1.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto1.setMessage(returnDto.getMessage());
                return returnDto1;
            }

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 修改家庭用户
     *
     * @param userInfo
     */
    @Override
    public ReturnDto modify(UserInfo userInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = new User();
            user.setAccessType(AccessTypeEnum.VAL_001.getValue());
            user.setAssureFlag(AssureFlagEnum.VAL_0.getValue());
            user.setBillType(BillTypeEnum.VAL_11.getValue());
            user.setBrandCreateType(BrandCreateTypeEnum.VAL_1.getValue());
            user.setMasterServId(MasterServIdEnum.VAL_1001.getValue());
            user.setGroupFlag(GroupFlagEnum.VAL_Y.getValue());
            user.setPhotoFlag(PhotoFlagEnum.VAL_Y.getValue());
            user.setBakField("1");
            user.setBakField1("1");
            user.setBillEndTime(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            user.setBillingCycleTypeId(1L);
            user.setBillStartTime(userInfo.getOpTime());
            user.setCmdRight(1L);
            user.setCompletedDate(userInfo.getOpTime());
            user.setCreateDate(userInfo.getOpTime());
            user.setFirstUsedate(userInfo.getOpTime());
            user.setOwnedChnlId("1");
            user.setOwnerType(1);
            user.setRentDate(userInfo.getOpTime());
            user.setServiceGroup("1");
            user.setStopRentDate(DateUtil.toDate("2099-12-31 23:59:59", "YYYY-MM-dd HH:mm:ss"));
            user.setContractNo(userInfo.getContractNo());
            user.setCreateLogin(userInfo.getCreateLogin());
            user.setCustId(userInfo.getCustId());
            user.setEmpGroup(userInfo.getEmpGroup());
            user.setEmpId(userInfo.getEmpId());
            user.setFinishFlag(userInfo.getFinishFlag());
            user.setGroupId(userInfo.getGroupId());
            user.setIdNo(userInfo.getIdNo());
            user.setLoginAccept(userInfo.getLoginAccept());
            user.setLoginNo(userInfo.getLoginNo());
            user.setOpCode(userInfo.getOpCode());
            user.setOpenTime(userInfo.getOpenTime());
            user.setOpTime(userInfo.getOpTime());
            user.setPhoneNo(userInfo.getPhoneNo());

            user.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            user.setUpdateAccept(new Random().nextLong());
            user.setUpdateCode("1");
            user.setUpdateDate(1);
            user.setUpdateLogin("1");
            user.setUpdateTime(userInfo.getOpTime());

            returnDto = iUser.modify(user);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserDetail userDetail = new UserDetail();
            userDetail.setPasswdType(PasswdTypeEnum.VAL_0.getValue());
            userDetail.setQueryCdrflag(QueryCdrflagEnum.VAL_Y.getValue());
            userDetail.setBak1("1");
            userDetail.setBak2("1");
            userDetail.setCardType(1L);
            userDetail.setIdNo(userInfo.getIdNo());
            userDetail.setLmtAdjustType("1");
            userDetail.setOwedFlag("1");
            userDetail.setStopFlag("1");
            userDetail.setUserGradeCode("1");
            userDetail.setVipCardNo("1");
            userDetail.setVipCreateType(1);
            userDetail.setLoginAccept(userInfo.getLoginAccept());
            userDetail.setLoginNo(userInfo.getLoginNo());
            userDetail.setOldRun(userInfo.getOldRun());
            userDetail.setOpCode(userInfo.getOpCode());
            userDetail.setOpNote(userInfo.getOpNote());
            userDetail.setOpTime(userInfo.getOpTime());
            userDetail.setRunCode(userInfo.getRunCode());
            userDetail.setRunTime(userInfo.getRunTime());
            userDetail.setSystemNote(userInfo.getSystemNote());
            userDetail.setUserPasswd(userInfo.getUserPasswd());

            userDetail.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            userDetail.setUpdateAccept(new Random().nextLong());
            userDetail.setUpdateCode("1");
            userDetail.setUpdateDate(1);
            userDetail.setUpdateLogin("1");
            userDetail.setUpdateTime(userDetail.getOpTime());

            iUserDetail.modify(userDetail);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 删除家庭用户
     *
     * @param userInfo
     */
    @Override
    public ReturnDto drop(UserInfo userInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            User user = new User();
            user.setIdNo(userInfo.getIdNo());
            user.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            user.setUpdateAccept(new Random().nextLong());
            user.setUpdateCode("1");
            user.setUpdateDate(1);
            user.setUpdateLogin("1");
            user.setUpdateTime(userInfo.getOpTime());

            returnDto = iUser.drop(user);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserDetail userDetail = new UserDetail();
            userDetail.setIdNo(userInfo.getIdNo());
            userDetail.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            userDetail.setUpdateAccept(new Random().nextLong());
            userDetail.setUpdateCode("1");
            userDetail.setUpdateDate(1);
            userDetail.setUpdateLogin("1");
            userDetail.setUpdateTime(userInfo.getOpTime());

            iUserDetail.drop(userDetail);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 查询家庭用户
     *
     * @param idNo
     * @return userInfo
     */
    @Override
    public UserInfo query(Long idNo) {
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            User user = iUser.query(idNo);

            if (StringUtil.isEmptyOrNull(user)) {
                return new UserInfo();
            }

            UserDetail userDetail = iUserDetail.query(idNo);

            if (StringUtil.isEmptyOrNull(userDetail)) {
                return new UserInfo();
            }

            UserInfo userInfo = new UserInfo();
            userInfo.setIdNo(user.getIdNo());
            userInfo.setPhoneNo(user.getPhoneNo());
            userInfo.setContractNo(user.getContractNo());
            userInfo.setCustId(user.getCustId());
            userInfo.setUserPasswd(userDetail.getUserPasswd());
            userInfo.setRunCode(userDetail.getRunCode());
            userInfo.setRunTime(userDetail.getRunTime());
            userInfo.setOldRun(userDetail.getOldRun());
            userInfo.setFinishFlag(user.getFinishFlag());
            userInfo.setGroupId(user.getGroupId());
            userInfo.setOpenTime(user.getOpenTime());
            userInfo.setCreateLogin(user.getCreateLogin());
            userInfo.setCreateGroup(user.getServiceGroup());
            userInfo.setEmpId(user.getEmpId());
            userInfo.setEmpGroup(user.getEmpGroup());
            userInfo.setOpTime(user.getOpTime());
            userInfo.setOpCode(user.getOpCode());
            userInfo.setLoginNo(user.getLoginNo());
            userInfo.setOupAccept("1");
            userInfo.setLoginAccept(user.getLoginAccept());
            userInfo.setOpNote(userDetail.getOpNote());
            userInfo.setSystemNote(userDetail.getSystemNote());

            return userInfo;
        } catch (Exception e) {
            return new UserInfo();
        }
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {
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
            User user = new User();
            user.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            user.setIdNo(idNo);
            user.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            user.setLoginNo(updateOprInfo.getLoginNo());
            user.setOpCode(updateOprInfo.getOpCode());
            user.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUser.updateFinishState(user);
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
