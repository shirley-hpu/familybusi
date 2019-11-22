package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custqryservice.dto.mapperdto.ConUserRel;
import com.sitech.family.dao.account.IConUserRelInfoQryDao;
import com.sitech.family.dto.account.ConUserRelInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 逻辑模型实现层
 * 家庭付费关系
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Service("conUserRelInfoQryDaoImpl")
public class ConUserRelInfoQryDaoImpl implements IConUserRelInfoQryDao {

    /**
     * 调用物理原子实体方法Mapper中ConUserRelInfo方法
     */
    @Autowired
    private IConUserRelInfo conUserRelInfo;

    @Override
    public ConUserRelInfo query(Long servAcctId) {

        if (StringUtil.isEmptyOrNull(servAcctId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            ConUserRel conUserRel = conUserRelInfo.query(servAcctId);

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
            //    conUserRelInfo.setOpNote("");
            //    conUserRelInfo.setOupAccept("");
            //    conUserRelInfo.setPayOrder(1);
            //    conUserRelInfo.setSystemNote("");

            return conUserRelInfo;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }

    }

    @Override
    public List<ConUserRelInfo> qryConUserRelInfoList(Map map) {
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
