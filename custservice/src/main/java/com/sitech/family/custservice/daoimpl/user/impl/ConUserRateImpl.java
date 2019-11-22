package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IConUserRate;
import com.sitech.family.custservice.dto.mapperdto.ConUserRate;
import com.sitech.family.custservice.mapper.IConUserRateMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 帐务付费明细
 * @date 2018/12/10 09:52
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ConUserRateImpl implements IConUserRate {

    @Autowired
    private IConUserRateMapper mapper;

    /**
     * 创建账户关系信息
     *
     * @param conUserRate
     * @return returnDto
     */
    @Override
    public ReturnDto create(ConUserRate conUserRate) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(conUserRate);

            mapper.insert(conUserRate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "增加账户信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建账户关系信息成功");
        return returnDto;
    }

    /**
     * 更新账户关系信息
     *
     * @param conUserRate
     * @return returnDto
     */
    @Override
    public ReturnDto modify(ConUserRate conUserRate) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long servAcctId = conUserRate.getServAcctId();
            Date effDate = conUserRate.getEffDate();
            String feeCode = conUserRate.getFeeCode();
            String detalCode = conUserRate.getDetalCode();

            ConUserRate conUserRate1 = mapper.query(servAcctId, effDate, feeCode, detalCode);

            if (StringUtil.isEmptyOrNull(conUserRate1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新账户关系信息失败");
                return returnDto;
            }

            conUserRate1.setUpdateAccept(conUserRate.getUpdateAccept());
            conUserRate1.setUpdateType(conUserRate.getUpdateType());
            conUserRate1.setUpdateTime(conUserRate.getUpdateTime());
            conUserRate1.setUpdateDate(conUserRate.getUpdateDate());
            conUserRate1.setUpdateLogin(conUserRate.getUpdateLogin());
            conUserRate1.setUpdateCode(conUserRate.getUpdateCode());

            mapper.insert(conUserRate1);

            mapper.modify(conUserRate);

            conUserRate.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(conUserRate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改账户信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改账户关系信息成功");
        return returnDto;
    }

    /**
     * 删除账户关系信息
     *
     * @param conUserRate
     * @return null
     */
    @Override
    public ReturnDto drop(ConUserRate conUserRate) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long servAcctId = conUserRate.getServAcctId();
            Date effDate = conUserRate.getEffDate();
            String feeCode = conUserRate.getFeeCode();
            String detalCode = conUserRate.getDetalCode();

            ConUserRate conUserRate1 = mapper.query(servAcctId, effDate, feeCode, detalCode);

            if (StringUtil.isEmptyOrNull(conUserRate1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除账户关系信息失败");
                return returnDto;
            }

            conUserRate1.setUpdateAccept(conUserRate.getUpdateAccept());
            conUserRate1.setUpdateType(conUserRate.getUpdateType());
            conUserRate1.setUpdateTime(conUserRate.getUpdateTime());
            conUserRate1.setUpdateDate(conUserRate.getUpdateDate());
            conUserRate1.setUpdateLogin(conUserRate.getUpdateLogin());
            conUserRate1.setUpdateCode(conUserRate.getUpdateCode());

            mapper.insert(conUserRate1);

            mapper.drop(conUserRate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除账户关系信息成功");
        return returnDto;

    }

    /**
     * 查询账户关系信息
     *
     * @param servAcctId,effDate,feeCode,detalCode
     * @return conUserRate
     */
    @Override
    public ConUserRate query(Long servAcctId, Date effDate, String feeCode, String detalCode) {
        ConUserRate conUserRate = new ConUserRate();

        try {
            conUserRate = mapper.query(servAcctId, effDate, feeCode, detalCode);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询账户关系信息失败" + e.getMessage());
        }

        return conUserRate;
    }

    /**
     * 查询账户信息
     *
     * @param map
     * @return List<ConUserRate>
     */
    @Override
    public List<ConUserRate> qryConUserRateList(Map map) {
        List<ConUserRate> list = new ArrayList<ConUserRate>();

        try {
            list = mapper.qryConUserRateList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询账户信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史账户信息
     *
     * @param map
     * @return List<ConUserRate>
     */
    @Override
    public List<ConUserRate> qryConUserRateHisList(Map map) {
        List<ConUserRate> list = new ArrayList<ConUserRate>();

        try {
            list = mapper.qryConUserRateHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询账户信息失败" + e.getMessage());
        }

        return list;
    }
}
