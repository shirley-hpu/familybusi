package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 商品定价属性查询组合服务
 * @date 2018/9/27 17:06
 */
@Component("FamilyGoodsPrcAttrQryCo")
public class FamilyGoodsPrcAttrQryCo implements IFamilyGoodsQryCo {
    private static Logger logger = LoggerFactory.getLogger(FamilyGoodsPrcAttrQryCo.class);

    @Resource(name = "AttrQryBaseAo")
    private IGoodsQryAo attrQryBaseAo;

    /**
     * 商品定价属性查询
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {

        try {
            Map prcMap = attrQryBaseAo.query(map);

            return prcMap;
        } catch (Exception e) {
            logger.error("商品定价属性查询失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }
}