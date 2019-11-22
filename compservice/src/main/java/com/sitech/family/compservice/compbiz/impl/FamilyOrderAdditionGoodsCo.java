package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-20 10:13
 * @Version: 1.0
 */
@Component("FamilyOrderAdditionGoodsCo")
public class FamilyOrderAdditionGoodsCo implements IFamilyGoodsQryCo {

    @Resource(name = "FamilyOrderAdditionGoodsAo")
    private IGoodsQryAo familyOrderAdditionGoodsAo;

    /**
     * 组合服务公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {

        try {
            Map outMap = familyOrderAdditionGoodsAo.query(map);
            return outMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
