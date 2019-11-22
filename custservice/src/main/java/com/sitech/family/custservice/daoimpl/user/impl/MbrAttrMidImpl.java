package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IMbrAttrMid;
import com.sitech.family.custservice.dto.mapperdto.MbrAttrMid;
import com.sitech.family.custservice.mapper.IMbrAttrMidMapper;
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
 * @date 2019/4/17 16:52
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MbrAttrMidImpl implements IMbrAttrMid {

    @Autowired
    private IMbrAttrMidMapper mapper;

    /**
     * 创建成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(MbrAttrMid mbrAttrMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(mbrAttrMid);

            mapper.insert(mbrAttrMid);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "创建成员订购属性实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建成员订购属性实例成功");
        return returnDto;
    }

    /**
     * 更新成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(MbrAttrMid mbrAttrMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal insValue = mbrAttrMid.getInsValue();
            String insType = mbrAttrMid.getInsType();
            String attrId = mbrAttrMid.getAttrId();
            Date effDate = mbrAttrMid.getEffDate();
            String attrNo = mbrAttrMid.getAttrNo();

            MbrAttrMid mbrAttrMid1 = mapper.query(insType, insValue, attrId, effDate, attrNo);

            if (StringUtil.isEmptyOrNull(mbrAttrMid1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新成员订购属性实例失败");
                return returnDto;
            }

            mbrAttrMid1.setUpdateAccept(mbrAttrMid.getUpdateAccept());
            mbrAttrMid1.setUpdateType(mbrAttrMid.getUpdateType());
            mbrAttrMid1.setUpdateTime(mbrAttrMid.getUpdateTime());
            mbrAttrMid1.setUpdateDate(mbrAttrMid.getUpdateDate());
            mbrAttrMid1.setUpdateLogin(mbrAttrMid.getUpdateLogin());
            mbrAttrMid1.setUpdateCode(mbrAttrMid.getUpdateCode());

            mapper.insert(mbrAttrMid1);

            mapper.modify(mbrAttrMid);

            mbrAttrMid.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(mbrAttrMid);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新成员订购属性实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("更新成员订购属性实例成功");
        return returnDto;
    }

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(MbrAttrMid mbrAttrMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal insValue = mbrAttrMid.getInsValue();
            String insType = mbrAttrMid.getInsType();
            String attrId = mbrAttrMid.getAttrId();
            Date effDate = mbrAttrMid.getEffDate();
            String attrNo = mbrAttrMid.getAttrNo();

            MbrAttrMid mbrAttrMid1 = mapper.query(insType, insValue, attrId, effDate, attrNo);

            if (StringUtil.isEmptyOrNull(mbrAttrMid1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除成员订购属性实例失败");
                return returnDto;
            }

            mbrAttrMid1.setUpdateAccept(mbrAttrMid.getUpdateAccept());
            mbrAttrMid1.setUpdateType(mbrAttrMid.getUpdateType());
            mbrAttrMid1.setUpdateTime(mbrAttrMid.getUpdateTime());
            mbrAttrMid1.setUpdateDate(mbrAttrMid.getUpdateDate());
            mbrAttrMid1.setUpdateLogin(mbrAttrMid.getUpdateLogin());
            mbrAttrMid1.setUpdateCode(mbrAttrMid.getUpdateCode());

            mapper.insert(mbrAttrMid1);

            mapper.drop(mbrAttrMid);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除成员订购属性实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除成员订购属性实例成功");
        return returnDto;
    }

    /**
     * 查询成员订购属性实例
     *
     * @param insType
     * @param insValue
     * @param attrId
     * @param effDate
     * @param attrNo
     * @return MbrPrcMid
     */
    @Override
    public MbrAttrMid query(String insType, BigDecimal insValue, String attrId, Date effDate, String attrNo) {
        MbrAttrMid mbrAttrMid = new MbrAttrMid();

        try {
            mbrAttrMid = mapper.query(insType, insValue, attrId, effDate, attrNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询成员订购属性实例失败" + e.getMessage());
        }

        return mbrAttrMid;
    }

    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    @Override
    public List<MbrAttrMid> qryMbrAttrMidList(Map map) {
        List<MbrAttrMid> list = new ArrayList<MbrAttrMid>();

        try {
            list = mapper.qryMbrAttrMidList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询成员订购属性实例失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史表成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    @Override
    public List<MbrAttrMid> qryMbrAttrMidHisList(Map map) {
        List<MbrAttrMid> list = new ArrayList<MbrAttrMid>();

        try {
            list = mapper.qryMbrAttrMidHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询历史表成员订购属性实例失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    @Override
    public ReturnDto delByInsValue(MbrAttrMid mbrAttrMid) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String, Object> map = new HashMap<>();
            map.put("insValue", mbrAttrMid.getInsValue());

            List<MbrAttrMid> list = mapper.qryMbrAttrMidList(map);

            if (list.isEmpty()) {
                return returnDto;
            }

            for (MbrAttrMid mbrAttrMidOne : list) {
                mbrAttrMidOne.setUpdateAccept(mbrAttrMid.getUpdateAccept());
                mbrAttrMidOne.setUpdateType(mbrAttrMid.getUpdateType());
                mbrAttrMidOne.setUpdateTime(mbrAttrMid.getUpdateTime());
                mbrAttrMidOne.setUpdateDate(mbrAttrMid.getUpdateDate());
                mbrAttrMidOne.setUpdateLogin(mbrAttrMid.getUpdateLogin());
                mbrAttrMidOne.setUpdateCode(mbrAttrMid.getUpdateCode());

                mapper.insert(mbrAttrMidOne);
            }

            mapper.delByInsValue(mbrAttrMid);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除成员订购属性实例失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除成员订购属性实例成功");
        return returnDto;
    }
}
