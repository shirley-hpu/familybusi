package com.sitech.preservice.atombusi.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IFamilyGoodsInfoQryAo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Component("FamilyGoodsInfoQryAo")
public class FamilyGoodsInfoQryAo implements IFamilyGoodsInfoQryAo {

    @Resource
    private IServiceClient serviceClient;
    @Value("classpath:jsonfiles/familyGoods")
    private org.springframework.core.io.Resource resource;

    @Override
    public OutDTO<Map> qryFamilyGoodsInfoByPrc(Map<String, Object> inMap) {

        MBean mBean = new MBean();
        OutDTO<Map> outDTO = new OutDTO<>();
        try {
            Header header = (Header) inMap.get("header");
            Routing routing = new Routing();
            routing.setRouteValue("16");
            routing.setRouteKey("15");
            header.setRouting(routing);

            Map map = (Map) inMap.get("busiInfo");
            mBean.setHeader(header);
            mBean.setBody(map);

            outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/rest/com_sitech_crmoup_fam_inter_IFindFamPrcCoSvc_qryFamPrcInfo",
                    mBean.toString(),OutDTO.class,ArchitectureType.ESB_REST);
        }catch (Exception e){
            throw new BusiException("02",e.getMessage());
        }


        //模拟测试数据

//        try {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream()));
//            StringBuilder message = new StringBuilder();
//            String line = null;
//            while((line = bf.readLine()) != null){
//                message.append(line);
//            }
//            String defaultString = message.toString();
//            String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
//            JSONObject jsonObject = JSONObject.parseObject(result).getJSONObject("ROOT").getJSONObject("BODY").getJSONObject("OUT_DATA");
//            outDTO.setBodyOutData(jsonObject);
//        } catch (IOException e) {
//            throw  new BusiException("777",e.getMessage());
//        }
        return outDTO;
    }
}
