package com.sitech.family.familyservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.familyservice.daoimpl.user.IMbrPrcMid;
import com.sitech.family.familyservice.dto.mapperdto.MbrPrcMid;
import com.sitech.family.familyservice.mapper.IMbrPrcMidMapper;
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

/**
 * @author wusm
 * @description
 * @date 2019/4/17 16:51
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MbrPrcMidImpl implements IMbrPrcMid {

    @Autowired
    private IMbrPrcMidMapper mapper;

    /**
     * 创建成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(MbrPrcMid mbrPrcMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(mbrPrcMid);

            mapper.insert(mbrPrcMid);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建成员订购实例成功");
        return returnDto;
    }

    /**
     * 更新成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(MbrPrcMid mbrPrcMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal insValue = mbrPrcMid.getInsValue();
            String insType = mbrPrcMid.getInsType();

            MbrPrcMid mbrPrcMid1 = mapper.query(insType, insValue);

            if (StringUtil.isEmptyOrNull(mbrPrcMid1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新成员订购实例失败");
                return returnDto;
            }

            mbrPrcMid1.setUpdateAccept(mbrPrcMid.getUpdateAccept());
            mbrPrcMid1.setUpdateType(mbrPrcMid.getUpdateType());
            mbrPrcMid1.setUpdateTime(mbrPrcMid.getUpdateTime());
            mbrPrcMid1.setUpdateDate(mbrPrcMid.getUpdateDate());
            mbrPrcMid1.setUpdateLogin(mbrPrcMid.getUpdateLogin());
            mbrPrcMid1.setUpdateCode(mbrPrcMid.getUpdateCode());

            mapper.insert(mbrPrcMid1);

            mapper.modify(mbrPrcMid);

            mbrPrcMid.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(mbrPrcMid);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("更新成员订购实例成功");
        return returnDto;
    }

    /**
     * 删除成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(MbrPrcMid mbrPrcMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal insValue = mbrPrcMid.getInsValue();
            String insType = mbrPrcMid.getInsType();

            MbrPrcMid mbrPrcMid1 = mapper.query(insType, insValue);

            if (StringUtil.isEmptyOrNull(mbrPrcMid1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除成员订购实例失败");
                return returnDto;
            }

            mbrPrcMid1.setUpdateAccept(mbrPrcMid.getUpdateAccept());
            mbrPrcMid1.setUpdateType(mbrPrcMid.getUpdateType());
            mbrPrcMid1.setUpdateTime(mbrPrcMid.getUpdateTime());
            mbrPrcMid1.setUpdateDate(mbrPrcMid.getUpdateDate());
            mbrPrcMid1.setUpdateLogin(mbrPrcMid.getUpdateLogin());
            mbrPrcMid1.setUpdateCode(mbrPrcMid.getUpdateCode());

            mapper.insert(mbrPrcMid1);

            mapper.drop(mbrPrcMid);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除成员订购实例成功");
        return returnDto;
    }

    /**
     * 查询成员订购实例
     *
     * @param insValue
     * @return MbrPrcMid
     */
    @Override
    public MbrPrcMid query(String insType, BigDecimal insValue) {
        MbrPrcMid mbrPrcMid = new MbrPrcMid();

        try {
            mbrPrcMid = mapper.query(insType, insValue);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        return mbrPrcMid;
    }

    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    @Override
    public List<MbrPrcMid> qryMbrPrcMidList(Map map) {
        List<MbrPrcMid> list = new ArrayList<MbrPrcMid>();

        try {
            list = mapper.qryMbrPrcMidList(map);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史表成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    @Override
    public List<MbrPrcMid> qryMbrPrcMidHisList(Map map) {
        List<MbrPrcMid> list = new ArrayList<MbrPrcMid>();

        try {
            list = mapper.qryMbrPrcMidHisList(map);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo删除中间表数据
     *
     * @param mbrPrcMid
     * @return
     */
    @Override
    public ReturnDto delByIdNo(MbrPrcMid mbrPrcMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String, Object> map = new HashMap<>();
            map.put("idNo", mbrPrcMid.getIdNo());

            List<MbrPrcMid> mbrPrcMidList = mapper.qryMbrPrcMidList(map);

            if (StringUtil.isEmptyOrNull(mbrPrcMidList)) {
                return returnDto;
            }

            for (MbrPrcMid mbrPrcMidOne : mbrPrcMidList) {
                mbrPrcMidOne.setUpdateAccept(mbrPrcMid.getUpdateAccept());
                mbrPrcMidOne.setUpdateType(mbrPrcMid.getUpdateType());
                mbrPrcMidOne.setUpdateDate(mbrPrcMid.getUpdateDate());
                mbrPrcMidOne.setUpdateTime(mbrPrcMid.getUpdateTime());
                mbrPrcMidOne.setUpdateLogin(mbrPrcMid.getUpdateLogin());
                mbrPrcMidOne.setUpdateCode(mbrPrcMid.getUpdateCode());

                mapper.insert(mbrPrcMidOne);
            }

            mapper.delByIdNo(mbrPrcMid);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除成员订购实例成功");
        return returnDto;
    }
}
