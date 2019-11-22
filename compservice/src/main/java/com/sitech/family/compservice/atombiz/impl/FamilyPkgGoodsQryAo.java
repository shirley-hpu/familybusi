package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyPkgGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-24 09:58
 * @Version: 1.0
 */
@Component("familyPkgGoodsQryAo")
public class FamilyPkgGoodsQryAo implements IGoodsQryAo {

    @Autowired
    private IServiceClient serviceClient;

    /**
     * 原子服务产商品公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        Map outMap = new HashMap();
        OutDTO<Map> mapOutDTO = new OutDTO<>();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            FamilyPkgGoodsInfo familyPkgGoodsInfo = (FamilyPkgGoodsInfo) map.get("busiInfo");

            Map<String, String> busiMap = new HashMap<>();
            busiMap.put("GOODS_ID", familyPkgGoodsInfo.getGoodsId());
            busiMap.put("PRC_ID", familyPkgGoodsInfo.getPrcId());

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyPkgGoodsInfoQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            JSONObject jsonObject = (JSONObject) mapOutDTO.getBodyOutData();

            Map<String,String> jsonMap = new HashMap<>();

            if (jsonObject.size() > 0){
                jsonMap.put("PRC_ID",jsonObject.getString("prcId"));
                jsonMap.put("GOODS_ID",jsonObject.getString("goodsId"));
                jsonMap.put("EXP_DATE",jsonObject.getString("expDate"));
                jsonMap.put("USER_RANGE",jsonObject.getString("userRange"));
                jsonMap.put("EFF_DATE",jsonObject.getString("effDate"));
                jsonMap.put("PRC_NAME",jsonObject.getString("prcName"));
                jsonMap.put("STATE",jsonObject.getString("state"));
                jsonMap.put("PRC_TYPE",jsonObject.getString("prcType"));
                jsonMap.put("MAX_NUM",jsonObject.getString("maxNum"));
                jsonMap.put("MIN_NUM",jsonObject.getString("minNum"));
                jsonMap.put("PRC_DESC",jsonObject.getString("goodsPrcDesc"));
            }

            outMap.put("PKGGOODSINFO", jsonMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
        return outMap;
    }
}
