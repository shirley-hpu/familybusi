package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IContractRlt;
import com.sitech.family.custservice.dto.mapperdto.AccountRel;
import com.sitech.family.custservice.mapper.AccountRelMapper;
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
 * 账户关系实体 实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ContractRltImpl implements IContractRlt {

    @Autowired
    private AccountRelMapper accountRelMapper;

    /**
     * 创建账户关系信息
     *
     * @param accountRel
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(AccountRel accountRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            accountRelMapper.create(accountRel);

            accountRelMapper.insert(accountRel);

        } catch (Exception e) {
            throw new BusiException("创建账户关系信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除账户关系信息
     *
     * @param accountRel
     * @return
     */

    @Override
    public ReturnDto drop(AccountRel accountRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            AccountRel accountRelQry = accountRelMapper.query(accountRel.getServAcctId());

            if (StringUtil.isEmptyOrNull(accountRelQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除账户关系信息失败");
                return returnDto;
            }

            accountRelQry.setUpdateAccept(accountRel.getUpdateAccept());
            accountRelQry.setUpdateType(accountRel.getUpdateType());
            accountRelQry.setUpdateTime(accountRel.getUpdateTime());
            accountRelQry.setUpdateDate(accountRel.getUpdateDate());
            accountRelQry.setUpdateLogin(accountRel.getUpdateLogin());
            accountRelQry.setUpdateCode(accountRel.getUpdateCode());

            accountRelMapper.insert(accountRelQry);

            accountRelMapper.drop(accountRel.getServAcctId());

        } catch (Exception e) {
            throw new BusiException("删除账户关系信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 修改账户关系信息
     *
     * @param accountRel
     * @return
     */
    @Override
    public ReturnDto modify(AccountRel accountRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            AccountRel accountRelQry = accountRelMapper.query(accountRel.getServAcctId());

            if (StringUtil.isEmptyOrNull(accountRelQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,修改账户关系信息失败");
                return returnDto;
            }

            accountRelQry.setUpdateAccept(accountRel.getUpdateAccept());
            accountRelQry.setUpdateType(accountRel.getUpdateType());
            accountRelQry.setUpdateTime(accountRel.getUpdateTime());
            accountRelQry.setUpdateDate(accountRel.getUpdateDate());
            accountRelQry.setUpdateLogin(accountRel.getUpdateLogin());
            accountRelQry.setUpdateCode(accountRel.getUpdateCode());

            accountRelMapper.insert(accountRelQry);

            accountRelMapper.modify(accountRel);

            accountRel.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            accountRelMapper.insert(accountRel);

        } catch (Exception e) {
            throw new BusiException("修改账户关系信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询账户关系信息
     *
     * @param servAcctId
     * @return AccountRel
     */
    @Override
    public AccountRel query(Long servAcctId) {
        AccountRel accountRel = new AccountRel();

        try {
            accountRel = accountRelMapper.query(servAcctId);
        } catch (Exception e) {
            throw new BusiException("查询账户关系信息失败:" + e.getMessage());
        }

        return accountRel;
    }

    /**
     * 查询账户关系信息
     *
     * @param map
     * @return List<AccountRel>
     */
    @Override
    public List<AccountRel> qryContractRltList(Map map) {
        List<AccountRel> accountRelList = new ArrayList<>();

        try {
            accountRelList = accountRelMapper.qryContractRltList(map);
        } catch (Exception e) {
            throw new BusiException("查询账户关系信息失败:" + e.getMessage());
        }

        return accountRelList;
    }

    /**
     * 查询历史账户信息信息
     *
     * @param map
     * @return List<AccountRel>
     */
    @Override
    public List<AccountRel> qryContractRltHisList(Map map) {
        List<AccountRel> accountRelList = new ArrayList<>();

        try {
            accountRelList = accountRelMapper.qryContractRltHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询账户关系信息失败:" + e.getMessage());
        }

        return accountRelList;
    }

}
