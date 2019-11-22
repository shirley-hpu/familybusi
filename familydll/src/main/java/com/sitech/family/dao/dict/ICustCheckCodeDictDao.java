package com.sitech.family.dao.dict;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.dict.CustCheckCodeInfo;

/**
 * @author guanqp
 * @Description  验证码入表和查询的操作
 * @date 2019/3/29 13:37
 */
public interface ICustCheckCodeDictDao {

    /**
     * 验证码入表的操作
     *
     * @pram CustCheckCodeInfo
     */
    ReturnDto create(CustCheckCodeInfo custCheckCodeInfo);

    /**
     *  查询验证码操作
     * @param phoneNo
     * @return  CustCheckCodeInfo
     */
    CustCheckCodeInfo query(String phoneNo);
}
