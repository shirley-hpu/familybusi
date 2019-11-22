package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.CustCheckCode;
import com.sitech.family.dto.ReturnDto;

/**
 * @author guanqp
 * @Description  验证码操作
 * @date 2019/3/28 19:39
 */
public interface ICustCheckCode {

    /**
     * 验证码入表操作
     *
     * @param  custCheckCode
    * @return ReturnDto
     */
    ReturnDto create(CustCheckCode custCheckCode);

    /**
     * 查询用户商品订购实例信息
     *
     * @param phoneNo
     * @return ReturnDto
     */
    CustCheckCode query(String phoneNo);

}
