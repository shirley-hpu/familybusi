package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.ICrmToBossState;
import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
import com.sitech.family.custservice.mapper.CrmToBossStateMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @program: familybusi
 * @description: 用户CRM&BOSS状态同步实体实现
 * @author: yang xing
 * @create: 2018-12-19 17:22
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class CrmToBossStateImpl implements ICrmToBossState {

    @Autowired
    private CrmToBossStateMapper crmToBossStateMapper;

    /**
     * 	新增用户CRM和BOSS状态同步
     * @param crmToBossState
     */
    @Override
    public ReturnDto create(CrmToBossState crmToBossState) {
        ReturnDto returnDto = new ReturnDto();

        try {
            crmToBossStateMapper.create(crmToBossState);

            crmToBossStateMapper.insert(crmToBossState);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "新增用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("新增用户CRM和BOSS状态同步成功");
        return returnDto;
    }

    /**
     * 修改用户CRM和BOSS状态同步
     * @param crmToBossState
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(CrmToBossState crmToBossState) {
        ReturnDto returnDto = new ReturnDto();

        try {
            CrmToBossState crmToBossState1 = crmToBossStateMapper.query(crmToBossState.getIdNo());

            if (StringUtil.isEmptyOrNull(crmToBossState1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新帐务付费明细信息失败");
                return returnDto;
            }

            crmToBossState1.setUpdateAccept(crmToBossState.getUpdateAccept());
            crmToBossState1.setUpdateType(crmToBossState.getUpdateType());
            crmToBossState1.setUpdateTime(crmToBossState.getUpdateTime());
            crmToBossState1.setUpdateDate(crmToBossState.getUpdateDate());
            crmToBossState1.setUpdateLogin(crmToBossState.getUpdateLogin());
            crmToBossState1.setUpdateCode(crmToBossState.getUpdateCode());

            crmToBossStateMapper.insert(crmToBossState1);

            crmToBossStateMapper.modify(crmToBossState);

            crmToBossState.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            crmToBossStateMapper.insert(crmToBossState);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户CRM和BOSS状态同步成功");
        return returnDto;
    }

    /**
     * 删除用户CRM和BOSS状态同步
     * @param crmToBossState
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(CrmToBossState crmToBossState) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = crmToBossState.getIdNo();
            CrmToBossState crmToBossState1 = crmToBossStateMapper.query(idNo);

            if (StringUtil.isEmptyOrNull(crmToBossState1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除帐务付费明细信息失败");
                return returnDto;
            }

            crmToBossState1.setUpdateAccept(crmToBossState.getUpdateAccept());
            crmToBossState1.setUpdateType(crmToBossState.getUpdateType());
            crmToBossState1.setUpdateTime(crmToBossState.getUpdateTime());
            crmToBossState1.setUpdateDate(crmToBossState.getUpdateDate());
            crmToBossState1.setUpdateLogin(crmToBossState.getUpdateLogin());
            crmToBossState1.setUpdateCode(crmToBossState.getUpdateCode());

            crmToBossStateMapper.insert(crmToBossState1);
            crmToBossStateMapper.drop(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询用户CRM和BOSS状态同步
     * @param idNo
     * @return CrmToBossState
     */
    @Override
    public CrmToBossState query(Long idNo) {
        CrmToBossState crmToBossState = new CrmToBossState();

        try {
            crmToBossState = crmToBossStateMapper.query(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        return crmToBossState;
    }

    /**
     * 查询用户CRM和BOSS状态同步
     *
     * @param map
     * @return List<CrmToBossState>
     */
    @Override
    public List<CrmToBossState> qryCrmToBossStateList(Map map) {
        List<CrmToBossState> list = new ArrayList<>();

        try {
            list = crmToBossStateMapper.qryCrmToBossStateList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户CRM和BOSS状态同步
     *
     * @param map
     * @return List<CrmToBossState>
     */
    @Override
    public List<CrmToBossState> qryCrmToBossStateHisList(Map map) {
        List<CrmToBossState> list = new ArrayList<>();

        try {
            list = crmToBossStateMapper.qryCrmToBossStateHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户状态CRMTOBOSS同步信息失败" + e.getMessage());
        }

        return list;
    }
}
