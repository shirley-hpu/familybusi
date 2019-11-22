package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IConUserRate;
import com.sitech.family.custservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custservice.dto.mapperdto.ConUserRate;
import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
import com.sitech.family.dao.account.IConUserRateInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.ConUserRateInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 家庭付费明细
 * @date 2018/12/17 10:20
 */
@Component
public class ConUserRateInfoDaoImpl implements IConUserRateInfoDao {
    private static Logger logger = LoggerFactory.getLogger(ConUserRateInfoDaoImpl.class);

    @Autowired
    private IConUserRate iConUserRate;

    @Autowired
    private IConUserRelInfo conUserRelInfo;

    /**
     * 新增家庭付费明细
     *
     * @param conUserRateInfo
     */
    @Override
    public ReturnDto create(ConUserRateInfo conUserRateInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            ConUserRel conUserRel = conUserRelInfo.query(conUserRateInfo.getServAcctId());

            if (StringUtil.isEmptyOrNull(conUserRel)) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            ConUserRate conUserRate = new ConUserRate();
            conUserRate.setServAcctId(conUserRateInfo.getServAcctId());
            conUserRate.setBillOrder(conUserRateInfo.getRateBillOrder());
            conUserRate.setDetalCode(conUserRateInfo.getDetailCode());
            conUserRate.setEffDate(conUserRateInfo.getEffDate());
            conUserRate.setExpDate(conUserRateInfo.getExpDate());
            conUserRate.setFeeCode(conUserRateInfo.getFeeCode());
            conUserRate.setFeeRate(conUserRateInfo.getFeeRate());
            conUserRate.setFeeValue(conUserRateInfo.getFeeValue());
            conUserRate.setLoginAccept(conUserRateInfo.getLoginAccept());
            conUserRate.setLoginNo(conUserRateInfo.getLoginNo());
            conUserRate.setOpCode(conUserRateInfo.getOpCode());
            conUserRate.setOpTime(conUserRateInfo.getOpTime());
            conUserRate.setRemark(conUserRateInfo.getOpNote());
            conUserRate.setChkoutPri(conUserRel.getChkoutPri());
            conUserRate.setContractNo(conUserRel.getContractNo());
            conUserRate.setIdNo(conUserRel.getIdNo());
            conUserRate.setUpdateAccept(new Random().nextLong());
            conUserRate.setUpdateCode("1");
            conUserRate.setUpdateDate(1);
            conUserRate.setUpdateLogin("1");
            conUserRate.setUpdateTime(conUserRateInfo.getOpTime());
            conUserRate.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = iConUserRate.create(conUserRate);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            logger.error("新增家庭付费明细失败" + e.getMessage());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 修改家庭付费明细
     *
     * @param conUserRateInfo
     */
    @Override
    public ReturnDto modify(ConUserRateInfo conUserRateInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            ConUserRel conUserRel = conUserRelInfo.query(conUserRateInfo.getServAcctId());

            if (StringUtil.isNotEmptyOrNull(conUserRel)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            ConUserRate conUserRate = new ConUserRate();
            conUserRate.setServAcctId(conUserRateInfo.getServAcctId());
            conUserRate.setBillOrder(conUserRateInfo.getRateBillOrder());
            conUserRate.setDetalCode(conUserRateInfo.getDetailCode());
            conUserRate.setEffDate(conUserRateInfo.getEffDate());
            conUserRate.setExpDate(conUserRateInfo.getExpDate());
            conUserRate.setFeeCode(conUserRateInfo.getFeeCode());
            conUserRate.setFeeRate(conUserRateInfo.getFeeRate());
            conUserRate.setFeeValue(conUserRateInfo.getFeeValue());
            conUserRate.setLoginAccept(conUserRateInfo.getLoginAccept());
            conUserRate.setLoginNo(conUserRateInfo.getLoginNo());
            conUserRate.setOpCode(conUserRateInfo.getOpCode());
            conUserRate.setOpTime(conUserRateInfo.getOpTime());
            conUserRate.setRemark(conUserRateInfo.getOpNote());
            conUserRate.setChkoutPri(conUserRel.getChkoutPri());
            conUserRate.setContractNo(conUserRel.getContractNo());
            conUserRate.setIdNo(conUserRel.getIdNo());
            conUserRate.setUpdateAccept(new Random().nextLong());
            conUserRate.setUpdateCode("1");
            conUserRate.setUpdateDate(1);
            conUserRate.setUpdateLogin("1");
            conUserRate.setUpdateTime(conUserRateInfo.getOpTime());
            conUserRate.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            returnDto = iConUserRate.modify(conUserRate);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            logger.error("修改家庭付费明细失败" + e.toString());
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 删除家庭付费明细
     *
     * @param conUserRateInfo
     */
    @Override
    public ReturnDto drop(ConUserRateInfo conUserRateInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            ConUserRate conUserRate = new ConUserRate();
            conUserRate.setServAcctId(conUserRateInfo.getServAcctId());
            conUserRate.setEffDate(conUserRateInfo.getEffDate());
            conUserRate.setFeeCode(conUserRateInfo.getFeeCode());
            conUserRate.setDetalCode(conUserRateInfo.getDetailCode());
            conUserRate.setUpdateType("D");
            conUserRate.setUpdateAccept(new Random().nextLong());
            conUserRate.setUpdateCode("1");
            conUserRate.setUpdateDate(1);
            conUserRate.setUpdateLogin("1");
            conUserRate.setUpdateTime(new Date());

            returnDto = iConUserRate.drop(conUserRate);

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
     * 查询家庭付费明细
     */
    @Override
    public ConUserRateInfo query(Long servAcctId, String feeCode, Date effDate, String detailCode) {

        if (StringUtil.isEmptyOrNull(servAcctId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(feeCode)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(effDate)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(detailCode)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            ConUserRate conUserRate = iConUserRate.query(servAcctId, effDate, feeCode, detailCode);

            if (StringUtil.isEmptyOrNull(conUserRate)) {
                return new ConUserRateInfo();
            }

            ConUserRateInfo conUserRateInfo = new ConUserRateInfo();
            conUserRateInfo.setServAcctId(conUserRate.getServAcctId());
            conUserRateInfo.setRateBillOrder(conUserRate.getBillOrder());
            conUserRateInfo.setDetailCode(conUserRate.getDetalCode());
            conUserRateInfo.setEffDate(conUserRate.getEffDate());
            conUserRateInfo.setExpDate(conUserRate.getExpDate());
            conUserRateInfo.setFeeCode(conUserRate.getFeeCode());
            conUserRateInfo.setFeeRate(conUserRate.getFeeRate());
            conUserRateInfo.setFeeValue(conUserRate.getFeeValue());
            conUserRateInfo.setLoginAccept(conUserRate.getLoginAccept());
            conUserRateInfo.setLoginNo(conUserRate.getLoginNo());
            conUserRateInfo.setOpCode(conUserRate.getOpCode());
            conUserRateInfo.setOpTime(conUserRate.getOpTime());
            conUserRateInfo.setOpNote(conUserRate.getRemark());
            conUserRateInfo.setOupAccept("1");
            conUserRateInfo.setSystemNote("1");

            return conUserRateInfo;
        } catch (Exception e) {
            return new ConUserRateInfo();
        }
    }

    @Override
    public List<ConUserRateInfo> qryConUserRateInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "参数对象不存在或为空");
        }

        try {
            //
            List<ConUserRate> userRateList = iConUserRate.qryConUserRateList(map);

            List<ConUserRateInfo> list = new ArrayList<>();
            if (!StringUtil.isEmptyOrNull(userRateList)) {

                for (ConUserRate temp : userRateList) {
                    ConUserRateInfo conUserRateInfo = new ConUserRateInfo();
                    conUserRateInfo.setServAcctId(temp.getServAcctId());
                    conUserRateInfo.setRateBillOrder(temp.getBillOrder());
                    conUserRateInfo.setDetailCode(temp.getDetalCode());
                    conUserRateInfo.setEffDate(temp.getEffDate());
                    conUserRateInfo.setExpDate(temp.getExpDate());
                    conUserRateInfo.setFeeCode(temp.getFeeCode());
                    conUserRateInfo.setFeeRate(temp.getFeeRate());
                    conUserRateInfo.setFeeValue(temp.getFeeValue());
                    conUserRateInfo.setLoginAccept(temp.getLoginAccept());
                    conUserRateInfo.setLoginNo(temp.getLoginNo());
                    conUserRateInfo.setOpCode(temp.getOpCode());
                    conUserRateInfo.setOpTime(temp.getOpTime());
                    conUserRateInfo.setOpNote(temp.getRemark());
                    conUserRateInfo.setOupAccept("1");
                    conUserRateInfo.setSystemNote("1");
                    list.add(conUserRateInfo);
                }
                return list;
            }
            return null;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }
}
