package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.ICustCheckCode;
import com.sitech.family.custservice.dto.mapperdto.CustCheckCode;
import com.sitech.family.custservice.mapper.CustCheckCodeMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guanqp
 * @Description  验证码入表和查询操作
 * @date 2019/3/28 19:59
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class CustCheckCodeImpl implements ICustCheckCode {

    @Autowired
    private CustCheckCodeMapper custCheckCodeMapper;

    @Override
    public ReturnDto create(CustCheckCode custCheckCode) {
        ReturnDto returnDto = new ReturnDto();
        try {
            custCheckCodeMapper.create(custCheckCode);
        } catch (Exception e) {
            throw new BusiException("验证码入表出错:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }


    @Override
    public CustCheckCode query(String phoneNo) {

        CustCheckCode  custCheckCode = new CustCheckCode();
        try {
            custCheckCode = custCheckCodeMapper.query(phoneNo);
        } catch (Exception e) {
            throw new BusiException("查询验证码信息失败:" + e.getMessage());
        }

        return custCheckCode;
    }
}
