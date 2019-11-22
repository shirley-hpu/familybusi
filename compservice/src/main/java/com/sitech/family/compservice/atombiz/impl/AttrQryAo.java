package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
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
 * 资费属性、服务属性查询
 *
 * @author shirley
 * @date created in 2019/3/27
 */
@Component("attrQryAo")
public class AttrQryAo implements IGoodsQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Resource
    private JsonReader jsonReader;

    @Value(value = "classpath:jsonfiles/attr")
    private org.springframework.core.io.Resource resource;

    private static final Logger logger = LoggerFactory.getLogger(AttrQryAo.class);

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            FamilyGoodsDetailQry familyGoodsInfo = (FamilyGoodsDetailQry) inDTO.get("BUSI_INFO");
            DetailGoodsInfo goodsInfo = familyGoodsInfo.getDetailGoodsInfo();

            Map<String, Object> busiMap = new HashMap<>();
            Map<String, Object> attrParam = new HashMap<>();
            attrParam.put("GOODS_ID", goodsInfo.getGoodsId());
            attrParam.put("PRC_ID", goodsInfo.getPrcId());
            attrParam.put("MEMBER_ROLE_ID", goodsInfo.getMemberRoleId());
            busiMap.put("ATTR_PARAM", attrParam);
            mBean.addBody("BUSI_INFO", busiMap);

            logger.debug("MBean ==> " + mBean.toString());

            //调用服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://pgcent-family/sAttrArrayQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());

            //出参校验
            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            //String result = jsonReader.parseJson(resource);

            //数据解析
            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("ATTR_LIST");

            //定义出参存入数据
            Map<String, JSONArray> map = new HashMap<>();
            map.put("ATTR_LIST", outData);
            return map;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", e.getMessage());
        }
    }
}
