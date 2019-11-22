package com.sitech.family.familyservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.common.util.DateConst;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.familyservice.daoimpl.user.IMbrPrcMid;
import com.sitech.family.dao.usergroup.IUserMbrPrcMidInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
import com.sitech.family.familyservice.dto.mapperdto.MbrPrcMid;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 22:00
 */
@Component
public class UserMbrPrcMidInfoDaoImpl implements IUserMbrPrcMidInfoDao {

    @Autowired
    private IMbrPrcMid iMbrPrcMid;

    /**
     * 新增
     *
     * @param userMbrPrcMidInfo
     * @return
     */
    @Override
    public ReturnDto create(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrPrcMid mbrPrcMid = new MbrPrcMid();
            mbrPrcMid.setIdNo(userMbrPrcMidInfo.getIdNo());
            mbrPrcMid.setMemberId(userMbrPrcMidInfo.getMemberId());
            mbrPrcMid.setInsType(userMbrPrcMidInfo.getInsType());
            mbrPrcMid.setInsValue(userMbrPrcMidInfo.getInsValue());
            mbrPrcMid.setParinsId(userMbrPrcMidInfo.getParinsId());
            mbrPrcMid.setOtherinsId(userMbrPrcMidInfo.getOtherinsId());
            mbrPrcMid.setRelopType(userMbrPrcMidInfo.getRelopType());
            mbrPrcMid.setRelationType(userMbrPrcMidInfo.getRelationType());
            mbrPrcMid.setRelinsId(userMbrPrcMidInfo.getRelinsId());
            mbrPrcMid.setMainFlag(userMbrPrcMidInfo.getMainFlag());
            if ("1".equals(userMbrPrcMidInfo.getInsType())) {
                mbrPrcMid.setGoodsId(userMbrPrcMidInfo.getGoodsId());
            } else if ("2".equals(userMbrPrcMidInfo.getInsType())) {
                mbrPrcMid.setPrcId(userMbrPrcMidInfo.getPrcId());
            } else {
                mbrPrcMid.setSvcId(userMbrPrcMidInfo.getSvcId());
            }
            mbrPrcMid.setProdId(userMbrPrcMidInfo.getProdId());
            mbrPrcMid.setEffDate(userMbrPrcMidInfo.getEffDate());
            mbrPrcMid.setExpDate(userMbrPrcMidInfo.getExpDate());
            mbrPrcMid.setOrderDate(userMbrPrcMidInfo.getOrderDate());
            mbrPrcMid.setOpTime(userMbrPrcMidInfo.getOpTime());
            mbrPrcMid.setOpCode(userMbrPrcMidInfo.getOpCode());
            mbrPrcMid.setLoginNo(userMbrPrcMidInfo.getLoginNo());
            mbrPrcMid.setOutAccept(userMbrPrcMidInfo.getOutAccept());
            mbrPrcMid.setLoginAccept(userMbrPrcMidInfo.getLoginAccept());
            mbrPrcMid.setOpNote(userMbrPrcMidInfo.getOpNote());
            mbrPrcMid.setSystemNote(userMbrPrcMidInfo.getSystemNote());
            mbrPrcMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrPrcMid.setUpdateCode("1");
            mbrPrcMid.setUpdateDate(1);
            mbrPrcMid.setUpdateLogin("1");
            mbrPrcMid.setUpdateTime(userMbrPrcMidInfo.getOpTime());
            mbrPrcMid.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = iMbrPrcMid.create(mbrPrcMid);

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
     * @param userMbrPrcMidInfo
     * @return
     */
    @Override
    public ReturnDto modify(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrPrcMid mbrPrcMid = new MbrPrcMid();
            mbrPrcMid.setMemberId(userMbrPrcMidInfo.getMemberId());
            mbrPrcMid.setInsType(userMbrPrcMidInfo.getInsType());
            mbrPrcMid.setInsValue(userMbrPrcMidInfo.getInsValue());
            mbrPrcMid.setParinsId(userMbrPrcMidInfo.getParinsId());
            mbrPrcMid.setOtherinsId(userMbrPrcMidInfo.getOtherinsId());
            mbrPrcMid.setRelopType(userMbrPrcMidInfo.getRelopType());
            mbrPrcMid.setRelationType(userMbrPrcMidInfo.getRelationType());
            mbrPrcMid.setRelinsId(userMbrPrcMidInfo.getRelinsId());
            mbrPrcMid.setMainFlag(userMbrPrcMidInfo.getMainFlag());
            mbrPrcMid.setGoodsId(userMbrPrcMidInfo.getGoodsId());
            mbrPrcMid.setPrcId(userMbrPrcMidInfo.getPrcId());
            mbrPrcMid.setSvcId(userMbrPrcMidInfo.getSvcId());
            mbrPrcMid.setProdId(userMbrPrcMidInfo.getProdId());
            mbrPrcMid.setEffDate(userMbrPrcMidInfo.getEffDate());
            mbrPrcMid.setExpDate(userMbrPrcMidInfo.getExpDate());
            mbrPrcMid.setOrderDate(userMbrPrcMidInfo.getOrderDate());
            mbrPrcMid.setOpTime(userMbrPrcMidInfo.getOpTime());
            mbrPrcMid.setOpCode(userMbrPrcMidInfo.getOpCode());
            mbrPrcMid.setLoginNo(userMbrPrcMidInfo.getLoginNo());
            mbrPrcMid.setOutAccept(userMbrPrcMidInfo.getOutAccept());
            mbrPrcMid.setLoginAccept(userMbrPrcMidInfo.getLoginAccept());
            mbrPrcMid.setOpNote(userMbrPrcMidInfo.getOpNote());
            mbrPrcMid.setSystemNote(userMbrPrcMidInfo.getSystemNote());
            mbrPrcMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrPrcMid.setUpdateCode("1");
            mbrPrcMid.setUpdateDate(1);
            mbrPrcMid.setUpdateLogin("1");
            mbrPrcMid.setUpdateTime(userMbrPrcMidInfo.getOpTime());
            mbrPrcMid.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            returnDto = iMbrPrcMid.modify(mbrPrcMid);

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
     * @param userMbrPrcMidInfo
     * @return
     */
    @Override
    public ReturnDto drop(UserMbrPrcMidInfo userMbrPrcMidInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrPrcMid mbrPrcMid = new MbrPrcMid();
            mbrPrcMid.setInsValue(userMbrPrcMidInfo.getInsValue());
            mbrPrcMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrPrcMid.setUpdateCode("1");
            mbrPrcMid.setUpdateDate(1);
            mbrPrcMid.setUpdateLogin("1");
            mbrPrcMid.setUpdateTime(userMbrPrcMidInfo.getOpTime());
            mbrPrcMid.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            returnDto = iMbrPrcMid.drop(mbrPrcMid);

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
     * @param insValue
     * @return
     */
    @Override
    public UserMbrPrcMidInfo query(String insType, BigDecimal insValue) {
        UserMbrPrcMidInfo userMbrPrcMidInfo = new UserMbrPrcMidInfo();

        try {
            MbrPrcMid mbrPrcMid = iMbrPrcMid.query(insType, insValue);

            if (StringUtil.isNotEmptyOrNull(mbrPrcMid)) {
                return new UserMbrPrcMidInfo();
            }

            userMbrPrcMidInfo.setMemberId(mbrPrcMid.getMemberId());
            userMbrPrcMidInfo.setInsType(mbrPrcMid.getInsType());
            userMbrPrcMidInfo.setInsValue(mbrPrcMid.getInsValue());
            userMbrPrcMidInfo.setParinsId(mbrPrcMid.getParinsId());
            userMbrPrcMidInfo.setOtherinsId(mbrPrcMid.getOtherinsId());
            userMbrPrcMidInfo.setRelopType(mbrPrcMid.getRelopType());
            userMbrPrcMidInfo.setRelationType(mbrPrcMid.getRelationType());
            userMbrPrcMidInfo.setRelinsId(mbrPrcMid.getRelinsId());
            userMbrPrcMidInfo.setMainFlag(mbrPrcMid.getMainFlag());
            userMbrPrcMidInfo.setGoodsId(mbrPrcMid.getGoodsId());
            userMbrPrcMidInfo.setPrcId(mbrPrcMid.getPrcId());
            userMbrPrcMidInfo.setSvcId(mbrPrcMid.getSvcId());
            userMbrPrcMidInfo.setProdId(mbrPrcMid.getProdId());
            userMbrPrcMidInfo.setEffDate(mbrPrcMid.getEffDate());
            userMbrPrcMidInfo.setExpDate(mbrPrcMid.getExpDate());
            userMbrPrcMidInfo.setOrderDate(mbrPrcMid.getOrderDate());
            userMbrPrcMidInfo.setOpTime(mbrPrcMid.getOpTime());
            userMbrPrcMidInfo.setOpCode(mbrPrcMid.getOpCode());
            userMbrPrcMidInfo.setLoginNo(mbrPrcMid.getLoginNo());
            userMbrPrcMidInfo.setOutAccept(mbrPrcMid.getOutAccept());
            userMbrPrcMidInfo.setLoginAccept(mbrPrcMid.getLoginAccept());
            userMbrPrcMidInfo.setOpNote(mbrPrcMid.getOpNote());
            userMbrPrcMidInfo.setSystemNote(mbrPrcMid.getSystemNote());
        } catch (Exception e) {
            return new UserMbrPrcMidInfo();
        }

        return userMbrPrcMidInfo;
    }

    /**
     * @param map
     * @return
     */
    @Override
    public List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map) {
        List<UserMbrPrcMidInfo> userMbrPrcMidInfoList = new ArrayList<>();

        try {
            List<MbrPrcMid> mbrPrcMidList = iMbrPrcMid.qryMbrPrcMidHisList(map);

            if (mbrPrcMidList.isEmpty()) {
                return new ArrayList<UserMbrPrcMidInfo>();
            }

            for (MbrPrcMid mbrPrcMid : mbrPrcMidList) {
                UserMbrPrcMidInfo userMbrPrcMidInfo = new UserMbrPrcMidInfo();

                userMbrPrcMidInfo.setMemberId(mbrPrcMid.getMemberId());
                userMbrPrcMidInfo.setInsType(mbrPrcMid.getInsType());
                userMbrPrcMidInfo.setInsValue(mbrPrcMid.getInsValue());
                userMbrPrcMidInfo.setParinsId(mbrPrcMid.getParinsId());
                userMbrPrcMidInfo.setOtherinsId(mbrPrcMid.getOtherinsId());
                userMbrPrcMidInfo.setRelopType(mbrPrcMid.getRelopType());
                userMbrPrcMidInfo.setRelationType(mbrPrcMid.getRelationType());
                userMbrPrcMidInfo.setRelinsId(mbrPrcMid.getRelinsId());
                userMbrPrcMidInfo.setMainFlag(mbrPrcMid.getMainFlag());
                userMbrPrcMidInfo.setGoodsId(mbrPrcMid.getGoodsId());
                userMbrPrcMidInfo.setPrcId(mbrPrcMid.getPrcId());
                userMbrPrcMidInfo.setSvcId(mbrPrcMid.getSvcId());
                userMbrPrcMidInfo.setProdId(mbrPrcMid.getProdId());
                userMbrPrcMidInfo.setExpDate(mbrPrcMid.getExpDate());
                userMbrPrcMidInfo.setEffDate(mbrPrcMid.getEffDate());
                userMbrPrcMidInfo.setOrderDate(mbrPrcMid.getOrderDate());
                userMbrPrcMidInfo.setOpTime(mbrPrcMid.getOpTime());
                userMbrPrcMidInfo.setOpCode(mbrPrcMid.getOpCode());
                userMbrPrcMidInfo.setLoginNo(mbrPrcMid.getLoginNo());
                userMbrPrcMidInfo.setOutAccept(mbrPrcMid.getOutAccept());
                userMbrPrcMidInfo.setLoginAccept(mbrPrcMid.getLoginAccept());
                userMbrPrcMidInfo.setOpNote(mbrPrcMid.getOpNote());
                userMbrPrcMidInfo.setSystemNote(mbrPrcMid.getSystemNote());

                userMbrPrcMidInfoList.add(userMbrPrcMidInfo);
            }
        } catch (Exception e) {
            return new ArrayList<UserMbrPrcMidInfo>();
        }

        return userMbrPrcMidInfoList;
    }

    /**
     * 根据idNo删除中间表数据
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto delByIdNo(UpdateOprInfo updateOprInfo, Long idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            MbrPrcMid mbrPrcMid = new MbrPrcMid();
            mbrPrcMid.setIdNo(idNo);
            mbrPrcMid.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            mbrPrcMid.setLoginNo(updateOprInfo.getLoginNo());
            mbrPrcMid.setOpCode(updateOprInfo.getOpCode());
            mbrPrcMid.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));
            mbrPrcMid.setUpdateAccept(Long.valueOf(new Random().nextInt()));
            mbrPrcMid.setUpdateCode("1");
            mbrPrcMid.setUpdateDate(1);
            mbrPrcMid.setUpdateLogin("1");
            mbrPrcMid.setUpdateTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            mbrPrcMid.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            returnDto = iMbrPrcMid.delByIdNo(mbrPrcMid);

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
