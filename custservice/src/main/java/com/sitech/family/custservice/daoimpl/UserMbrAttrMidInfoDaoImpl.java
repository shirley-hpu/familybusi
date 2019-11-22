package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IMbrAttrMid;
import com.sitech.family.custservice.dto.mapperdto.MbrAttrMid;
import com.sitech.family.dao.usergroup.IUserMbrAttrMidInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 22:00
 */
@Component
public class UserMbrAttrMidInfoDaoImpl implements IUserMbrAttrMidInfoDao {

    @Autowired
    private IMbrAttrMid iMbrAttrMid;

    /**
     * 新增
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    @Override
    public ReturnDto create(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrAttrMid mbrAttrMid = new MbrAttrMid();

            mbrAttrMid.setInsType(userMbrAttrMidInfo.getInsType());
            mbrAttrMid.setInsValue(userMbrAttrMidInfo.getInsValue());
            mbrAttrMid.setAttrId(userMbrAttrMidInfo.getAttrId());
            mbrAttrMid.setEffDate(userMbrAttrMidInfo.getEffDate());
            mbrAttrMid.setAttrNo(userMbrAttrMidInfo.getAttrNo());
            mbrAttrMid.setAttrValue(userMbrAttrMidInfo.getAttrValue());
            mbrAttrMid.setGrpNo(userMbrAttrMidInfo.getGrpNo());
            mbrAttrMid.setExpDate(userMbrAttrMidInfo.getExpDate());
            mbrAttrMid.setOpTime(userMbrAttrMidInfo.getOpTime());
            mbrAttrMid.setOpCode(userMbrAttrMidInfo.getOpCode());
            mbrAttrMid.setLoginNo(userMbrAttrMidInfo.getLoginNo());
            mbrAttrMid.setOutAccept(userMbrAttrMidInfo.getOutAccept());
            mbrAttrMid.setLoginAccept(userMbrAttrMidInfo.getLoginAccept());
            mbrAttrMid.setOpNote(userMbrAttrMidInfo.getOpNote());
            mbrAttrMid.setSystemNote(userMbrAttrMidInfo.getSystemNote());
            mbrAttrMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrAttrMid.setUpdateCode("1");
            mbrAttrMid.setUpdateDate(1);
            mbrAttrMid.setUpdateLogin("1");
            mbrAttrMid.setUpdateTime(userMbrAttrMidInfo.getOpTime());
            mbrAttrMid.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = iMbrAttrMid.create(mbrAttrMid);

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
     * 修改
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    @Override
    public ReturnDto modify(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrAttrMid mbrAttrMid = new MbrAttrMid();

            mbrAttrMid.setInsType(userMbrAttrMidInfo.getInsType());
            mbrAttrMid.setInsValue(userMbrAttrMidInfo.getInsValue());
            mbrAttrMid.setAttrId(userMbrAttrMidInfo.getAttrId());
            mbrAttrMid.setEffDate(userMbrAttrMidInfo.getEffDate());
            mbrAttrMid.setAttrNo(userMbrAttrMidInfo.getAttrNo());
            mbrAttrMid.setAttrValue(userMbrAttrMidInfo.getAttrValue());
            mbrAttrMid.setGrpNo(userMbrAttrMidInfo.getGrpNo());
            mbrAttrMid.setExpDate(userMbrAttrMidInfo.getExpDate());
            mbrAttrMid.setOpTime(userMbrAttrMidInfo.getOpTime());
            mbrAttrMid.setOpCode(userMbrAttrMidInfo.getOpCode());
            mbrAttrMid.setLoginNo(userMbrAttrMidInfo.getLoginNo());
            mbrAttrMid.setOutAccept(userMbrAttrMidInfo.getOutAccept());
            mbrAttrMid.setLoginAccept(userMbrAttrMidInfo.getLoginAccept());
            mbrAttrMid.setOpNote(userMbrAttrMidInfo.getOpNote());
            mbrAttrMid.setSystemNote(userMbrAttrMidInfo.getSystemNote());
            mbrAttrMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrAttrMid.setUpdateCode("1");
            mbrAttrMid.setUpdateDate(1);
            mbrAttrMid.setUpdateLogin("1");
            mbrAttrMid.setUpdateTime(userMbrAttrMidInfo.getOpTime());
            mbrAttrMid.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            returnDto = iMbrAttrMid.modify(mbrAttrMid);

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
     * 删除
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    @Override
    public ReturnDto drop(UserMbrAttrMidInfo userMbrAttrMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrAttrMid mbrAttrMid = new MbrAttrMid();
            mbrAttrMid.setInsValue(userMbrAttrMidInfo.getInsValue());
            mbrAttrMid.setAttrId(userMbrAttrMidInfo.getAttrId());
            mbrAttrMid.setEffDate(userMbrAttrMidInfo.getEffDate());
            mbrAttrMid.setAttrNo(userMbrAttrMidInfo.getAttrNo());
            mbrAttrMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrAttrMid.setUpdateCode("1");
            mbrAttrMid.setUpdateDate(1);
            mbrAttrMid.setUpdateLogin("1");
            mbrAttrMid.setUpdateTime(userMbrAttrMidInfo.getOpTime());
            mbrAttrMid.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            returnDto = iMbrAttrMid.drop(mbrAttrMid);

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
     * 查询
     *
     * @param insType
     * @param insValue
     * @param attrId
     * @param effDate
     * @param attrNo
     * @return
     */
    @Override
    public UserMbrAttrMidInfo query(String insType,BigDecimal insValue, String attrId, Date effDate, String attrNo) {
        UserMbrAttrMidInfo userMbrAttrMidInfo = new UserMbrAttrMidInfo();

        try {
            MbrAttrMid mbrAttrMid = iMbrAttrMid.query(insType,insValue, attrId, effDate, attrNo);

            if (StringUtil.isNotEmptyOrNull(mbrAttrMid)) {
                return new UserMbrAttrMidInfo();
            }

            userMbrAttrMidInfo.setInsType(mbrAttrMid.getInsType());
            userMbrAttrMidInfo.setInsValue(mbrAttrMid.getInsValue());
            userMbrAttrMidInfo.setAttrId(mbrAttrMid.getAttrId());
            userMbrAttrMidInfo.setEffDate(mbrAttrMid.getEffDate());
            userMbrAttrMidInfo.setAttrNo(mbrAttrMid.getAttrNo());
            userMbrAttrMidInfo.setAttrValue(mbrAttrMid.getAttrValue());
            userMbrAttrMidInfo.setGrpNo(mbrAttrMid.getGrpNo());
            userMbrAttrMidInfo.setExpDate(mbrAttrMid.getExpDate());
            userMbrAttrMidInfo.setOpTime(mbrAttrMid.getOpTime());
            userMbrAttrMidInfo.setOpCode(mbrAttrMid.getOpCode());
            userMbrAttrMidInfo.setLoginNo(mbrAttrMid.getLoginNo());
            userMbrAttrMidInfo.setOutAccept(mbrAttrMid.getOutAccept());
            userMbrAttrMidInfo.setLoginAccept(mbrAttrMid.getLoginAccept());
            userMbrAttrMidInfo.setOpNote(mbrAttrMid.getOpNote());
            userMbrAttrMidInfo.setSystemNote(mbrAttrMid.getSystemNote());
        } catch (Exception e) {
            return new UserMbrAttrMidInfo();
        }

        return userMbrAttrMidInfo;
    }

    /**
     * 查询
     *
     * @param map
     * @return
     */
    @Override
    public List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map) {
        List<UserMbrAttrMidInfo> userMbrAttrMidInfoList = new ArrayList<>();

        try {
            List<MbrAttrMid> mbrAttrMidList = iMbrAttrMid.qryMbrAttrMidList(map);

            if (mbrAttrMidList.isEmpty()) {
                return new ArrayList<UserMbrAttrMidInfo>();
            }

            for (MbrAttrMid mbrAttrMid : mbrAttrMidList) {
                UserMbrAttrMidInfo userMbrAttrMidInfo = new UserMbrAttrMidInfo();

                userMbrAttrMidInfo.setInsType(mbrAttrMid.getInsType());
                userMbrAttrMidInfo.setInsValue(mbrAttrMid.getInsValue());
                userMbrAttrMidInfo.setAttrId(mbrAttrMid.getAttrId());
                userMbrAttrMidInfo.setAttrNo(mbrAttrMid.getAttrNo());
                userMbrAttrMidInfo.setAttrValue(mbrAttrMid.getAttrValue());
                userMbrAttrMidInfo.setGrpNo(mbrAttrMid.getGrpNo());
                userMbrAttrMidInfo.setEffDate(mbrAttrMid.getEffDate());
                userMbrAttrMidInfo.setExpDate(mbrAttrMid.getExpDate());
                userMbrAttrMidInfo.setOpTime(mbrAttrMid.getOpTime());
                userMbrAttrMidInfo.setOpCode(mbrAttrMid.getOpCode());
                userMbrAttrMidInfo.setLoginNo(mbrAttrMid.getLoginNo());
                userMbrAttrMidInfo.setOutAccept(mbrAttrMid.getOutAccept());
                userMbrAttrMidInfo.setLoginAccept(mbrAttrMid.getLoginAccept());
                userMbrAttrMidInfo.setOpNote(mbrAttrMid.getOpNote());
                userMbrAttrMidInfo.setSystemNote(mbrAttrMid.getSystemNote());

                userMbrAttrMidInfoList.add(userMbrAttrMidInfo);
            }
        } catch (Exception e) {
            return new ArrayList<UserMbrAttrMidInfo>();
        }

        return userMbrAttrMidInfoList;
    }

    /**
     * 删除成员订购属性实例
     *
     * @param updateOprInfo
     * @param insValue
     * @return ReturnDto
     */
    @Override
    public ReturnDto delByInsValue(UpdateOprInfo updateOprInfo, BigDecimal insValue) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrAttrMid mbrAttrMid = new MbrAttrMid();
            mbrAttrMid.setInsValue(insValue);
            mbrAttrMid.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            mbrAttrMid.setLoginNo(updateOprInfo.getLoginNo());
            mbrAttrMid.setOpCode(updateOprInfo.getOpCode());
            mbrAttrMid.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));
            mbrAttrMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrAttrMid.setUpdateCode("1");
            mbrAttrMid.setUpdateDate(1);
            mbrAttrMid.setUpdateLogin("1");
            mbrAttrMid.setUpdateTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            mbrAttrMid.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            returnDto = iMbrAttrMid.delByInsValue(mbrAttrMid);

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
}
