package com.sitech.family.custqryservice.compbusi.impl;

import com.alibaba.fastjson.JSON;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsAttrInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.custqryservice.compbusi.IFamilyOrderAddGoodsCo;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-19 16:51
 * @Version: 1.0
 */
@Component
public class FamilyOrderAddGoodsCo implements IFamilyOrderAddGoodsCo {

    @Autowired
    private IFamilyUserGoodsInfo iFamilyUserGoodsInfo;

    @Autowired
    private IFamilyUserGoodsAttrInfo iFamilyUserGoodsAttrInfo;

    /**
     * 家庭已订购附加商品信息查询
     *
     * @param map
     * @return list
     */
    @Override
    public Map qryFamilyOrderAdditionGoods(Map<String, String> map) {

        try {
            List<UserGoodsInfo> list = iFamilyUserGoodsInfo.qryUserGoodsList(map);

            List<Map> goodsList = new ArrayList<>();
            for (UserGoodsInfo userGoodsInfo : list) {
                Map<String, Object> goodsMap = new HashMap<>();
                goodsMap.put("GOODS_TYPE", userGoodsInfo.getMainFlag());
                goodsMap.put("GOODS_ID", userGoodsInfo.getGoodsId());
                goodsMap.put("PRC_ID", userGoodsInfo.getPrcId());

                Map<String, String> attrMap = new HashMap<>();
                attrMap.put("goodsinsId", String.valueOf(userGoodsInfo.getInsValue()));

                List<UserGoodsAttrInfo> userGoodsAttrInfoList = iFamilyUserGoodsAttrInfo.qryUserGoodsAttrInfoList(attrMap);

                List<Map> attrList = new ArrayList<>();
                for (UserGoodsAttrInfo userGoodsAttrInfo : userGoodsAttrInfoList) {
                    Map<String, String> goodsAttrMap = new HashMap<>();
                    goodsAttrMap.put("ATTR_ID", userGoodsAttrInfo.getAttrId());
                    goodsAttrMap.put("ATTR_NO", userGoodsAttrInfo.getAttrNo());
                    goodsAttrMap.put("ATTR_VALUE", userGoodsAttrInfo.getAttrValue());
                    attrList.add(goodsAttrMap);
                }
                goodsMap.put("ATTR_LIST", attrList);

                goodsList.add(goodsMap);
            }

            Map<String, Object> outMap = new HashMap<>();
            outMap.put("GOODS_LIST", goodsList);

            return outMap;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
