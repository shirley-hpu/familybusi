package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyGoods;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author wusm
 * @description 套餐查询原子实体
 * @date 2019/1/18 09:17
 */
@Component("SearchPgPrcAo")
public class SearchPgPrcAo implements IGoodsQryAo {

    private static Logger logger = LoggerFactory.getLogger(SearchPgPrcAo.class);

    @Autowired
    private IServiceClient serviceClient;

    @Value(value = "classpath:jsonfiles/goods")
    private org.springframework.core.io.Resource resource;

    @Autowired
    private JsonReader jsonReader;


    /**
     * 原子服务产商品公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        OutDTO<Map> mapOutDTO = new OutDTO<>();
        Map searchMap = new HashMap();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");

            FamilyGoods familyGoods = (FamilyGoods) map.get("BUSI_INFO");

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PRC_USE_RANGE", "");
            busiMap.put("GROUP_ID", oprInfo.getGroupId());
            busiMap.put("MAIN_PG_PRCID", familyGoods.getPrcId());
            busiMap.put("MASTER_SERV_ID", familyGoods.getMasterServId());
            busiMap.put("GOODS_TYPE", familyGoods.getGoodsType());
            busiMap.put("RUN_FLAG", familyGoods.getRunFlag());
            busiMap.put("USER_MAIN_PRCID", "");
            busiMap.put("USER_RANGE", familyGoods.getUserRange());
            busiMap.put("CLASS_ID", "");
            busiMap.put("RELEASE_FLAG", "");
            busiMap.put("SHOW_FLAG", "");
            busiMap.put("CHANNEL_ID", familyGoods.getChannelId());
            busiMap.put("GROUP_TYPE", "");
            busiMap.put("BRAND_ID", "");
            busiMap.put("PRC_CLASS", "");
            busiMap.put("ID_NO", "");
            busiMap.put("PRC_NAME", "");

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sSearchPgPrcSvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            Map<Object, JSONArray> mapData = mapOutDTO.getBodyOutData();

            JSONArray arrayList = mapData.get("LIST");

            List<Map> mapList = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                Map<String, Object> goodsMap = new HashMap<>();

                goodsMap.put("GOODS_ID",arrayList.getJSONObject(i).getString("GOODS_ID"));
                goodsMap.put("GOODS_NAME",arrayList.getJSONObject(i).getString("GOODS_NAME"));
                goodsMap.put("GOODS_TYPE", arrayList.getJSONObject(i).getString("GOODS_TYPE"));
                goodsMap.put("EXP_DATE", arrayList.getJSONObject(i).getString("EXP_DATE"));
                goodsMap.put("EFF_DATE", arrayList.getJSONObject(i).getString("EFF_DATE"));
                goodsMap.put("MASTER_SERV_ID", arrayList.getJSONObject(i).getString("MASTER_SERV_ID"));
                goodsMap.put("PRC_ID", arrayList.getJSONObject(i).getString("PRC_ID"));
                goodsMap.put("USE_RANGE", arrayList.getJSONObject(i).getString("USE_RANGE"));
                goodsMap.put("PRC_NAME", arrayList.getJSONObject(i).getString("PRC_NAME"));
                goodsMap.put("PRC_DESC", arrayList.getJSONObject(i).getString("PRC_DESC"));
                goodsMap.put("PRC_TYPE", arrayList.getJSONObject(i).getString("PRC_TYPE"));

                mapList.add(goodsMap);
            }

            searchMap.put("GOODSLIST", mapList);

            return searchMap;
        } catch (Exception e) {
            logger.error("家庭套餐查询失败" + e.getMessage());
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
