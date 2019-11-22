package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.compservice.dto.outdto.FamilyMbrGoods;
import com.sitech.family.compservice.dto.outdto.FamilyMbrPrc;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author shirley
 * @date created in 2019/5/10
 */
@Component("qryHotPrcAo")
public class HotPrcQryAo implements IGoodsQryAo {



    private static final Logger logger = LoggerFactory.getLogger(HotPrcQryAo.class);

    @Resource
    private IServiceClient serviceClient;

    @Value(value = "classpath:jsonfiles/hotprc")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    @Override
    public Map query(Map<String, Object> inDTO) {
        //test测试用
//        IServiceClient serviceClient = SpringUtil.getBean(IServiceClient.class);

        try {
            //获取业务层传入数据
//            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            MBean mBean = new MBean();
            mBean.setHeader((Map)inDTO.get("header"));
            OprInfo oprInfo = (OprInfo)inDTO.get("oprInfo");

            mBean.setBody("OPR_INFO",oprInfo);

            FamilyGoodsDetailQry familyGoodsInfo = (FamilyGoodsDetailQry) inDTO.get("BUSI_INFO");
            DetailGoodsInfo goodsInfo = familyGoodsInfo.getDetailGoodsInfo();

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PKGPRC_ID", goodsInfo.getPrcId());
            mBean.addBody("BUSI_INFO", busiMap);

            logger.debug("MBean ==> " + mBean.toString());

            //调用产商品中心服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://pgcent-family/sPMemHotPrcQrySvc",mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);


            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());

        //真实数据出参校验
//        CommonCheckUtil.getOutParamCheck(mapOutDTO);

//        String result = jsonReader.parseJson(resource);

        //假数据解析
        JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
        JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                getJSONObject("OUT_DATA").getJSONArray("MBR_OPEN_LIST");

        logger.debug(jsonObject.toJSONString());

        List<FamilyMbrGoods> mbrGoodsPrcLists = new ArrayList<>();
        if( "".equals(goodsInfo.getMemberRoleId())){
            for(int i = 0;i< outData.size();i++){
                JSONObject jsonObjData = outData.getJSONObject(i);

                JSONArray mbrGoodsList = jsonObjData.getJSONArray("MBR_GOODS_LIST");
                FamilyMbrGoods mbrgoodsMap;
                for(int j = 0;j < mbrGoodsList.size();j++){
                    JSONObject mbrgoods = mbrGoodsList.getJSONObject(j);

                    mbrgoodsMap = new FamilyMbrGoods();

                    mbrgoodsMap.setMbrGoodsId(mbrgoods.getString("GOODS_ID"));
                    mbrgoodsMap.setMbrGoodsName(mbrgoods.getString("GOODS_NAME"));
                    mbrgoodsMap.setMbrGoodsDesc(mbrgoods.getString("GOODS_DESC"));
                    JSONArray mbrPrcList = mbrgoods.getJSONArray("MBR_PRC_LIST");

                    List<FamilyMbrPrc> mbrprcList = new ArrayList<>();
                    FamilyMbrPrc mbrprcMap;
                    for(int k = 0;k < mbrPrcList.size();k++){

                        mbrprcMap = new FamilyMbrPrc();
                        JSONObject mbrprc = mbrPrcList.getJSONObject(k);

                        mbrprcMap.setMbrPrcId(mbrprc.getString("MBR_PRC_ID"));
                        mbrprcMap.setMbrPrcName(mbrprc.getString("MBR_PRC_NAME"));
                        mbrprcMap.setMbrPrcDesc(mbrprc.getString("MBR_PRC_DESC"));

                        mbrprcList.add(mbrprcMap);
                    }
                    mbrgoodsMap.setMbrPrcList(mbrprcList);

                    mbrGoodsPrcLists.add(mbrgoodsMap);
                }

            }
        }else if(goodsInfo.getMemberRoleId() == null ){
            Map<String, JSONArray> map = new HashMap<>();
            map.put("MBR_OPEN_LIST", outData);
            logger.debug("MAP ===========> " + map);
            return map;
        }else{
            for(int i = 0;i< outData.size();i++){
                JSONObject jsonObjData = outData.getJSONObject(i);
                if(goodsInfo.getMemberRoleId().equals(jsonObjData.get("MEMBER_ROLE_ID").toString())){

                    JSONArray mbrGoodsList = jsonObjData.getJSONArray("MBR_GOODS_LIST");
                    FamilyMbrGoods mbrgoodsMap;
                    for(int j = 0;j < mbrGoodsList.size();j++){
                        JSONObject mbrgoods = mbrGoodsList.getJSONObject(j);

                        mbrgoodsMap = new FamilyMbrGoods();

                        mbrgoodsMap.setMbrGoodsId(mbrgoods.getString("GOODS_ID"));
                        mbrgoodsMap.setMbrGoodsName(mbrgoods.getString("GOODS_NAME"));
                        mbrgoodsMap.setMbrGoodsDesc(mbrgoods.getString("GOODS_DESC"));
                        JSONArray mbrPrcList = mbrgoods.getJSONArray("MBR_PRC_LIST");

                        List<FamilyMbrPrc> mbrprcList = new ArrayList<>();
                        FamilyMbrPrc mbrprcMap;
                        for(int k = 0;k < mbrPrcList.size();k++){

                            mbrprcMap = new FamilyMbrPrc();
                            JSONObject mbrprc = mbrPrcList.getJSONObject(k);

                            mbrprcMap.setMbrPrcId(mbrprc.getString("MBR_PRC_ID"));
                            mbrprcMap.setMbrPrcName(mbrprc.getString("MBR_PRC_NAME"));
                            mbrprcMap.setMbrPrcDesc(mbrprc.getString("MBR_PRC_DESC"));

                            mbrprcList.add(mbrprcMap);
                        }
                        mbrgoodsMap.setMbrPrcList(mbrprcList);

                        mbrGoodsPrcLists.add(mbrgoodsMap);
                    }
                }
            }
        }


        //定义出参存入假数据.
        Map<String, List<FamilyMbrGoods>> map = new HashMap<>();
        map.put("MBR_OPEN_LIST", mbrGoodsPrcLists);
        logger.debug("MAP ===========> " + map);
            return map;
        } catch (Exception e) {
            throw new BusiException("99999999999999999", "query failed", e.getMessage());
        }
    }
}