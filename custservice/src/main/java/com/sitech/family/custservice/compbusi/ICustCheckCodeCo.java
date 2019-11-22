package com.sitech.family.custservice.compbusi;

import com.sitech.family.dto.ReturnDto;
import java.util.Map;

/**
 * @author guanqp
 * @Description   验证码入表Co层
 * @date 2019/3/28 16:38
 */
public interface ICustCheckCodeCo {

    /**
     * 验证码入表
     * @param map
     * @return
     */
    ReturnDto create(Map<String, Object> map);

    Map query(Map<String, Object> map);
}
