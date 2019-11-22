package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭套餐查询组合服务
 * @date 2018/9/27 17:06
 */
@Component("FamilyGoodsQryCo")
public class FamilyGoodsQryCo implements IFamilyGoodsQryCo {
    private static Logger logger = LoggerFactory.getLogger(FamilyGoodsQryCo.class);

    @Resource(name = "SearchPgPrcAo")
    private IGoodsQryAo searchPgPrcAo;

    @Resource(name = "PackageLabelAoSvc")
    private IGoodsQryAo packageLabelAoSvc;

    /**
     * 家庭套餐查询
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {

        try {
            Map goodsMap = searchPgPrcAo.query(map);

            Map modelMap = packageLabelAoSvc.query(map);

            ArrayList goodsList = (ArrayList) goodsMap.get("GOODSLIST");
            JSONArray modelList = (JSONArray) modelMap.get("MODEL_LIST");

            Map map1 = new HashMap();
            Map map2 = new HashMap();
            Map map3 = new HashMap();
            Map map4 = new HashMap();
            Map map5 = new HashMap();
            Map map6 = new HashMap();
            Map map7 = new HashMap();
            for (int i = 0; i < modelList.size(); i++) {
                JSONObject modelObject = (JSONObject) modelList.getJSONObject(i).get(i);

                JSONArray jsonArray = modelObject.getJSONArray("LABEL_LIST");

                if (i == 0){
                    map1.put("LABEL_LIST",jsonArray);
                }
                if (i == 1){
                    map2.put("LABEL_LIST",jsonArray);
                }
                if (i == 2){
                    map3.put("LABEL_LIST",jsonArray);
                }
                if (i == 3){
                    map4.put("LABEL_LIST",jsonArray);
                }
                if (i == 4){
                    map5.put("LABEL_LIST",jsonArray);
                }
                if (i == 5){
                    map6.put("LABEL_LIST",jsonArray);
                }
                if (i == 6){
                    map7.put("LABEL_LIST",jsonArray);
                }
            }

            List<Map> list = new ArrayList<>();
            for (int i = 0; i < goodsList.size(); i++) {
                HashMap hashMap = (HashMap) goodsList.get(i);
                if (i % 7 == 0) {
                    hashMap.put("LABEL_LIST", map1.get("LABEL_LIST"));
                }
                if (i % 7 == 1) {
                    hashMap.put("LABEL_LIST", map2.get("LABEL_LIST"));
                }
                if (i % 7 == 2) {
                    hashMap.put("LABEL_LIST", map3.get("LABEL_LIST"));
                }
                if (i % 7 == 3) {
                    hashMap.put("LABEL_LIST", map4.get("LABEL_LIST"));
                }
                if (i % 7 == 4) {
                    hashMap.put("LABEL_LIST", map5.get("LABEL_LIST"));
                }
                if (i % 7 == 5) {
                    hashMap.put("LABEL_LIST", map6.get("LABEL_LIST"));
                }
                if (i % 7 == 6) {
                    hashMap.put("LABEL_LIST", map7.get("LABEL_LIST"));
                }
                list.add(hashMap);
            }

            Map outMap = new HashMap();
            outMap.put("GOODSLIST", list);

            return outMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}