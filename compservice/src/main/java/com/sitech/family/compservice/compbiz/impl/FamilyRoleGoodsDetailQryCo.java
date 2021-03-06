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
 * @Date: 2019-09-09 15:15
 * @Version: 1.0
 */
@Component("FamilyRoleGoodsDetailQryCo")
public class FamilyRoleGoodsDetailQryCo implements IFamilyGoodsQryCo {

    @Resource(name = "FamilyRoleGoodsDetailQry")
    private IGoodsQryAo familyRoleGoodsDetailQry;

    /**
     * 组合服务公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        try {
            Map goodsMap = familyRoleGoodsDetailQry.query(map);

            return goodsMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
