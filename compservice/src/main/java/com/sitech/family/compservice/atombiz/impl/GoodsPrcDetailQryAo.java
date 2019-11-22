package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.constants.ReturnCode;
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
 * @author shirley
 * @version 1.0
 * @description 资费构成查询服务接口
 * @date 2018/9/13 10:24
 **/
@Component("qryGoodsPrcDetailAo")
public class GoodsPrcDetailQryAo implements IGoodsQryAo {

    private static final Logger logger = LoggerFactory.getLogger(GoodsPrcDetailQryAo.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            //获取业务层传入数据
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            FamilyGoodsDetailQry familyGoodsInfo = (FamilyGoodsDetailQry) inDTO.get("BUSI_INFO");
            DetailGoodsInfo goodsInfo = familyGoodsInfo.getDetailGoodsInfo();

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PAR_GOODS_ID", goodsInfo.getGoodsId());
            busiMap.put("PACKGE_PRC", goodsInfo.getPrcId());
            mBean.addBody("BUSI_INFO", busiMap);

            logger.debug("MBean ==> " + mBean.toString());

            //调用产商品中心服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://pgcent-family/sGrpPrcDetailQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());

            //真实数据出参校验
            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            //假数据解析
            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("GROUP_ROLE_LIST");

            //定义出参存入假数据
            Map<String, JSONArray> map = new HashMap<>();
            map.put("GROUP_ROLE_LIST", outData);
            return map;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

    }


}
