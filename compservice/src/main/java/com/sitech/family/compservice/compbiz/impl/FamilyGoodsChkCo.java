package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IGoodsChkAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsChkCo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 关系校验组合服务
 * @date 2018/9/27 17:06
 */
@Component("FamilyGoodsChkCo")
public class FamilyGoodsChkCo implements IFamilyGoodsChkCo {
    private static Logger logger = LoggerFactory.getLogger(FamilyGoodsChkCo.class);

    @Resource(name = "MoreBusiRelChkAo")
    private IGoodsChkAo moreBusiRelChkAo;

    /**
     * 组合服务关系校验
     *
     * @param map
     * @return map
     */
    @Override
    public Map check(Map<String, Object> map) {

        try {
            Map checkMap = moreBusiRelChkAo.check(map);

            return checkMap;
        } catch (Exception e) {
            logger.error("组合服务关系校验失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }
}
