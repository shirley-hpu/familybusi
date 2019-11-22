package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019/10/24 8:25 下午
 * @Version: 1.0
 */
@Component("PackageLabelAoSvc")
public class PackageLabelAoSvc implements IGoodsQryAo {

    @Value(value = "classpath:jsonfiles/packageLabel")
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

        try {
            String data = jsonReader.parseJson(resource);

            JSONObject jsonObject = JSONObject.parseObject(data);
            jsonObject = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").getJSONObject("OUT_DATA");

            JSONArray jsonArray = jsonObject.getJSONArray("MODEL_LIST");

            outMap.put("MODEL_LIST", jsonArray);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outMap;
    }
}
