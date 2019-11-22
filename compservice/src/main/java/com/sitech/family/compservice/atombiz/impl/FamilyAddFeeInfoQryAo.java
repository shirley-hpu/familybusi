package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IFamilyAddFeeInfoQryAo;
import com.sitech.family.compservice.dto.indto.FamilyAddFeeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-07-31 17:09
 * @Version: 1.0
 */
@Component("familyAddFeeInfoQryAo")
public class FamilyAddFeeInfoQryAo implements IFamilyAddFeeInfoQryAo {

    @Autowired
    private IServiceClient serviceClient;

    /**
     * 附加资费全量信息
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map qryFamilyAddFeeInfo(Map<String, Object> map) {
        Map outMap = new HashMap();
        OutDTO<Map> mapOutDTO = new OutDTO<>();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            OprInfo oprInfo = (OprInfo) map.get("oprInfo");
            FamilyAddFeeInfo familyAddFeeInfo = (FamilyAddFeeInfo) map.get("busiInfo");

            Map<String, String> busiMap = new HashMap<>();
            busiMap.put("PRC_USE_RANGE", "");
            busiMap.put("GROUP_ID", oprInfo.getGroupId());
            busiMap.put("MAIN_PG_PRCID", "");
            busiMap.put("MASTER_SERV_ID", familyAddFeeInfo.getMasterServId());
            busiMap.put("GOODS_TYPE", familyAddFeeInfo.getGoodsType());
            busiMap.put("RUN_FLAG", familyAddFeeInfo.getRunFlag());
            busiMap.put("USER_MAIN_PRCID", familyAddFeeInfo.getPrcId());
            busiMap.put("USER_RANGE", familyAddFeeInfo.getUserRange());
            busiMap.put("CLASS_ID", "");
            busiMap.put("RELEASE_FLAG", "");
            busiMap.put("SHOW_FLAG", "");
            busiMap.put("GROUP_TYPE", "");
            busiMap.put("CHANNEL_ID", "11");
            busiMap.put("BRAND_ID", "");
            busiMap.put("PRC_CLASS", "");
            busiMap.put("PRC_NAME", "");
            busiMap.put("ID_NO", "");

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sSearchPgPrcSvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            Map<Object, JSONArray> mapData = mapOutDTO.getBodyOutData();

            JSONArray arrayList = mapData.get("LIST");

            Map<String, Integer> intMap = new HashMap<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String value = String.valueOf(arrayList.getJSONObject(i).get("GOODS_ID"));

                Integer count = 1;

                if (intMap.get(value) != null) {
                    count = intMap.get(value) + 1;
                }

                intMap.put(value, count);
            }

            List<Map> list = new ArrayList<>();
            for (String key : intMap.keySet()) {
                List<Map> mapList = new ArrayList<>();
                Map<String, Object> goodsMap = new HashMap<>();

                for (int i = 0; i < arrayList.size(); i++) {
                    String value = String.valueOf(arrayList.getJSONObject(i).get("GOODS_ID"));

                    if (key.equals(value)) {
                        goodsMap.put("GOODS_ID", key);
                        goodsMap.put("GOODS_NAME", String.valueOf(arrayList.getJSONObject(i).get("GOODS_NAME")));
                        goodsMap.put("GOODS_TYPE", String.valueOf(arrayList.getJSONObject(i).get("GOODS_TYPE")));
                        goodsMap.put("EFF_DATE", String.valueOf(arrayList.getJSONObject(i).get("EFF_DATE")));
                        goodsMap.put("EXP_DATE", String.valueOf(arrayList.getJSONObject(i).get("EXP_DATE")));
                        //goodsMap.put("FREE_SUM", String.valueOf(arrayList.getJSONObject(i).get("FREE_SUM")));
                        goodsMap.put("MASTER_SERV_ID", String.valueOf(arrayList.getJSONObject(i).get("MASTER_SERV_ID")));
                        Map<String, String> prcMap = new HashMap<>();
                        prcMap.put("PRC_ID", String.valueOf(arrayList.getJSONObject(i).get("PRC_ID")));
                        prcMap.put("PRC_NAME", String.valueOf(arrayList.getJSONObject(i).get("PRC_NAME")));
                        prcMap.put("USE_RANGE", String.valueOf(arrayList.getJSONObject(i).get("USE_RANGE")));

                        mapList.add(prcMap);
                    }
                }
                goodsMap.put("PRCINFOLIST", mapList);

                list.add(goodsMap);
            }

            outMap.put("GOODSINFOLIST", list);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
        return outMap;
    }
}
