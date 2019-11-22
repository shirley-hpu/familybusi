package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.IFamilyAddFeeInfoQryAo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyAddFeeInfoQryCo;
import com.sitech.family.compservice.dto.indto.FamilyAddFeeInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-07-31 15:54
 * @Version: 1.0
 */
@Component
public class FamilyAddFeeInfoQryCo implements IFamilyAddFeeInfoQryCo {

    @Resource(name = "familyAddFeeInfoQryAo")
    private IFamilyAddFeeInfoQryAo familyAddFeeInfoQryAo;

    @Resource(name = "AttrArrayQryAo")
    private IGoodsQryAo attrArrayQryAo;

    /**
     * 附加资费全量信息
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map qryFamilyAddFeeInfo(Map<String, Object> map) {
        try {
            Map goodsMap = familyAddFeeInfoQryAo.qryFamilyAddFeeInfo(map);

            /*ArrayList list = (ArrayList) goodsMap.get("GOODSINFOLIST");

            for (int i = 0; i < list.size(); i++) {
                HashMap hashMap = (HashMap) list.get(i);
                String goodsId = String.valueOf(hashMap.get("GOODS_ID"));

                ArrayList prcList = (ArrayList) hashMap.get("PRCINFOLIST");

                for (int j = 0; j < prcList.size(); j++) {
                    HashMap prcMap = (HashMap) prcList.get(j);
                    String prcId = String.valueOf(prcMap.get("PRC_ID"));

                    Map attrMap = new HashMap();
                    attrMap.put("header", map.get("header"));
                    attrMap.put("oprInfo", map.get("oprInfo"));
                    attrMap.put("GOODS_ID", goodsId);
                    attrMap.put("PRC_ID", prcId);
                    attrMap.put("MEMBER_ROLE_ID", ((FamilyAddFeeInfo) map.get("busiInfo")).getMemberRoleId());

                    Map elementMap = attrArrayQryAo.query(attrMap);

                    if (!elementMap.isEmpty()){
                        ((HashMap) ((ArrayList) hashMap.get("PRCINFOLIST")).get(j)).put("ATTRLIST",elementMap.get("ATTR_LIST"));
                    }
                }
            }*/

            return goodsMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
