package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsLabelQryCo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/2 17:40
 */
@Component("FamilyGoodsLabelQryCoSvc")
public class FamilyGoodsLabelQryCoSvc implements IFamilyGoodsLabelQryCo {

    @Resource(name = "GoodsLabelQryAoSvc")
    private IGoodsQryAo goodsLabelQryAoSvc;

    /**
     * 商品标签查询
     * @param map
     * @return outDTO
     */
    @Override
    public Map query(Map<String, Object> map) {

        try {
            Map outMap = goodsLabelQryAoSvc.query(map);

            return outMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
