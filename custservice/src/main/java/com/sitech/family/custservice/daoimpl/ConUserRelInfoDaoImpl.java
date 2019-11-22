package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
import com.sitech.family.dao.account.IConUserRelInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.account.ConUserRelInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 逻辑模型实现层
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Component
public class ConUserRelInfoDaoImpl implements IConUserRelInfoDao {

    /**
     * 调用物理原子实体方法Mapper中ConUserRelInfo方法
     */
    @Autowired
    private IConUserRelInfo conUserRelInfo;

    @Override
    public ReturnDto create(ConUserRelInfo conUserRelInfoDto) {

        if (StringUtil.isEmptyOrNull(conUserRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            ConUserRel conUserRel = new ConUserRel();
            conUserRel.setServAcctId(conUserRelInfoDto.getServAcctId());
            conUserRel.setContractNo(conUserRelInfoDto.getContractNo());
            conUserRel.setIdNo(conUserRelInfoDto.getIdNo());
            conUserRel.setPayType(conUserRelInfoDto.getPayType());
            conUserRel.setPayValue(conUserRelInfoDto.getPayValue());
            conUserRel.setCycleType(conUserRelInfoDto.getCycleType());
            conUserRel.setDateCycle(conUserRelInfoDto.getDateCycle());
            conUserRel.setRateFlag(conUserRelInfoDto.getRateFlag());
            conUserRel.setBillOrder(conUserRelInfoDto.getBillOrder());
            conUserRel.setChkoutPri(conUserRelInfoDto.getPayOrder());
            conUserRel.setEffDate(conUserRelInfoDto.getEffDate());
            conUserRel.setExpDate(conUserRelInfoDto.getExpDate());
            conUserRel.setOpTime(conUserRelInfoDto.getOpTime());
            conUserRel.setOpCode(conUserRelInfoDto.getOpCode());
            conUserRel.setLoginNo(conUserRelInfoDto.getLoginNo());
            conUserRel.setLoginAccept(conUserRelInfoDto.getLoginAccept());
            conUserRel.setFinishFlag(conUserRelInfoDto.getFinishFlag());
            conUserRel.setUpdateAccept(new Random().nextLong());
            conUserRel.setUpdateCode("1");
            conUserRel.setUpdateDate(1);
            conUserRel.setUpdateLogin("1");
            conUserRel.setUpdateTime(conUserRelInfoDto.getOpTime());
            conUserRel.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            conUserRelInfo.create(conUserRel);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(ConUserRelInfo conUserRelInfoDto) {
        if (StringUtil.isEmptyOrNull(conUserRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            ConUserRel conUserRel = new ConUserRel();
            conUserRel.setServAcctId(conUserRelInfoDto.getServAcctId());
            conUserRel.setContractNo(conUserRelInfoDto.getContractNo());
            conUserRel.setIdNo(conUserRelInfoDto.getIdNo());
            conUserRel.setPayType(conUserRelInfoDto.getPayType());
            conUserRel.setPayValue(conUserRelInfoDto.getPayValue());
            conUserRel.setCycleType(conUserRelInfoDto.getCycleType());
            conUserRel.setDateCycle(conUserRelInfoDto.getDateCycle());
            conUserRel.setRateFlag(conUserRelInfoDto.getRateFlag());
            conUserRel.setBillOrder(conUserRelInfoDto.getBillOrder());
            conUserRel.setChkoutPri(conUserRelInfoDto.getPayOrder());
            conUserRel.setEffDate(conUserRelInfoDto.getEffDate());
            conUserRel.setExpDate(conUserRelInfoDto.getExpDate());
            conUserRel.setOpTime(conUserRelInfoDto.getOpTime());
            conUserRel.setOpCode(conUserRelInfoDto.getOpCode());
            conUserRel.setLoginNo(conUserRelInfoDto.getLoginNo());
            conUserRel.setLoginAccept(conUserRelInfoDto.getLoginAccept());
            conUserRel.setFinishFlag(conUserRelInfoDto.getFinishFlag());
            conUserRel.setUpdateAccept(new Random().nextLong());
            conUserRel.setUpdateCode("1");
            conUserRel.setUpdateDate(1);
            conUserRel.setUpdateLogin("1");
            conUserRel.setUpdateTime(conUserRelInfoDto.getOpTime());
            conUserRel.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            conUserRelInfo.modify(conUserRel);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(ConUserRelInfo conUserRelInfoDto) {
        if (StringUtil.isEmptyOrNull(conUserRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            ConUserRel conUserRel = new ConUserRel();
            conUserRel.setServAcctId(conUserRelInfoDto.getServAcctId());
            conUserRel.setUpdateAccept(new Random().nextLong());
            conUserRel.setUpdateCode("1");
            conUserRel.setUpdateDate(1);
            conUserRel.setUpdateLogin("1");
            conUserRel.setUpdateTime(conUserRelInfoDto.getOpTime());
            conUserRel.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            conUserRelInfo.drop(conUserRel);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ConUserRelInfo query(Long servAcctId) {
        if (StringUtil.isEmptyOrNull(servAcctId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            ConUserRel conUserRel = conUserRelInfo.query(servAcctId);

            if (StringUtil.isEmptyOrNull(conUserRel)) {
                return new ConUserRelInfo();
            }

            ConUserRelInfo conUserRelInfo = new ConUserRelInfo();
            conUserRelInfo.setBillOrder(conUserRel.getBillOrder());
            conUserRelInfo.setContractNo(conUserRel.getContractNo());
            conUserRelInfo.setCycleType(conUserRel.getCycleType());
            conUserRelInfo.setDateCycle(conUserRel.getDateCycle());
            conUserRelInfo.setEffDate(conUserRel.getEffDate());
            conUserRelInfo.setExpDate(conUserRel.getExpDate());
            conUserRelInfo.setIdNo(conUserRel.getIdNo());
            conUserRelInfo.setLoginAccept(conUserRel.getLoginAccept());
            conUserRelInfo.setLoginNo(conUserRel.getLoginNo());
            conUserRelInfo.setOpCode(conUserRel.getOpCode());
            conUserRelInfo.setOpTime(conUserRel.getOpTime());
            conUserRelInfo.setPayType(conUserRel.getPayType());
            conUserRelInfo.setPayValue(conUserRel.getPayValue());
            conUserRelInfo.setRateFlag(conUserRel.getRateFlag());
            conUserRelInfo.setServAcctId(conUserRel.getServAcctId());
            conUserRelInfo.setOpNote("1");
            conUserRelInfo.setOutAccept("1");
            conUserRelInfo.setPayOrder(1);
            conUserRelInfo.setSystemNote("1");

            return conUserRelInfo;
        } catch (Exception e) {
            return new ConUserRelInfo();
        }

    }

    @Override
    public List<ConUserRelInfo> qryConUserRelInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "参数对象不存在或为空");
        }

        try {
            //
            List<ConUserRel> conUserRelList = conUserRelInfo.qryContractRltList(map);

            List<ConUserRelInfo> list = new ArrayList<>();
            if (!StringUtil.isEmptyOrNull(conUserRelList)) {
                for (ConUserRel temp : conUserRelList) {
                    ConUserRelInfo conUserRelInfo = new ConUserRelInfo();
                    conUserRelInfo.setBillOrder(temp.getBillOrder());
                    conUserRelInfo.setContractNo(temp.getContractNo());
                    conUserRelInfo.setCycleType(temp.getCycleType());
                    conUserRelInfo.setDateCycle(temp.getDateCycle());
                    conUserRelInfo.setEffDate(temp.getEffDate());
                    conUserRelInfo.setExpDate(temp.getExpDate());
                    conUserRelInfo.setIdNo(temp.getIdNo());
                    conUserRelInfo.setLoginAccept(temp.getLoginAccept());
                    conUserRelInfo.setLoginNo(temp.getLoginNo());
                    conUserRelInfo.setOpCode(temp.getOpCode());
                    conUserRelInfo.setOpTime(temp.getOpTime());
                    conUserRelInfo.setPayType(temp.getPayType());
                    conUserRelInfo.setPayValue(temp.getPayValue());
                    conUserRelInfo.setRateFlag(temp.getRateFlag());
                    conUserRelInfo.setServAcctId(temp.getServAcctId());
                    conUserRelInfo.setOpNote("1");
                    conUserRelInfo.setOutAccept("1");
                    conUserRelInfo.setPayOrder(1);
                    conUserRelInfo.setSystemNote("1");
                    list.add(conUserRelInfo);
                }
                return list;
            }
            return null;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
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
            ConUserRel conUserRel = new ConUserRel();
            conUserRel.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            conUserRel.setIdNo(idNo);
            conUserRel.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            conUserRel.setLoginNo(updateOprInfo.getLoginNo());
            conUserRel.setOpCode(updateOprInfo.getOpCode());
            conUserRel.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = conUserRelInfo.updateFinishState(conUserRel);
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
