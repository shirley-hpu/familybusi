package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IContractRlt;
import com.sitech.family.custservice.dto.mapperdto.AccountRel;
import com.sitech.family.dao.account.IAccountRelInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.AccountRelInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class AccountRelInfoDaoImpl implements IAccountRelInfoDao {

    /**
     * AccountRel
     */
    @Autowired
    private IContractRlt contractRlt;

    @Override
    public ReturnDto create(AccountRelInfo accountRelInfoDto) {
        if (StringUtil.isEmptyOrNull(accountRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            AccountRel accountRel = new AccountRel();
            accountRel.setServAcctId(accountRelInfoDto.getServAcctId());
            accountRel.setLoginAccept(accountRelInfoDto.getLoginAccept());
            accountRel.setContractNo(accountRelInfoDto.getContractNo());
            accountRel.setRelContractNo(accountRelInfoDto.getRelContractNo());
            accountRel.setAcctRelType(accountRelInfoDto.getAcctRelType());
            accountRel.setAcctItems(accountRelInfoDto.getAcctItems());
            accountRel.setPayValue(accountRelInfoDto.getPayValue());
            accountRel.setPayPri(accountRelInfoDto.getPayOrder());
            accountRel.setEffDate(accountRelInfoDto.getEffDate());
            accountRel.setExpDate(accountRelInfoDto.getExpDate());
            accountRel.setLoginNo(accountRelInfoDto.getLoginNo());
            accountRel.setOpTime(accountRelInfoDto.getOpTime());
            accountRel.setRemark(accountRelInfoDto.getOpNote());

            accountRel.setUpdateAccept(new Random().nextLong());
            accountRel.setUpdateCode("1");
            accountRel.setUpdateDate(1);
            accountRel.setUpdateLogin("1");
            accountRel.setUpdateTime(accountRelInfoDto.getOpTime());
            accountRel.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            contractRlt.create(accountRel);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(AccountRelInfo accountRelInfoDto) {
        if (StringUtil.isEmptyOrNull(accountRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            AccountRel accountRel = new AccountRel();
            accountRel.setServAcctId(accountRelInfoDto.getServAcctId());
            accountRel.setLoginAccept(accountRelInfoDto.getLoginAccept());
            accountRel.setContractNo(accountRelInfoDto.getContractNo());
            accountRel.setRelContractNo(accountRelInfoDto.getRelContractNo());
            accountRel.setAcctRelType(accountRelInfoDto.getAcctRelType());
            accountRel.setAcctItems(accountRelInfoDto.getAcctItems());
            accountRel.setPayValue(accountRelInfoDto.getPayValue());
            accountRel.setPayPri(accountRelInfoDto.getPayOrder());
            accountRel.setEffDate(accountRelInfoDto.getEffDate());
            accountRel.setExpDate(accountRelInfoDto.getExpDate());
            accountRel.setLoginNo(accountRelInfoDto.getLoginNo());
            accountRel.setOpTime(accountRelInfoDto.getOpTime());
            accountRel.setRemark(accountRelInfoDto.getOpNote());
            accountRel.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            accountRel.setUpdateAccept(new Random().nextLong());
            accountRel.setUpdateCode("1");
            accountRel.setUpdateDate(1);
            accountRel.setUpdateLogin("1");
            accountRel.setUpdateTime(accountRelInfoDto.getOpTime());

            contractRlt.modify(accountRel);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(AccountRelInfo accountRelInfoDto) {
        if (StringUtil.isEmptyOrNull(accountRelInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            AccountRel accountRel = new AccountRel();
            accountRel.setServAcctId(accountRelInfoDto.getServAcctId());
            accountRel.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            accountRel.setUpdateAccept(new Random().nextLong());
            accountRel.setUpdateCode("1");
            accountRel.setUpdateDate(1);
            accountRel.setUpdateLogin("1");
            accountRel.setUpdateTime(accountRelInfoDto.getOpTime());

            contractRlt.drop(accountRel);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public AccountRelInfo query(Long servAcctId) {

        if (StringUtil.isEmptyOrNull(servAcctId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            AccountRel accountRel = contractRlt.query(servAcctId);

            if (StringUtil.isEmptyOrNull(accountRel)) {
                return new AccountRelInfo();
            }

            AccountRelInfo accountRelInfo = new AccountRelInfo();
            accountRelInfo.setAcctItems(accountRel.getAcctItems());
            accountRelInfo.setAcctRelType(accountRel.getAcctRelType());
            accountRelInfo.setContractNo(accountRel.getContractNo());
            accountRelInfo.setEffDate(accountRel.getEffDate());
            accountRelInfo.setExpDate(accountRel.getExpDate());
            accountRelInfo.setLoginAccept(accountRel.getLoginAccept());
            accountRelInfo.setLoginNo(accountRel.getLoginNo());
            accountRelInfo.setOpTime(accountRel.getOpTime());
            accountRelInfo.setPayValue(accountRel.getPayValue());
            accountRelInfo.setRelContractNo(accountRel.getRelContractNo());
            accountRelInfo.setServAcctId(accountRel.getServAcctId());
            accountRelInfo.setOpCode("1");
            accountRelInfo.setOpNote("1");
            accountRelInfo.setOutAccept("1");
            accountRelInfo.setPayOrder(1);
            accountRelInfo.setSystemNote("1");

            return accountRelInfo;
        } catch (Exception e) {
            return new AccountRelInfo();
        }
    }

    @Override
    public List<AccountRelInfo> qryAccountRelInfoList(Map map) {
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
}
