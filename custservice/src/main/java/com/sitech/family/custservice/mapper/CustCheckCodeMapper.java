package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.CustCheckCode;
import org.springframework.stereotype.Repository;

/**
 * @author guanqp
 * @Description 验证码操作
 * @date 2019/3/28 20:03
 */
@Repository
public interface CustCheckCodeMapper {
    /**
     * 入表操作
     * @param custCheckCode
     */
    void create(CustCheckCode custCheckCode);

    /**
     * 查询验证码操作
     * @param phoneNo
     * @return
     */
    CustCheckCode query(String phoneNo);
}
