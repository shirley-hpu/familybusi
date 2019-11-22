package com.sitech.preservice.atombusi.impl;



import com.alibaba.fastjson.JSONObject;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IFamilyUserPreGoodsQryAo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Component("FamilyUserPreGoodsQryAo")
public class FamilyUserPreGoodsQryAo implements IFamilyUserPreGoodsQryAo {

    @Resource
    private IServiceClient serviceClient;
    @Value("classpath:jsonfiles/recommendGoods")
    private org.springframework.core.io.Resource resource;

    @Override
    public OutDTO<Map> qryFamilyUserPreGoods(Map<String, Object> inMap) {

        MBean mBean = new MBean();
        OutDTO outDTO = new OutDTO();
        try {
            Header header = (Header) inMap.get("header");
            Routing routing = new Routing();
            routing.setRouteKey("15");
            routing.setRouteValue("16");
            header.setRouting(routing);

            Map busiInfo = (Map) inMap.get("busiInfo");
            String phoneNo = (String) busiInfo.get("PHONE_NO");

            mBean.setHeader((Map<String, Object>) header);
            mBean.setBody("PHONE_NO",phoneNo);

            outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/rest/com_sitech_crmoup_fam_inter_IOpenOrRecomPrcCoSvc_qryFamPrc",
                    mBean.toString(),OutDTO.class,ArchitectureType.ESB_REST);
        }catch (Exception e){
            throw new BusiException("02",e.getMessage());
        }

        //模拟测试数据
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
//            StringBuilder message = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                message.append(line);
//            }
//            String defaultString = message.toString();
//            String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
//
//            JSONObject jsonObject = JSONObject.parseObject(result).getJSONObject("ROOT").getJSONObject("BODY").getJSONObject("OUT_DATA");
//            outDTO.setBodyOutData(jsonObject);
//        } catch (IOException e) {
//            throw new BusiException("666",e.getMessage());
//        }

        return outDTO;
    }
}
