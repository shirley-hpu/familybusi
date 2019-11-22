package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/2 17:57
 */
@Component("GoodsLabelQryAoSvc")
public class GoodsLabelQryAoSvc implements IGoodsQryAo {

    @Value(value = "classpath:jsonfiles/goodsLabel")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    /**
     * 产商品接口查询或者校验服务
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map query(Map<String, Object> map) {
        Map outMap = new HashMap();

        try {
            String data = jsonReader.parseJson(resource);

            JSONObject jsonObject = JSONObject.parseObject(data);
            jsonObject = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").getJSONObject("OUT_DATA");

            JSONArray jsonArray = jsonObject.getJSONArray("LABELLIST");

            outMap.put("LABELLIST",jsonArray);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
        return outMap;
    }
}
