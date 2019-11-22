package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
import com.sitech.family.custservice.mapper.ConUserRelMapper;
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
 * 帐务付费明细  实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ConUserRelInfoImpl implements IConUserRelInfo {

    @Autowired
    private ConUserRelMapper conUserRelMapper;

    /**
     * 创建帐务付费明细信息
     *
     * @param conUserRel 入参对象
     * @return returnDto
     */
    @Override
    public ReturnDto create(ConUserRel conUserRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            conUserRelMapper.insert(conUserRel);

            conUserRelMapper.create(conUserRel);
        } catch (Exception e) {
            throw new BusiException("创建帐务付费明细信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除帐务付费明细信息
     *
     * @param conUserRel
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(ConUserRel conUserRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long servAcctId = conUserRel.getServAcctId();

            ConUserRel conUserRelQry = conUserRelMapper.query(servAcctId);

            if (StringUtil.isEmptyOrNull(conUserRelQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除帐务付费明细信息失败");
                return returnDto;
            }

            conUserRelQry.setUpdateAccept(conUserRel.getUpdateAccept());
            conUserRelQry.setUpdateType(conUserRel.getUpdateType());
            conUserRelQry.setUpdateTime(conUserRel.getUpdateTime());
            conUserRelQry.setUpdateDate(conUserRel.getUpdateDate());
            conUserRelQry.setUpdateLogin(conUserRel.getUpdateLogin());
            conUserRelQry.setUpdateCode(conUserRel.getUpdateCode());

            conUserRelMapper.insert(conUserRelQry);

            conUserRelMapper.drop(servAcctId);

        } catch (Exception e) {
            throw new BusiException("删除帐务付费明细信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新帐务付费明细信息
     *
     * @param conUserRel
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(ConUserRel conUserRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long servAcctId = conUserRel.getServAcctId();

            ConUserRel conUserRelQry = conUserRelMapper.query(servAcctId);

            if (StringUtil.isEmptyOrNull(conUserRelQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新帐务付费明细信息失败");
                return returnDto;
            }

            conUserRelQry.setUpdateAccept(conUserRel.getUpdateAccept());
            conUserRelQry.setUpdateType(conUserRel.getUpdateType());
            conUserRelQry.setUpdateTime(conUserRel.getUpdateTime());
            conUserRelQry.setUpdateDate(conUserRel.getUpdateDate());
            conUserRelQry.setUpdateLogin(conUserRel.getUpdateLogin());
            conUserRelQry.setUpdateCode(conUserRel.getUpdateCode());

            conUserRelMapper.insert(conUserRelQry);

            conUserRelMapper.modify(conUserRel);

            conUserRel.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            conUserRelMapper.insert(conUserRel);

        } catch (Exception e) {
            throw new BusiException("更新帐务付费明细信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询帐务付费明细信息
     *
     * @param servAcctId
     * @return ConUserRel
     */
    @Override
    public ConUserRel query(Long servAcctId) {
        ConUserRel conUserRel = new ConUserRel();

        try {
            conUserRel = conUserRelMapper.query(servAcctId);
        } catch (Exception e) {
            throw new BusiException("查询帐务付费明细信息失败:" + e.getMessage());
        }

        return conUserRel;

    }

    /**
     * 查询帐务付费明细信息
     *
     * @param map
     * @return List<ConUserRel>
     */
    @Override
    public List<ConUserRel> qryContractRltList(Map map) {
        List<ConUserRel> list = new ArrayList<>();

        try {
            list = conUserRelMapper.qryContractRltList(map);
        } catch (Exception e) {
            throw new BusiException("查询帐务付费明细信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询帐务付费明细历史信息
     *
     * @param map
     * @return List<ConUserRel>
     */
    @Override
    public List<ConUserRel> qryContractRltHisList(Map map) {
        List<ConUserRel> list = new ArrayList<>();

        try {
            list = conUserRelMapper.qryContractRltHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询帐务付费明细历史信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param conUserRel
     * @return
     */
    @Override
    public ReturnDto updateFinishState(ConUserRel conUserRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",conUserRel.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            List<ConUserRel> conUserRelList = qryContractRltList(map);

            if (conUserRelList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            conUserRelMapper.updateFinishState(conUserRel);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
