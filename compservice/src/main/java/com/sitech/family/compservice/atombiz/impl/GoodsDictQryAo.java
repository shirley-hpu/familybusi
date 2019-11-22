package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDictQry;
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
 * @version 1.0
 * @description 商品信息查询服务接口
 **/
@Component("qryGoodsDictAo")
public class GoodsDictQryAo implements IGoodsQryAo {


    private static final Logger logger = LoggerFactory.getLogger(GoodsDictQryAo.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            //获取业务层传入数据
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            FamilyGoodsDictQry goodsDictQry = (FamilyGoodsDictQry) inDTO.get("BUSI_INFO");

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("GOODS_ID", goodsDictQry.getGoodsId());
            busiMap.put("PRC_ID", goodsDictQry.getPrcId());
            mBean.addBody("BUSI_INFO", busiMap);

            logger.debug("MBean ==> " + mBean.toString());

            // todo 调用家客私有服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyGoodsDictQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());

            //真实数据出参校验
            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            //假数据解析
            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            JSONObject outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONObject("GOODS_PRC_INFO");

            //定义出参存入假数据
            Map<String, JSONObject> map = new HashMap<>();
            map.put("GOODS_PRC_INFO", outData);
            return map;
        } catch (Exception e) {
            throw new BusiException("处理失败", e.getMessage());
        }

    }


}
