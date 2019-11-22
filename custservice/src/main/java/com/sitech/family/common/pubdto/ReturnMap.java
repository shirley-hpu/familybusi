package com.sitech.family.common.pubdto;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.dto.ReturnDto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description 订单竣工返回信息
 * @date 2019/4/20 16:10
 */
public class ReturnMap {

    public static Map<String, String> ReturnMsg(ReturnDto returnDto) {
        Map<String, String> map = new HashMap<>();

        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
            map.put("RETURN_CODE", "-9999");
            map.put("RETURN_MSG", "该订单竣工失败,请稍后重试");
        } else {
            map.put("RETURN_CODE", "0");
            map.put("RETURN_MSG", "该订单竣工成功");
        }

        return map;
    }
}
