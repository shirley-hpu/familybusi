package com.sitech.family.custservice.atombusi;


import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.dict.CustCheckCodeInfo;


/**
 * @author guanqp
 * @Description  验证码操作
 * @date 2019/3/28 17:03
 */
public interface ICustCheckCodeInfo {

    //新增
    ReturnDto create(CustCheckCodeInfo custCheckCodeInfo);

    /**
     * 查询
     * @param phoneNo
     * @return
     */
    public CustCheckCodeInfo query( String phoneNo);
}