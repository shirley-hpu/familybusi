package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IConUserRate;
import com.sitech.family.custqryservice.dto.mapperdto.ConUserRate;
import com.sitech.family.dao.account.IConUserRateInfoQryDao;
import com.sitech.family.dto.account.ConUserRateInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 10:20
 */
@Component
public class ConUserRateInfoDaoImpl implements IConUserRateInfoQryDao {

    @Autowired
    private IConUserRate conUserRate;

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
            //TODO
            ConUserRate userRate = conUserRate.query(servAcctId, effDate, feeCode, detailCode);

            ConUserRateInfo conUserRateInfo = new ConUserRateInfo();

            conUserRateInfo.setServAcctId(userRate.getServAcctId());
            conUserRateInfo.setRateBillOrder(userRate.getBillOrder());
            conUserRateInfo.setDetailCode(userRate.getDetalCode());
            conUserRateInfo.setEffDate(userRate.getEffDate());
            conUserRateInfo.setExpDate(userRate.getExpDate());
            conUserRateInfo.setFeeCode(userRate.getFeeCode());
            conUserRateInfo.setFeeRate(userRate.getFeeRate());
            conUserRateInfo.setFeeValue(userRate.getFeeValue());
            conUserRateInfo.setLoginAccept(userRate.getLoginAccept());
            conUserRateInfo.setLoginNo(userRate.getLoginNo());
            conUserRateInfo.setOpCode(userRate.getOpCode());
            conUserRateInfo.setOpTime(userRate.getOpTime());
            conUserRateInfo.setOpNote(userRate.getRemark());
            return conUserRateInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭付费明细失败");
        }
    }

    @Override
    public List<ConUserRateInfo> qryConUserRateInfoList(Map map) {
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
