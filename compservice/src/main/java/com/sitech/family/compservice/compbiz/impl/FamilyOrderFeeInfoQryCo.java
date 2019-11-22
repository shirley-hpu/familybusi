package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSON;
import com.sitech.family.compservice.atombiz.IFamilyAddFeeInfoQryAo;
import com.sitech.family.compservice.atombiz.IFamilyOrderFeeInfoQryAo;
import com.sitech.family.compservice.compbiz.IFamilyOrderFeeInfoQryCo;
import com.sitech.family.compservice.dto.indto.FamilyAddFeeInfo;
import com.sitech.family.compservice.dto.indto.FamilyOrderFeeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-08-12 15:36
 * @Version: 1.0
 */
@Component
public class FamilyOrderFeeInfoQryCo implements IFamilyOrderFeeInfoQryCo {

    @Resource
    private IFamilyOrderFeeInfoQryAo iFamilyOrderFeeInfoQryAo;

    @Resource
    private IFamilyAddFeeInfoQryAo iFamilyAddFeeInfoQryAo;

    /**
     * 附加资费已订购信息
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map qryFamilyOrderFeeInfo(Map<String, Object> map) {
        try {
            Map orderMap = iFamilyOrderFeeInfoQryAo.qryFamilyOrderFeeInfo(map);

            FamilyOrderFeeInfo familyOrderFeeInfo = (FamilyOrderFeeInfo) map.get("busiInfo");

            FamilyAddFeeInfo familyAddFeeInfo = new FamilyAddFeeInfo();
            familyAddFeeInfo.setGoodsType(familyOrderFeeInfo.getGoodsType());
            familyAddFeeInfo.setMasterServId(familyOrderFeeInfo.getMasterServId());
            familyAddFeeInfo.setPrcId(familyOrderFeeInfo.getPrcId());
            familyAddFeeInfo.setRunFlag(familyOrderFeeInfo.getRunFlag());
            familyAddFeeInfo.setUserRange(familyOrderFeeInfo.getUserRange());

            Map inMap = new HashMap();
            inMap.put("header", map.get("header"));
            inMap.put("oprInfo", map.get("oprInfo"));
            inMap.put("busiInfo", familyAddFeeInfo);

            Map addMap = iFamilyAddFeeInfoQryAo.qryFamilyAddFeeInfo(inMap);

            System.out.println(JSON.toJSONString(orderMap));
            System.out.println(JSON.toJSONString(addMap));

            ArrayList orderlist = (ArrayList) orderMap.get("GOODSLIST");
            ArrayList addlist = (ArrayList) addMap.get("GOODSINFOLIST");

            for (int i = 0; i < addlist.size(); i++) {
                HashMap iMap = (HashMap) addlist.get(i);
                ArrayList prclist = (ArrayList) iMap.get("PRCINFOLIST");

                for (int j = 0; j < orderlist.size(); j++) {
                    HashMap jMap = (HashMap) orderlist.get(j);

                    if (iMap.get("GOODS_ID").equals(jMap.get("GOODS_ID"))) {
                        for (int k = 0; k < prclist.size(); k++) {
                            HashMap kMap = (HashMap) prclist.get(k);

                            if (jMap.get("PRC_ID").equals(kMap.get("PRC_ID"))) {
                                ((HashMap) ((ArrayList) addMap.get("GOODSINFOLIST")).get(i)).put("ORDER_PRC_ID", kMap.get("PRC_ID"));
                                break;
                            }
                        }
                    }
                }
            }

            return addMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
