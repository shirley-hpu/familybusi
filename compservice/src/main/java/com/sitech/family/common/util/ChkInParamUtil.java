package com.sitech.family.common.util;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Set;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

public class ChkInParamUtil {

    /**
     * @param map
     * 公共类:入参非空校验
     */
    public static void chkInParam(MultiValueMap<String,String> map) {
        Set<String> stringSet = map.keySet();

        for (String key : stringSet) {
            List<String> values = map.get(key);

            if (StringUtil.isEmptyOrNull(values.get(1))) {
                throw new BusiException(getErrorCode("1000", "15001"), "服务调用参数错误," + key + "(" + values.get(0) + ")" + "不能为空!");
            }
        }
    }
}
