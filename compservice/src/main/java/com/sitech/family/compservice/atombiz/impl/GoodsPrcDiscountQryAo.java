package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsPrcDiscount;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-03 11:11
 * @Version: 1.0
 */
@Component("goodsPrcDiscountQryAo")
public class GoodsPrcDiscountQryAo implements IGoodsQryAo {

    @Autowired
    private IServiceClient serviceClient;

    @Value(value = "classpath:jsonfiles/discount")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    /**
     * 原子服务产商品公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        Map outMap = new HashMap();
        OutDTO<Map> mapOutDTO = new OutDTO<>();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            FamilyGoodsPrcDiscount familyGoodsPrcDiscount = (FamilyGoodsPrcDiscount) map.get("busiInfo");

            Map busiMap = new HashMap();
            busiMap.put("FAV_OBJ_VALUE", familyGoodsPrcDiscount.getMbrPrcId());
            busiMap.put("OBJECT_ID", familyGoodsPrcDiscount.getPkgPrcId());

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-favour/sFavQueryAoSvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            JSONArray jsonArray = (JSONArray) mapOutDTO.getBodyOutData().get("FAV_LIST");

            outMap.put("FAV_LIST", jsonArray);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
        return outMap;
    }
}
