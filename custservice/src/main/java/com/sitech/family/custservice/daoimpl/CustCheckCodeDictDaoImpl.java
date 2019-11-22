package com.sitech.family.custservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.ICustCheckCode;
import com.sitech.family.custservice.dto.mapperdto.CustCheckCode;
import com.sitech.family.dao.dict.ICustCheckCodeDictDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.dict.CustCheckCodeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  验证码的操作
 * @date 2019/3/29 13:50
 */
@Component
public class CustCheckCodeDictDaoImpl implements ICustCheckCodeDictDao {

    private static Logger logger = LoggerFactory.getLogger(CustCheckCodeDictDaoImpl.class);

    @Autowired
    private ICustCheckCode iCustCheckCode;

    /**
     * 入表操作
     * @param custCheckCodeInfo
     * @return
     */
    @Override
    public ReturnDto create(CustCheckCodeInfo custCheckCodeInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            CustCheckCode custCheckCode = new CustCheckCode();

            custCheckCode.setCheckCode(custCheckCodeInfo.getCheckCode());
            custCheckCode.setEffectiveTime(custCheckCodeInfo.getEffectiveTime());
            custCheckCode.setPhoneNo(custCheckCodeInfo.getPhoneNo());
            custCheckCode.setOpTime(custCheckCodeInfo.getOpTime());

            returnDto= iCustCheckCode.create(custCheckCode);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }
        } catch (Exception e) {
            throw new BusiException("新增验证码信息失败 " + e.getMessage());
        }

        return returnDto;
    }

    /**
     * 查询最新的验证码
     * @param phoneNo
     * @return
     */
    @Override
    public CustCheckCodeInfo query(String phoneNo) {
        if (StringUtil.isEmptyOrNull(phoneNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        try {

            CustCheckCode custCheckCode = new CustCheckCode();

            custCheckCode = iCustCheckCode.query(phoneNo);

            CustCheckCodeInfo custCheckCodeInfo = new CustCheckCodeInfo();

            custCheckCodeInfo.setCheckCode(custCheckCode.getCheckCode());
            custCheckCodeInfo.setEffectiveTime(custCheckCode.getEffectiveTime());
            custCheckCodeInfo.setPhoneNo(custCheckCode.getPhoneNo());
            custCheckCodeInfo.setOpTime(custCheckCode.getOpTime());

            return custCheckCodeInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询验证码信息失败");
        }
    }
}
