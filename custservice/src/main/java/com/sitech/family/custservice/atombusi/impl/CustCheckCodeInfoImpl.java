package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.ICustCheckCodeInfo;
import com.sitech.family.dao.dict.ICustCheckCodeDictDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.dict.CustCheckCodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guanqp
 * @Description    验证码操作
 * @date 2019/3/28 17:20
 */
@Component
public class CustCheckCodeInfoImpl implements ICustCheckCodeInfo {

    @Autowired
    private ICustCheckCodeDictDao iCustCheckCodeDictDaoi;

    @Override
    public ReturnDto create(CustCheckCodeInfo custCheckCodeInfo) {
        return iCustCheckCodeDictDaoi.create(custCheckCodeInfo);
    }

    @Override
    public CustCheckCodeInfo query(String  phoneNo) {
        return iCustCheckCodeDictDaoi.query(phoneNo);
    }
}
