package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IContractRlt;
import com.sitech.family.custqryservice.dto.mapperdto.AccountRel;
import com.sitech.family.dao.account.IAccountRelInfoQryDao;
import com.sitech.family.dto.account.AccountRelInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭账务关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Service("accountRelInfoQryDaoImpl")
public class AccountRelInfoQryDaoImpl implements IAccountRelInfoQryDao {

    /**
     * AccountRel
     */
    @Autowired
    private IContractRlt contractRlt;

    @Override
    public AccountRelInfo query(Long servAcctId) {

        if (StringUtil.isEmptyOrNull(servAcctId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            //TODO 待物理层方法修改好后 更改
            AccountRel accountRel = contractRlt.query(servAcctId);

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
            // accountRelInfo.setOpCode("");
            // accountRelInfo.setOpNote("");
            // accountRelInfo.setOupAccept("");
            // accountRelInfo.setPayOrder(1);
            // accountRelInfo.setSystemNote("");
            return accountRelInfo;

        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
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
