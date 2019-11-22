package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsMbrQry;
import com.sitech.family.compservice.dto.indto.MbrGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 成员资费查询
 *
 * @author shirley
 * @date created in 2019/3/4
 */
@Component("qryFamilyMbrGoodsAo")
public class GoodsMbrQryAo implements IGoodsQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Value(value = "classpath:jsonfiles/detail")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    private static final Logger logger = LoggerFactory.getLogger(GoodsMbrQryAo.class);


    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            //获取业务层传入数据

            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            FamilyGoodsMbrQry familyGoodsInfo = (FamilyGoodsMbrQry) inDTO.get("BUSI_INFO");
            MbrGoodsInfo goodsInfo = familyGoodsInfo.getFamilyGoodsInfo();

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PAR_GOODS_ID", goodsInfo.getGoodsId());
            busiMap.put("PACKGE_PRC", goodsInfo.getPrcId());
            mBean.addBody("BUSI_INFO", busiMap);

            logger.debug("MBean ==> " + mBean.toString());

            //调用产商品中心服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://pgcent-family/sPrcDetailQryAoSvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());

            //真实数据出参校验
            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            //String result = jsonReader.parseJson(resource);

            //假数据解析
            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("GOODS_LIST");

            //logger.debug(jsonObject.toJSONString());

            //定义出参存入假数据
            Map<String, JSONArray> map = new HashMap<>();
            map.put("GOODS_LIST", outData);
            return map;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", e.getMessage());
        }
    }
}
