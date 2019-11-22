package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
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
 * @Date: 2019-08-15 20:34
 * @Version: 1.0
 */
@Component("AttrArrayQryAo")
public class AttrArrayQryAo implements IGoodsQryAo {

    @Autowired
    private IServiceClient serviceClient;

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

            OprInfo oprInfo = (OprInfo) map.get("oprInfo");

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("DIV_FLAG", "");
            busiMap.put("ID_NO", "");
            busiMap.put("CUST_ID", "");
            busiMap.put("MASTER_SERV_ID", "");

            List<Map> list = new ArrayList<>();
            Map<String, Object> attrMap = new HashMap<>();
            attrMap.put("MEMBER_ROLE_ID", map.get("MEMBER_ROLE_ID"));
            attrMap.put("PRC_ID", map.get("PRC_ID"));
            attrMap.put("GOODS_ID", map.get("GOODS_ID"));
            attrMap.put("SVC_ID", "");
            attrMap.put("GROUP_TYPE", "");
            attrMap.put("MEMBER_ID", "");
            attrMap.put("GROUP_ID_NO", "");
            list.add(attrMap);
            busiMap.put("ATTR_PARAM", list);

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sAttrArrayQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            JSONArray jsonArray = (JSONArray) mapOutDTO.getBodyHeader().getBody().getOutData().get("ATTR_LIST");

            List<Map> elementList = null;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if ("资费属性".equalsIgnoreCase(jsonObject.getString("ELEMENT_NAME"))) {
                    JSONArray elementArray = jsonObject.getJSONArray("ELEMENT_LIST");

                    elementList = new ArrayList<>();
                    for (int j = 0; j < elementArray.size(); j++) {

                        JSONObject elementObject = elementArray.getJSONObject(j);

                        JSONArray attrArray = elementObject.getJSONArray("ATTRVALUEINFO_LIST");

                        for (int k = 0; k < attrArray.size(); k++) {
                            Map elementMap = new HashMap();
                            JSONObject attrObject = attrArray.getJSONObject(k);

                            elementMap.put("ATTR_ID", elementObject.getString("ATTR_ID"));
                            elementMap.put("ATTR_VALUE", attrObject.getString("CODE_VALUE"));
                            elementMap.put("ATTR_DESC", elementObject.getString("ATTR_DESC"));
                            elementMap.put("ATTR_TYPE", elementObject.getString("ATTR_TYPE"));

                            elementList.add(elementMap);
                        }
                    }
                }
            }

            outMap.put("ATTR_LIST", elementList);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outMap;
    }
}
