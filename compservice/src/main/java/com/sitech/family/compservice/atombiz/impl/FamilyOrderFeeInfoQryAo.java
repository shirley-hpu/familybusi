package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IFamilyOrderFeeInfoQryAo;
import com.sitech.family.compservice.dto.indto.FamilyOrderFeeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-08-13 19:21
 * @Version: 1.0
 */
@Component
public class FamilyOrderFeeInfoQryAo implements IFamilyOrderFeeInfoQryAo {

    @Autowired
    private IServiceClient serviceClient;

    /**
     * 附加资费已订购信息
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map qryFamilyOrderFeeInfo(Map<String, Object> map) {

        Map outMap = new HashMap();
        OutDTO<Map> mapOutDTO = new OutDTO<>();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            FamilyOrderFeeInfo familyOrderFeeInfo = (FamilyOrderFeeInfo) map.get("busiInfo");

            Map<String, String> busiMap = new HashMap<>();
            busiMap.put("PHONE_NO", familyOrderFeeInfo.getPhoneNo());

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyOrderFeeInfo",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            JSONArray arrayList = (JSONArray) mapOutDTO.getBodyOutData();

            List<Map> goodsList = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {

                JSONObject goodsObject = (JSONObject) arrayList.get(i);

                JSONArray array = goodsObject.getJSONArray("GOODSLIST");

                for (int j = 0; j < array.size(); j++) {
                    Map goodsMap = new HashMap();

                    goodsMap.put("GOODS_ID", String.valueOf(array.getJSONObject(j).get("GOODS_ID")));
                    goodsMap.put("PRC_ID", String.valueOf(array.getJSONObject(j).get("PRC_ID")));
                    goodsMap.put("EFF_DATE", String.valueOf(array.getJSONObject(j).get("EFF_DATE")));
                    goodsMap.put("EXP_DATE", String.valueOf(array.getJSONObject(j).get("EXP_DATE")));

                    JSONArray attrArray = (JSONArray) array.getJSONObject(j).get("ATTRLIST");

                    List<Map> attrList = new ArrayList<>();
                    for (int k = 0; k < attrArray.size(); k++) {
                        Map attrMap = new HashMap();
                        attrMap.put("ATTR_ID", String.valueOf(attrArray.getJSONObject(k).get("ATTR_ID")));
                        attrMap.put("ATTR_NO", String.valueOf(attrArray.getJSONObject(k).get("ATTR_NO")));
                        attrMap.put("ATTR_VALUE", String.valueOf(attrArray.getJSONObject(k).get("ATTR_VALUE")));
                        attrList.add(attrMap);
                    }

                    goodsMap.put("ATTRLIST", attrList);

                    goodsList.add(goodsMap);
                }

                outMap.put("GOODSLIST", goodsList);
            }
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outMap;
    }
}
