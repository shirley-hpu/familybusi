package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.ICustCheckCodeInfo;
import com.sitech.family.custservice.compbusi.ICustCheckCodeCo;
import com.sitech.family.custservice.dto.indto.CustCheckCodeInDto;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.dict.CustCheckCodeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description
 * @date 2019/3/28 16:53
 */
@Component
public class CustCheckCodeCo implements ICustCheckCodeCo {

    /**
     *atom层接口
     */
    @Autowired
    private ICustCheckCodeInfo iCustCheckCodeInfo;

    @Transactional(rollbackFor = BusiException.class)
    @Override
    public ReturnDto create(Map<String, Object> map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto result;
        
        try {
            // 1、获取参数节点
            CustCheckCodeInDto custCheckCodeInDto =(CustCheckCodeInDto) map.get("BUSI_INFO");


            //2、拼接逻辑实体参数
            CustCheckCodeInfo custCheckCodeInfo =  new CustCheckCodeInfo();
            
            custCheckCodeInfo.setCheckCode(new BigDecimal((custCheckCodeInDto.getCheckCode())));
            custCheckCodeInfo.setEffectiveTime(new BigDecimal(custCheckCodeInDto.getEffectiveTime()));
            custCheckCodeInfo.setOpTime(Timestamp.valueOf(custCheckCodeInDto.getOpTime()));
            custCheckCodeInfo.setPhoneNo(custCheckCodeInDto.getPhoneNo());
            
            //掉用逻辑层进行入表操作
            ReturnDto returnDto = iCustCheckCodeInfo.create(custCheckCodeInfo);
           
            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                throw new BusiException(returnDto.getMessage());
            }

        } catch (Exception e) {
            throw new BusiException("验证码入表失败 " + e.getMessage());
        }
        
        //返回方法信息
        result = new ReturnDto();
        result.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return result;
    }

    @Transactional(rollbackFor = BusiException.class)
    @Override
    public Map query(Map<String, Object> map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        // 1、获取参数节点
        CustCheckCodeInDto custCheckCodeInDto =(CustCheckCodeInDto) map.get("BUSI_INFO");
        
        //2、获取电话号码
        String phoneNo = custCheckCodeInDto.getPhoneNo();
        CustCheckCodeInfo custCheckCodeInfo = iCustCheckCodeInfo.query(phoneNo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BigDecimal checkCode = custCheckCodeInfo.getCheckCode();
        BigDecimal effectiveTime = custCheckCodeInfo.getEffectiveTime();
        Date opTime = custCheckCodeInfo.getOpTime();
        Map<String, String> outDto = new HashMap<>();
        outDto.put("CHECK_CODE",checkCode.toString());
        outDto.put("EFFECTIVE_TIME",effectiveTime.toString());
        outDto.put("OP_TIME", sdf.format(opTime));
        return outDto;
    }
}
